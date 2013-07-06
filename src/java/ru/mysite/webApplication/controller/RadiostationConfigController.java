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
import ru.mysite.webApplication.domain.Cable;
import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.domain.RadiostationConfig;
import ru.mysite.webApplication.service.AerialService;
import ru.mysite.webApplication.service.CableService;
import ru.mysite.webApplication.service.RadiostationConfigService;
import ru.mysite.webApplication.service.RadiostationService;

/**
 *
 * @author Bris
 */
@Controller
public class RadiostationConfigController {

    @Autowired
    RadiostationConfigService radiostationConfigService;
    
    @Autowired
    AerialService aerialService;
    
    @Autowired
    CableService cableService;
    
    @Autowired
    RadiostationService radiostationService;
    

//    public void setRadiostationConfigService(RadiostationConfigService radiostationConfigService) {
//        this.radiostationConfigService = radiostationConfigService;
//    }
    @RequestMapping(value = "/radiostationConfig/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("radiostationConfig") RadiostationConfig radiostationConfig) {
        radiostationConfigService.addRadiostationConfig(radiostationConfig);
        return new ModelAndView("redirect:/radiostationConfig/list");
    }
    
    @RequestMapping(value = "/radiostationConfig/update", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute("radiostationConfig") RadiostationConfig radiostationConfig) {
        radiostationConfigService.updateRadiostationConfig(radiostationConfig);
        return new ModelAndView("redirect:/radiostationConfig/list");
    }

    @RequestMapping(value = "/radiostationConfig/delete/{id}", method = RequestMethod.DELETE)
    public ModelAndView del(@PathVariable("id") Long id) {
        radiostationConfigService.removeRadiostationConfig(id);
        return new ModelAndView("redirect:/radiostationConfig/list");
    }

    @RequestMapping("/radiostationConfig/list")
    public String list(Map<String, Object> map) {
        map.put("radiostationConfig", new RadiostationConfig());
        map.put("radiostationConfigList", radiostationConfigService.listRadiostationConfig());
        return "radiostationConfigForm";
    }

    @ModelAttribute("aerialList")
    public List<Aerial> populateAerialList() {
        return aerialService.listAerial();
    }
    
    @ModelAttribute("cableList")
    public List<Cable> populateCableList() {
        return cableService.listCable();
    }
    
    @ModelAttribute("radiostationList")
    public List<Radiostation> populateRadiostationList() {
        return radiostationService.listRadiostation();
    }
    
    @RequestMapping(value = "/radiostationConfig", method={RequestMethod.GET})
    public @ResponseBody List<RadiostationConfig> list4Android (Map<String, Object> map) {
        return radiostationConfigService.listRadiostationConfig();
    }
    
    @RequestMapping(value = "/radiostationConfig/add4android", method = RequestMethod.POST)
    public ModelAndView add4Android(@RequestBody RadiostationConfig radiostationConfig) {
        radiostationConfigService.addRadiostationConfig(radiostationConfig);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/radiostationConfig/update4android", method = RequestMethod.PUT)
    public ModelAndView update4Android(@RequestBody RadiostationConfig radiostationConfig) {
        radiostationConfigService.updateRadiostationConfig(radiostationConfig);
        return new ModelAndView("redirect:list");
    }
}
