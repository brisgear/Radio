/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysite.webApplication.DAO.RadiostationConfigDAO;
import ru.mysite.webApplication.domain.RadiostationConfig;
import ru.mysite.webApplication.service.RadiostationConfigService;

/**
 *
 * @author Bris
 */
@Service
public class RadiostationConfigServiceImpl implements RadiostationConfigService {

    @Autowired
    RadiostationConfigDAO rcd;

//    void setRadiostationConfigDAO(RadiostationConfigDAO rcd) {
//        this.rcd = rcd;
//    }
    @Transactional
    @Override
    public void addRadiostationConfig(RadiostationConfig rc) {
        rcd.saveRadiostationConfig(rc);
    }

    @Transactional
    @Override
    public void updateRadiostationConfig(RadiostationConfig rc) {
        rcd.updateRadiostationConfig(rc);
    }

    @Transactional
    @Override
    public List<RadiostationConfig> listRadiostationConfig() {
        return rcd.listRadiostationConfig();
    }

    @Transactional
    @Override
    public List<RadiostationConfig> findRadiostationConfigByTypeRadiostation(int type) {
        return rcd.findRadiostationConfigByTypeRadiostation(type);
    }
    
    @Transactional
    @Override
    public RadiostationConfig findRadiostationConfigById(Long id){
        return rcd.findRadiostationConfigById(id);
    }

    @Transactional
    @Override
    public void removeRadiostationConfig(Long id) {
        rcd.removeRadiostationConfig(id);
    }
}
