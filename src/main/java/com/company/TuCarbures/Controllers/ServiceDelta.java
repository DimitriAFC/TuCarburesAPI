package com.company.TuCarbures.Controllers;

import org.springframework.stereotype.Service;

@Service
public class ServiceDelta {

    static public double sqr(double a) {
        return a*a;
    }

    static public double Distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(sqr(y2 - y1) + sqr(x2 - x1));
    }

    public static void main(String[] args) {
        System.out.print("Calcul la distance entre deux points (0,0)-(10,10): " +Distance(0, 0, 10, 10)+"\n");
        System.out.print("Calcul la distance entre deux points (2,2)-(10,10): "+Distance(2, 2, 10, 10)+"\n");
        System.out.print("Calcul la distance entre deux points (1,1)-(8,8): "+Distance(1, 1, 8, 8)+"\n");
    }
}
