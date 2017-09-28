package com.oneler.advice;

import com.oneler.domain.base.ResultBean;
import com.oneler.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler
    public ResultBean handleIllegalParamException(MethodArgumentNotValidException e) {

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String tips = "参数不合法";
        if (errors.size() > 0) {
            tips = errors.get(0).getDefaultMessage();
        }
        return new ResultBean(tips);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<String> handleInvalidInput(BusinessException ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.toString());
    }


 /*   @ExceptionHandler(BusinessException.class)
    public ResponseBean handleException(RuntimeException e, HttpServletRequest request) {
        logger.error("uri={} | requestBody={}", request.getRequestURI(), e);
        return new ResponseBean().failture(e);
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultBean processError(Exception e) {

        return new ResultBean(e.getMessage());
    }

}
