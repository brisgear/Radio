package ru.mysite.webApplication.DAOImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.mysite.webApplication.domain.RadiostationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mysite.webApplication.DAO.RadiostationConfigDAO;

@Repository
public class RadiostationConfigDAOImpl implements RadiostationConfigDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveRadiostationConfig(RadiostationConfig rcg) {
        hibernateTemplate.save(rcg);
    }
    
    @Override
    public void updateRadiostationConfig(RadiostationConfig rcg) {
        hibernateTemplate.update(rcg);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RadiostationConfig> listRadiostationConfig() {
        return hibernateTemplate.find("from RadiostationConfig");
    }

    @SuppressWarnings("unchecked")
    public List<RadiostationConfig> findRadiostationConfigByTypeRadiostation(int type) {
        return hibernateTemplate.find("from RadiostationConfig rc where rc.radiostation.type ="+type);
    }
    
    @SuppressWarnings("unchecked")
    public RadiostationConfig findRadiostationConfigById(Long id) {
        return (RadiostationConfig)hibernateTemplate.find("from RadiostationConfig rc where rc.id ="+id).get(0);
    }
    
    @Override
    public void removeRadiostationConfig(Long id) {
        hibernateTemplate.delete(hibernateTemplate.load(RadiostationConfig.class, id));
    }
}
