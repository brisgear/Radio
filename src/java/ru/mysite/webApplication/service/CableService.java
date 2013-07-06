/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.service;

import java.util.List;
import ru.mysite.webApplication.domain.Cable;

/**
 *
 * @author Bris
 */
public interface CableService {
    public void addCable(Cable c);
    public void updateCable(Cable c);
    public List<Cable> listCable();
    public void removeCable(Long id);
}
