package ru.mysite.webApplication.DAOImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.mysite.webApplication.domain.Cable;
import ru.mysite.webApplication.domain.Radiostation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mysite.webApplication.DAO.CableDAO;

@Repository
public class CableDAOImpl implements CableDAO {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveCable(Cable cable) {
        hibernateTemplate.save(cable);
    }
    
    @Override
    public void updateCable(Cable cable) {
        hibernateTemplate.update(cable);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cable> listCable() {
        return hibernateTemplate.find("from Cable");
    }

    @Override
    public void removeCable(Long id) {
        hibernateTemplate.delete(hibernateTemplate.load(Cable.class, id));
    }
}
