package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.util.List;

public class Plane {

    private int idP;

    private List<Point> listPoints;

    public Plane(int idP, List<Point> points) {
        this.idP = idP;
        listPoints = points;
    }

    public List<Point> getListPoints() {
        return listPoints;
    }

}
