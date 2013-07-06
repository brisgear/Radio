/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.controller;

import java.io.Serializable;
import java.lang.String;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mysite.webApplication.domain.Aerial;
import ru.mysite.webApplication.domain.RadiostationConfig;
import ru.mysite.webApplication.problem.TwoRadiostationsProblem;
import ru.mysite.webApplication.service.RadiostationConfigService;
import ru.mysite.webApplication.util.CalculationUtil;
/**
 *
 * @author minzhenkov
 */
@Controller
public class CalculationController {
    //private static final Logger log = Logger.getLogger(IndexController.class);
    @Autowired
    RadiostationConfigService rcService;
    
    @RequestMapping(value="/calculation/getTypeByName/{type}",method = {RequestMethod.GET})
    @ResponseBody public List<RadiostationConfig> getRadioMap(@PathVariable String type) {
        Map radioMap = new HashMap<String,String[]>();
        List<RadiostationConfig> listRS = rcService.findRadiostationConfigByTypeRadiostation(CalculationUtil.getTypeByName(type));
        return listRS;
    }
    
    @RequestMapping(value="/calculation/go",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody public ResultFromCalculation1 go(@ModelAttribute("problem") TwoRadiostationsProblem problem) {
        problem.setConfig1(rcService.findRadiostationConfigById(problem.getConfig1().getId()));
        problem.setConfig2(rcService.findRadiostationConfigById(problem.getConfig2().getId()));
        problem.solve();
        //что то надо делать
        //map.put("result", "Succes 8)");
        return new ResultFromCalculation1(problem.getR1(),problem.getR2());
    }
    @RequestMapping(value = "/calculation/go4android", method = RequestMethod.POST)
    public @ResponseBody List<Double> go4android(@RequestBody TwoRadiostationsProblem problem) {
        problem.setConfig1(rcService.findRadiostationConfigById(problem.getConfig1().getId()));
        problem.setConfig2(rcService.findRadiostationConfigById(problem.getConfig2().getId()));
        problem.solve();
        List<Double> res = new ArrayList<Double>();
        res.add(problem.getR1());
        res.add(problem.getR2());
        return res;
    }
    
    @RequestMapping(value="/calculation/first",method = RequestMethod.GET)
    public String first(Map<String, Object> map) {
        map.put("problem", new TwoRadiostationsProblem());
        map.put("typeRadiostation", CalculationUtil.TYPE_RADIOSTATION);
        map.put("radiostationConfigList", rcService.listRadiostationConfig());
        return "calculation1";
    }
    
    
    class ResultFromCalculation1 implements Serializable{
        double r1;
        double r2;

        public ResultFromCalculation1() {
        }

        public ResultFromCalculation1(double r1, double r2) {
            this.r1 = r1;
            this.r2 = r2;
        }
        
        public double getR1() {
            return r1;
        }

        public void setR1(double r1) {
            this.r1 = r1;
        }

        public double getR2() {
            return r2;
        }

        public void setR2(double r2) {
            this.r2 = r2;
        }  
    }
}
