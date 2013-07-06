/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.problem;

import java.util.List;
import org.apache.commons.math.FunctionEvaluationException;
import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.domain.RadiostationConfig;
import ru.mysite.webApplication.function.Correction22Function;
import ru.mysite.webApplication.function.Table22Function;

/**
 *
 * @author Bris
 */
public class TwoRadiostationsProblem {

    static public final int TRACK_OPEN = 0;
    static public final int TRACK_CLOSED_CITY = 1;
    static public final int TRACK_CLOSED_RAILWAY = 2;
    private double distance;
    private boolean calculateDistance = false;
    private int trackType;
    protected RadiostationConfig config1;
    protected RadiostationConfig config2;
    private RadiostationType radiostationType;
    private int stationType;
    private double quality;
    private double r1;
    private double r2;

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public int getStationType() {
        return stationType;
    }

    public void setStationType(int stationType) {
        this.stationType = stationType;
    }


    public boolean isCalculateDistance() {
        return calculateDistance;
    }

    public void setCalculateDistance(boolean calculateDistance) {
        this.calculateDistance = calculateDistance;
    }

    public RadiostationConfig getConfig1() {
        return config1;
    }

    public void setConfig1(RadiostationConfig config1) {
        this.config1 = config1;
    }

    public RadiostationConfig getConfig2() {
        return config2;
    }

    public void setConfig2(RadiostationConfig config2) {
        this.config2 = config2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RadiostationType getRadiostationType() {
        return radiostationType;
    }

    public void setRadiostationType(RadiostationType radiostationType1) {
        this.radiostationType = radiostationType1;
    }

    public int getTrackType() {
        return trackType;
    }

    public void setTrackType(int trackType) {
        this.trackType = trackType;
    }

    public TwoRadiostationsProblem() {
    }

    public double calculateB() throws FunctionEvaluationException {
        double bK = 0;

        double bL = 0;
        double bPH = 0;

        if (this.config1.getRadiostation().getType() == Radiostation.TYPE_VEHICLE || this.config2.getRadiostation().getType() == Radiostation.TYPE_VEHICLE) {
            bL = 9;
        }
        if (this.config1.getRadiostation().getType() == Radiostation.TYPE_PERSONAL || this.config2.getRadiostation().getType() == Radiostation.TYPE_PERSONAL) {
            bPH = Table22Function.getValue(Radiostation.TYPE_PERSONAL,
                    this.getTrackType());
        }

        double bF = calculateBF();

        double bI = Correction22Function.calculateCorrection(this.getQuality());

        double bRet = bL + bPH + bF + bK - bI;

        return bRet;
    }

    public void solve() {
        try {
            double h1 = config1.getNormalizedHeight();
            double h2 = config2.getNormalizedHeight();

            double hh = h1 * h2;

            if (hh == 0.0) {
                return;
            }

            double bH = 0;

            if (hh < 25) {
                bH = 20 * Math.log10(25 / hh);
                hh = 25;

            }

            double bM1 = config1.calcBm();
            double bM2 = config2.calcBm();

            //double u2min1 = calcU2min(config1);
            //double u2min2 = calcU2min(config2);

            double b = calculateB();
            double g = calculateG();

            double u21 =  b + bH + bM1 - g;
            double u22 = b + bH + bM2 - g;

            double r11 = RadiusFunction.r(hh, u21);
            double r21 = RadiusFunction.r(hh, u22);

            this.setR1(r11);
            this.setR2(r21);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double calculateBF() {
        double l1 = this.getConfig1().getCableLength();
        double l2 = this.getConfig2().getCableLength();

        double fade1 = config1.getCable().getFade();
        double fade2 = config2.getCable().getFade();

        return fade1 * l1 + fade2 * l2;
    }
    public double calculateG() {
            double g1 = config1.getAerial().getAmp();
            double g2 = config2.getAerial().getAmp();

            return g1 + g2;

    }
}
