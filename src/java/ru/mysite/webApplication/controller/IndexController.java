/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author minzhenkov
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    //private static final Logger log = Logger.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        System.out.println("hello!");
        //log.info("request index detected.");
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello world");
        return model;
    }
}
