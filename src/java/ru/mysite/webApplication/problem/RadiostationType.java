/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.problem;

/**
 *
 * @author Bris
 */
public class RadiostationType {
    private int type1;
    private int type2;

    public RadiostationType() {
    }

    public RadiostationType(int radiostationType1, int radiostationType2) {
        this.type1 = radiostationType1;
        this.type2 = radiostationType2;
    }

    public int getType1() {
        return type1;
    }

    public void setType1(int radiostationType1) {
        this.type1 = radiostationType1;
    }

    public int getType2() {
        return type2;
    }

    public void setType2(int radiostationType2) {
        this.type2 = radiostationType2;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RadiostationType other = (RadiostationType) obj;
        return this.type1 == other.type1 && this.type2 == other.type2;
    }

}
