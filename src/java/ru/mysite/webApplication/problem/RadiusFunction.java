package ru.mysite.webApplication.problem;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.SplineInterpolator;
import org.apache.commons.math.analysis.UnivariateRealFunction;

import java.util.LinkedHashMap;
import java.util.Map;

public class RadiusFunction {

    private static SplineInterpolator interpolator = new SplineInterpolator();
    private static Map<Double, double[]> hu = new LinkedHashMap<Double, double[]>();
    private static double maxU;
    private static double maxR;
    private static double minR;
    private static Map<Double, UnivariateRealFunction> xUsplines = new LinkedHashMap<Double, UnivariateRealFunction>();
    private static Map<Double, UnivariateRealFunction> uXsplines = new LinkedHashMap<Double, UnivariateRealFunction>();

    private static void prepareFunctions() {
        double[] x = new double[]{0.01, 0.02, 0.03, 0.04, 0.05, 0.07, 0.1, 0.2, 0.3, 0.5, 1, 2, 3, 5, 10, 20, 40, 50, 80, 90, 100};
        double[] h1600 = new double[]{106, 104, 102, 101, 100, 99.8, 99.5, 99, 97.5, 95, 90, 80, 73, 65, 53, 38, 20, 12, -1, -4, -7};
        double[] h800 = new double[]{106, 104, 102, 101, 100, 99.7, 98.8, 97, 95, 92, 84, 74, 67, 59, 47, 32, 13, 6, -6, -9, -12};
        double[] h400 = new double[]{106, 104, 102, 101, 100, 99.5, 98, 94.5, 92, 88, 79, 68, 61, 53, 41, 26, 8, 1, -10, -12, -15};
        double[] h200 = new double[]{106, 104, 102, 101, 100, 99, 97, 93, 90, 84, 73, 61, 55, 47, 34, 20, 2, -4, -13.5, -16, -18};
        double[] h100 = new double[]{106, 104, 102, 101, 100, 98, 95, 90, 86, 79, 68, 56, 50, 42, 30, 14, -4, -9, -18, -19.5, -21};
        double[] h50 = new double[]{106, 104, 102, 101, 100, 97, 94, 86, 80, 72, 61, 50, 44, 36, 24, 8, -9, -14, -21, -23, -24};
        double[] h25 = new double[]{106, 104, 102, 101, 100, 96, 91, 81, 74, 66, 55, 44, 38, 30, 17, 2, -13, -18, -24.5, -26, -28};

        maxU = 106;
        minR = 0.01;
        maxR = 100;

        hu.put(25d, h25);
        hu.put(50d, h50);
        hu.put(100d, h100);
        hu.put(200d, h200);
        hu.put(400d, h400);
        hu.put(800d, h800);
        hu.put(1600d, h1600);

        double[] reverseX = ArrayUtils.clone(x);
        ArrayUtils.reverse(reverseX);

        for (Map.Entry<Double, double[]> entry : hu.entrySet()) {
            xUsplines.put(entry.getKey(), interpolator.interpolate(x, entry.getValue()));

            double[] us = ArrayUtils.clone(entry.getValue());
            ArrayUtils.reverse(us);

            uXsplines.put(entry.getKey(), interpolator.interpolate(us, reverseX));
        }
    }

    public static double u(double height, double radius) throws FunctionEvaluationException {
        if (xUsplines.size() == 0) {
            prepareFunctions();
        }

        if (radius < minR) {
            return maxU;
        }

        // heed u(height) function for specific radius
        // using u(radius) to get u for discrete heights
        double[] heights = new double[xUsplines.size()];
        double[] u = new double[xUsplines.size()];

        int i = 0;
        for (Map.Entry<Double, UnivariateRealFunction> functionEntry : xUsplines.entrySet()) {
            double uForRadius = functionEntry.getValue().value(radius);

            if (height == functionEntry.getKey()) {
                return uForRadius;
            }

            heights[i] = functionEntry.getKey();
            u[i] = uForRadius;

            i++;
        }

        // get u(height) function
        double ret = interpolator.interpolate(heights, u).value(height);

        return ret;
    }

    public static double r(double height, double u) throws FunctionEvaluationException {
        if (uXsplines.size() == 0) {
            prepareFunctions();
        }

        if (u > maxU) {
            return minR;
        }

        // need r(height) function for specific u
        // using r(u) to get discrete rads for known heights
        double[] heights = new double[uXsplines.size()];
        double[] rad = new double[uXsplines.size()];

        int i = 0;
        for (Map.Entry<Double, UnivariateRealFunction> functionEntry : uXsplines.entrySet()) {
            heights[i] = functionEntry.getKey();

            double minU = hu.get(heights[i])[hu.get(heights[i]).length - 1];

            if (u < minU) {
                rad[i] = maxR;
            } else {
                double radForU = functionEntry.getValue().value(u);

                if (height == functionEntry.getKey()) {
                    return radForU;
                }

                rad[i] = radForU;
            }

            i++;
        }

        // getting r(height)
        UnivariateRealFunction fn = interpolator.interpolate(heights, rad);

        double ret = fn.value(height);

        return ret;
    }

    public static double h(double radius, double u) throws FunctionEvaluationException {
        if (xUsplines.size() == 0) {
            prepareFunctions();
        }

        //need h(u) function for specific radius
        // using u(x) to get discrete u for known radius
        double[] hs = new double[xUsplines.size()];
        double[] rad = new double[xUsplines.size()];

        int i = 0;
        for (Map.Entry<Double, UnivariateRealFunction> functionEntry : xUsplines.entrySet()) {
            double uForRad = functionEntry.getValue().value(radius);

            hs[i] = functionEntry.getKey();
            rad[i] = uForRad;

            i++;
        }

        // getting h(u)
        UnivariateRealFunction fn = interpolator.interpolate(rad, hs);
        double ret = fn.value(u);

        return ret;
    }
}
