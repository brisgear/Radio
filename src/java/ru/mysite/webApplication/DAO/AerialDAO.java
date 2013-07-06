package ru.mysite.webApplication.DAO;

import java.util.List;
import ru.mysite.webApplication.domain.Aerial;

public interface AerialDAO {
	
	public void saveAerial(Aerial a);
        public void updateAerial(Aerial a) ;
	public List<Aerial> listAerial();
        public void removeAerial(Long id);
}
