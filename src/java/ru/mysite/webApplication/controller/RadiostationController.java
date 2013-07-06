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
import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.service.RadiostationService;

/**
 *
 * @author Bris
 */
@Controller
public class RadiostationController {

    @Autowired
    RadiostationService radiostationService;

//    public void setRadiostationService(RadiostationService radiostationService) {
//        this.radiostationService = radiostationService;
//    }
    @RequestMapping(value = "/radiostation/add", method=RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("radiostation") Radiostation radiostation) {
        System.out.println("Add method called");
            radiostationService.addRadiostation(radiostation);
        return new ModelAndView("redirect:/radiostation/list");
    }
    
    @RequestMapping(value = "/radiostation/update", method=RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute("radiostation") Radiostation radiostation) {
        System.out.println("Add method called");
            radiostationService.updateRadiostation(radiostation);
        return new ModelAndView("redirect:/radiostation/list");
    }
    
    @RequestMapping(value = "/radiostation/delete/{id}", method=RequestMethod.DELETE)
    public ModelAndView del(@PathVariable("id") Long id) {
            radiostationService.removeRadiostation(id);
        return new ModelAndView("redirect:/radiostation/list");
    }     
    
    @RequestMapping("/radiostation/list")
    public String list(Map<String, Object> map) {
        map.put("radiostation", new Radiostation());
        map.put("radiostationList", radiostationService.listRadiostation());
        return "radiostationForm";
    }
    
    @RequestMapping(value = "/radiostation", method={RequestMethod.GET})
    public @ResponseBody List<Radiostation> list4Android (Map<String, Object> map) {
        return radiostationService.listRadiostation();
    }
    
    @RequestMapping(value = "/radiostation/add4android", method = RequestMethod.POST)
    public ModelAndView add4Android(@RequestBody Radiostation radiostation) {
        radiostationService.addRadiostation(radiostation);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/radiostation/update4android", method = RequestMethod.PUT)
    public ModelAndView update4Android(@RequestBody Radiostation radiostation) {
        radiostationService.updateRadiostation(radiostation);
        return new ModelAndView("redirect:list");
    }
}
