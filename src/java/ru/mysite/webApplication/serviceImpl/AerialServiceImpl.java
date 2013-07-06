/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysite.webApplication.DAO.AerialDAO;
import ru.mysite.webApplication.domain.Aerial;
import ru.mysite.webApplication.service.AerialService;

/**
 *
 * @author Bris
 */
@Service
public class AerialServiceImpl implements AerialService {

    @Autowired
    AerialDAO aerialDAO;

//    void setAerialDAO(AerialDAO aerialDAO) {
//        this.aerialDAO = aerialDAO;
//    }

    @Transactional
    @Override
    public void addAerial(Aerial aerial) {
        aerialDAO.saveAerial(aerial);
    }
    
    @Transactional
    @Override
    public void updateAerial(Aerial aerial) {
        aerialDAO.updateAerial(aerial);
    }

    @Transactional
    @Override
    public List<Aerial> listAerial() {
        return aerialDAO.listAerial();
    }

    @Transactional
    @Override
    public void removeAerial(Long id) {
        aerialDAO.removeAerial(id);
    }
}
