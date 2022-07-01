package com.company.TuCarbures.Controllers;

import org.springframework.stereotype.Service;

@Service
public class ServiceDelta {

    static public double sqr(double a) {
        return a*a;
    }

    static public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
    }
}
