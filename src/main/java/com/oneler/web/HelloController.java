package com.oneler.web;

import com.oneler.domain.Person;
import com.oneler.domain.base.ResultBean;
import com.oneler.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by opure on 2017/5/10.
 */
@Controller
public class HelloController {
    private static Object object = new Object();

    private static final SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int i;

    @Resource
    private PersonService personService;

    @RequestMapping("/index")
    public ModelAndView index(ModelMap modelMap) {
        ModelAndView m = new ModelAndView("hello");
        modelMap.addAttribute("he", "hellow");

        return m;
    }

    @ResponseBody
    @GetMapping("/test1")
    public Integer outPut() {
        return i++;
    }

    @GetMapping("/testdate")
    @ResponseBody
    public String date() throws ParseException {
        i++;
        Date d = s.parse("2015-03-29 19:29:" + i % 60);
        return d.toString();
    }

    @RequestMapping("/test")
    @ResponseBody
    public ResultBean<Person> userInfo( @Validated Person person, BindingResult bindingResult) {
      return new ResultBean<>(personService.savePerson(person));

    }

    public static void main(String[] args) {
        double a = 1.39E-43f;
        System.out.println(a);
    }


}
