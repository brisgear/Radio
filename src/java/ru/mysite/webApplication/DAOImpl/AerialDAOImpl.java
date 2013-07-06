package ru.mysite.webApplication.DAOImpl;

import ru.mysite.webApplication.domain.Aerial;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ru.mysite.webApplication.DAO.AerialDAO;
@Repository
public class AerialDAOImpl implements AerialDAO {

	private HibernateTemplate hibernateTemplate;
        @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveAerial(Aerial aerial) {
		hibernateTemplate.save(aerial);
	}
        
        @Override
	public void updateAerial(Aerial aerial) {
		hibernateTemplate.update(aerial);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aerial> listAerial() {
		return hibernateTemplate.find("from Aerial");
	}

    @Override
    public void removeAerial(Long id) {
        hibernateTemplate.delete(hibernateTemplate.load(Aerial.class, id));
    }

}
