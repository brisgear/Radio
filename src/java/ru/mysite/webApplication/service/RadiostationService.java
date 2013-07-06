/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.service;

import java.util.List;
import ru.mysite.webApplication.domain.Radiostation;

/**
 *
 * @author Bris
 */
public interface RadiostationService {
    public void addRadiostation(Radiostation r);
    public void updateRadiostation(Radiostation r);
    public List<Radiostation> listRadiostation();
    public void removeRadiostation(Long id);
}
