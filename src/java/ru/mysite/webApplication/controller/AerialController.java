/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mysite.webApplication.domain.Aerial;
import ru.mysite.webApplication.service.AerialService;

/**
 *
 * @author Bris
 */
@Controller
public class AerialController {

    @Autowired
    AerialService aerialService;

//    public void setAerialService(AerialService aerialService) {
//        this.aerialService = aerialService;
//    }
    @RequestMapping(value = "/aerial/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute Aerial aerial) {
        aerialService.addAerial(aerial);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/aerial/update", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute("aerial") Aerial aerial) {
        aerialService.updateAerial(aerial);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/aerial/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView del(@PathVariable("id") Long id) {
        aerialService.removeAerial(id);
        return new ModelAndView("redirect:/aerial/list");
    }

    @RequestMapping("/aerial/list")
    public String list(Map<String, Object> map) {
        map.put("aerial", new Aerial());
        map.put("aerialList", aerialService.listAerial());
        return "aerialForm";
    }

    @RequestMapping(value = "/aerial", method = {RequestMethod.GET})
    public @ResponseBody
    List<Aerial> list4Android(Map<String, Object> map) {
        return aerialService.listAerial();
    }

    @RequestMapping(value = "/aerial/add4android", method = RequestMethod.POST)
    public ModelAndView add4Android(@RequestBody Aerial aerial) {
        aerialService.addAerial(aerial);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/aerial/update4android", method = RequestMethod.PUT)
    public ModelAndView update4Android(@RequestBody Aerial aerial) {
        aerialService.updateAerial(aerial);
        return new ModelAndView("redirect:list");
    }
}
