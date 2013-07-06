package ru.mysite.webApplication.DAO;

import java.util.List;
import ru.mysite.webApplication.domain.Radiostation;

public interface RadiostationDAO {
	
	public void saveRadiostation(Radiostation rs);
        public void updateRadiostation(Radiostation rs);
	public List<Radiostation> listRadiostation();
        public void removeRadiostation(Long id);
}
