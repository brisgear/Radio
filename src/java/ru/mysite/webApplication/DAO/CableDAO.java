package ru.mysite.webApplication.DAO;

import java.util.List;
import ru.mysite.webApplication.domain.Cable;

public interface CableDAO {
	
	public void saveCable(Cable cable) ;
        public void updateCable(Cable cable) ;
	public List<Cable> listCable() ;
        public void removeCable(Long id);
}
