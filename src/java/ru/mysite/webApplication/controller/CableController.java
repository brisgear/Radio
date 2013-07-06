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
import ru.mysite.webApplication.DAO.CableDAO;
import ru.mysite.webApplication.domain.Cable;
import ru.mysite.webApplication.service.CableService;

/**
 *
 * @author Bris
 */
@Controller
public class CableController {

    @Autowired
    CableService cableService;

//    public void setCableService(CableService cableService) {
//        this.cableService = cableService;
//    }
    @RequestMapping(value = "/cable/add", method=RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("cable") Cable cable) {
            cableService.addCable(cable);
        return new ModelAndView("redirect:/cable/list");
    }
    
    @RequestMapping(value = "/cable/delete/{id}", method=RequestMethod.DELETE)
    public ModelAndView del(@PathVariable("id") Long id) {
            cableService.removeCable(id);
        return new ModelAndView("redirect:/cable/list");
    }   
    
    @RequestMapping(value = "/cable/update", method=RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute("cable") Cable cable) {
        cableService.updateCable(cable);
        return new ModelAndView("redirect:/cable/list");
    }
    
    @RequestMapping("/cable/list")
    public String list(Map<String, Object> map) {
        map.put("cable", new Cable());
        map.put("cableList", cableService.listCable());
        return "cableForm";
    }
    
    @RequestMapping(value = "/cable", method={RequestMethod.GET})
    public @ResponseBody List<Cable> list4Android (Map<String, Object> map) {
        return cableService.listCable();
    }
    
    @RequestMapping(value = "/cable/add4android", method = RequestMethod.POST)
    public ModelAndView add4Android(@RequestBody Cable cable) {
        cableService.addCable(cable);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/cable/update4android", method = RequestMethod.PUT)
    public ModelAndView update4Android(@RequestBody Cable cable) {
        cableService.updateCable(cable);
        return new ModelAndView("redirect:list");
    }
}
