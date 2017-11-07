package com.oneler.advice;

import com.oneler.domain.base.ResultBean;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FinalExceptionHandler implements ErrorController {

    @RequestMapping(value = "/error")
    public ResultBean error(HttpServletResponse resp, HttpServletRequest req) {
        // 错误处理逻辑

        return new ResultBean().failure(resp);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}