package ru.mysite.webApplication.DAO;

import java.util.List;
import ru.mysite.webApplication.domain.RadiostationConfig;

public interface RadiostationConfigDAO {
	
	public void saveRadiostationConfig(RadiostationConfig rsc);
        public void updateRadiostationConfig(RadiostationConfig rsc);
	public List<RadiostationConfig> listRadiostationConfig();
        public List<RadiostationConfig> findRadiostationConfigByTypeRadiostation(int type);
        public RadiostationConfig findRadiostationConfigById(Long id);
        public void removeRadiostationConfig(Long id);
}
