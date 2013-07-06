/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysite.webApplication.DAO.RadiostationDAO;
import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.service.RadiostationService;

/**
 *
 * @author Bris
 */
@Service
public class RadiostationServiceImpl implements RadiostationService {

    @Autowired
    RadiostationDAO radiostationDAO;

//    void setRadiostationDAO(RadiostationDAO radiostationDAO) {
//        this.radiostationDAO = radiostationDAO;
//    }

    @Transactional
    @Override
    public void addRadiostation(Radiostation radiostation) {
        radiostationDAO.saveRadiostation(radiostation);
    }
    
    @Transactional
    @Override
    public void updateRadiostation(Radiostation radiostation) {
        radiostationDAO.updateRadiostation(radiostation);
    }

    @Transactional
    @Override
    public List<Radiostation> listRadiostation() {
        return radiostationDAO.listRadiostation();
    }

    @Transactional
    @Override
    public void removeRadiostation(Long id) {
        radiostationDAO.removeRadiostation(id);
    }
}
