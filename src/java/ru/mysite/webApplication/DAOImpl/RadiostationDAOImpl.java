package ru.mysite.webApplication.DAOImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.mysite.webApplication.domain.Radiostation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mysite.webApplication.DAO.RadiostationDAO;

@Repository
public class RadiostationDAOImpl implements RadiostationDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveRadiostation(Radiostation radiostation) {
        hibernateTemplate.save(radiostation);
    }

    @Override
    public void updateRadiostation(Radiostation radiostation) {
        hibernateTemplate.update(radiostation);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Radiostation> listRadiostation() {
        return hibernateTemplate.find("from Radiostation");
    }

    @Override
    public void removeRadiostation(Long id) {
        hibernateTemplate.delete(hibernateTemplate.load(Radiostation.class, id));
    }
}
