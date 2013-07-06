/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Bris
 */
@Entity
@Table(name = "CABLE")
public class Cable implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Double fade;

    @Column(name = "FADE")
    public Double getFade() {
        return fade;
    }

    public void setFade(Double fade) {
        this.fade = fade;
    }

    @Id
    @GeneratedValue
    @Column(name = "CABLE_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + " - "+id;
    }
    
}
