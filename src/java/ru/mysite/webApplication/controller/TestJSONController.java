/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.controller;

import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mysite.webApplication.DAO.RadiostationConfigDAO;
import ru.mysite.webApplication.domain.Cable;
import ru.mysite.webApplication.domain.RadiostationConfig;

/**
 *
 * @author Bris
 */
@Controller
@RequestMapping("/test/{id}")
public class TestJSONController {
    @Autowired
    SessionFactory session;
    
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody public RadiostationConfig testJSON(@PathVariable("id") Long id) {
        RadiostationConfig rc = (RadiostationConfig)session.openSession().createQuery("from RadiostationConfig where id="+id).uniqueResult();
        return rc;
    }
}
