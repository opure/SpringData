package com.oneler.web;

import com.oneler.domain.Person;
import com.oneler.domain.base.ResultBean;
import com.oneler.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by opure on 2017/5/10.
 */
@Controller
public class HelloController {

    @Resource
    private PersonService personService;

    @RequestMapping("/index")
    public ModelAndView index(ModelMap modelMap) {
        ModelAndView m = new ModelAndView("hello");
        modelMap.addAttribute("he", "hellow");

        return m;
    }


    @RequestMapping("/test")
    @ResponseBody
    public ResultBean<Person> userInfo(Person person) throws MethodArgumentNotValidException {
        return new ResultBean<>(personService.savePerson(person));
    }


}
