package ru.mysite.webApplication.function;

import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.SplineInterpolator;
import org.apache.commons.math.analysis.UnivariateRealFunction;

public class Correction22Function {
    private static UnivariateRealFunction fn1;
    private static UnivariateRealFunction fn2;


    public static double calculateCorrection(double quality)/*, int stationType)*/ throws FunctionEvaluationException {
        if (fn1 == null) {
            double[] x = new double[]{0.1, 1, 2, 5, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95, 98, 99};
            double[] y1 = new double[]{4.2, 3.7, 3.1, 2.7, 2.1, 1.7, 1, 0.7, 0, -0.5, -1.4, -2.8, -3, -3.8, -5, -7, -8};
            double[] y2 = new double[]{6.2, 5.5, 5, 4, 3.3, 2.3, 1.7, 1, 0, -1, -2, -3.2, -4.1, -5.3, -7.2, -10, -12};

            SplineInterpolator interpolator = new SplineInterpolator();

            fn1 = interpolator.interpolate(x, y1);
            fn2 = interpolator.interpolate(x, y2);
        }

        //if (stationType == Station.TYPE_AUTONOMOUS) {
            return fn1.value(quality);
        //} else {
        //    return fn2.value(quality);
        //}
    }
}
