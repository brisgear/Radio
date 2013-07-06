/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mysite.webApplication.util;

import java.util.*;

/**
 *
 * @author Bris
 */
public class CalculationUtil {
    static public String[] TYPE_RADIOSTATION = {"РС - РС", "РС - РН", "РС - РВ","РВ - РВ","РВ - РН","РН - РН"};
    static public int RS = 0;
    static public int RV = 1;
    static public int RN = 2;
    static public Map<String,Integer> radiostationTypes = new HashMap<String,Integer>();
    static{
        radiostationTypes.put("РС", 0);
        radiostationTypes.put("РВ", 1);
        radiostationTypes.put("РН", 2);
    }
    static public int getTypeByName(String name){
        Integer get = radiostationTypes.get(name);
        if(get==null)
            return -1;
        return get;
    }
}
