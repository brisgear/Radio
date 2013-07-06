/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.service;

import java.util.List;
import ru.mysite.webApplication.domain.Aerial;

/**
 *
 * @author Bris
 */
public interface AerialService {
    
    public void addAerial(Aerial a);
    public void updateAerial(Aerial a);
    public List<Aerial> listAerial();
    public void removeAerial(Long id);
}
