package ru.mysite.webApplication.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AERIAL")
public class Aerial implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer type;
    private boolean directed = true;
    private Double amp;
    private String ampPoints;

    @Column(name = "AMP")
    public Double getAmp() {
        return amp;
    }

    public void setAmp(Double amp) {
        this.amp = amp;
    }

    @Column(name = "AMPPOINTS")
    public String getAmpPoints() {
        return ampPoints;
    }

    public void setAmpPoints(String ampPoints) {
        this.ampPoints = ampPoints;
    }

    @Column(name = "DIRECTED")
    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    @Id
    @GeneratedValue
    @Column(name = "AERIAL_ID")
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

    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " - "+id;
    }
    
    
}
