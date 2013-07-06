package ru.mysite.webApplication.function;

import ru.mysite.webApplication.domain.Radiostation;
import ru.mysite.webApplication.problem.TwoRadiostationsProblem;



public class Table22Function {
       public static double getValue(int radiostationType, int trackType) {
        double ret = 0;

        if (radiostationType == Radiostation.TYPE_STATION) {
            if (trackType == TwoRadiostationsProblem.TRACK_OPEN) {
                ret = 2;
            }
            if (trackType == TwoRadiostationsProblem.TRACK_CLOSED_CITY) {
                ret += 10;
            }
            if (trackType == TwoRadiostationsProblem.TRACK_CLOSED_RAILWAY) {
                ret += 4;
            }
        } 

        return ret;
    }
}
