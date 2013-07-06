/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "RADIOSTATION")
public class Radiostation implements Serializable {
    public static final int TYPE_STATION = 0;
    public static final int TYPE_VEHICLE = 1;
    public static final int TYPE_PERSONAL = 2;
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer type;
    private String power;
    private String frequencyRange;
    private Double selectivity2;
    private Double selectivity3;
    private Double cutoff;
    private Double sensitivity;

    @Column(name = "CUTOFF")
    public Double getCutoff() {
        return cutoff;
    }

    public void setCutoff(Double cutoff) {
        this.cutoff = cutoff;
    }

    @Column(name = "FREQUENCY_RANGE")
    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    @Id
    @GeneratedValue
    @Column(name = "RADIOSTATION_ID")
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

    @Column(name = "POWER")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Column(name = "SELECTIVITY2")
    public Double getSelectivity2() {
        return selectivity2;
    }

    public void setSelectivity2(Double selectivity2) {
        this.selectivity2 = selectivity2;
    }

    @Column(name = "SELECTIVITY3")
    public Double getSelectivity3() {
        return selectivity3;
    }

    public void setSelectivity3(Double selectivity3) {
        this.selectivity3 = selectivity3;
    }

    @Column(name = "SELECTIVITY")
    public Double getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Double sensitivity) {
        this.sensitivity = sensitivity;
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
