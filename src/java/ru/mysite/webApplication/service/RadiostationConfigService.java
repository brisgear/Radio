/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.service;

import java.util.List;
import ru.mysite.webApplication.domain.RadiostationConfig;

/**
 *
 * @author Bris
 */
public interface RadiostationConfigService {
    public void addRadiostationConfig(RadiostationConfig rc);
    public void updateRadiostationConfig(RadiostationConfig rc);
    public List<RadiostationConfig> listRadiostationConfig();
    public List<RadiostationConfig> findRadiostationConfigByTypeRadiostation(int type);
    public RadiostationConfig findRadiostationConfigById(Long id);
    public void removeRadiostationConfig(Long id);
}
