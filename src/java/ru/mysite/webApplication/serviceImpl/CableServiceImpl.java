/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysite.webApplication.DAO.CableDAO;
import ru.mysite.webApplication.domain.Cable;
import ru.mysite.webApplication.service.CableService;

/**
 *
 * @author Bris
 */
@Service
public class CableServiceImpl implements CableService {

    @Autowired
    CableDAO cableDAO;

//    void setCableDAO(CableDAO cableDAO) {
//        this.cableDAO = cableDAO;
//    }

    @Transactional
    @Override
    public void addCable(Cable cable) {
        cableDAO.saveCable(cable);
    }
    
    @Transactional
    @Override
    public void updateCable(Cable cable) {
        cableDAO.updateCable(cable);
    }

    @Transactional
    @Override
    public List<Cable> listCable() {
        return cableDAO.listCable();
    }

    @Transactional
    @Override
    public void removeCable(Long id) {
        cableDAO.removeCable(id);
    }
}
