package com.ufrst.abcd.arcoredataprocessingservice.Objects;

public class Point {

    private int idp;
    private double vx;
    private double vy;
    private double vz;
    private double vnx;
    private double vny;
    private double vnz;

    public Point(int idp, double vx, double vy, double vz, double vnx, double vny, double vnz) {
        this.idp = idp;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.vnx = vnx;
        this.vny = vny;
        this.vnz = vnz;
    }

    public int getIdp() {
        return idp;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }

    public double getVz() {
        return vz;
    }

    public double getVnx() {
        return vnx;
    }

    public double getVny() {
        return vny;
    }

    public double getVnz() {
        return vnz;
    }
}
