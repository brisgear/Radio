/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Bris
 */
@Entity
@Table(name = "RADIOSTATION_CONFIG")
public class RadiostationConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Radiostation radiostation;
    private Cable cable;
    private Aerial aerial;

    private String identity;
//    private String title;
//
//    public String getTitle() {
//        return getIdentity()+"("+getRadiostation().getName()+")";
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
    
    private String description;
    private String placement;

    private double cableLength;
    private double aerialHeight;

    private String selectedPower;
    private double frequency;
    private boolean hasOwnU2min;
    private double u2min;
    private double sensitivity;

    private double azimuth;
    private double longitude;
    private double latitude;
    
    @OneToOne(fetch= FetchType.EAGER)
    public Aerial getAerial() {
        return aerial;
    }

    public void setAerial(Aerial aerial) {
        this.aerial = aerial;
    }

    @Column(name = "AERIAL_HEIGHT")
    public double getAerialHeight() {
        return aerialHeight;
    }

    public void setAerialHeight(double aerialHeight) {
        this.aerialHeight = aerialHeight;
    }

    @Column(name = "AZIMUTH")
    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    @OneToOne(fetch= FetchType.EAGER)
    public Cable getCable() {
        return cable;
    }

    public void setCable(Cable cable) {
        this.cable = cable;
    }

    @Column(name = "CABLE_LENGHT")
    public double getCableLength() {
        return cableLength;
    }

    public void setCableLength(double cableLength) {
        this.cableLength = cableLength;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "FREQUENCY")
    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Column(name = "HAS_OWN_U2MIN")
    public boolean isHasOwnU2min() {
        return hasOwnU2min;
    }

    public void setHasOwnU2min(boolean hasOwnU2min) {
        this.hasOwnU2min = hasOwnU2min;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "RC_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "IDENTITY")
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Column(name = "LATITUDE")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "LONGITUDE")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "PLACEMENT")
    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @OneToOne(fetch= FetchType.EAGER)
    public Radiostation getRadiostation() {
        return radiostation;
    }

    public void setRadiostation(Radiostation radiostation) {
        this.radiostation = radiostation;
    }

    @Column(name = "SELECTED_POWER")
    public String getSelectedPower() {
        return selectedPower;
    }

    
    public void setSelectedPower(String selectedPower) {
        this.selectedPower = selectedPower;
    }

    @Column(name = "SENSIVITY")
    public double getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(double sensitivity) {
        this.sensitivity = sensitivity;
    }

    @Column(name = "U2MIN")
    public double getU2min() {
        return u2min;
    }

    public void setU2min(double u2min) {
        this.u2min = u2min;
    }

    @Transient
    @JsonIgnore
    public double getNormalizedHeight() {
        if (this.getRadiostation() == null) {
            return 0;
        }

        if (aerialHeight == 0.0 && this.getRadiostation().getType() == Radiostation.TYPE_PERSONAL) {
            return 1.5;
        } else if (aerialHeight == 0.0 && this.getRadiostation().getType() == Radiostation.TYPE_VEHICLE) {
            return 5;
        } else {
            return aerialHeight;
        }
    }

    public double calcBm() {
        Radiostation r = this.radiostation;
        String power = r.getPower();
        Double p = Double.parseDouble(power);
        return 10 * Math.log10(12 / p);
    }
  
}
