package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.util.List;

public class Plane {

    private int idP;

    private List<Points> listPoints;

    public Plane(int idP, List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> points) {
        this.idP = idP;
        listPoints = points;
    }

    public List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> getListPoints() {
        return listPoints;
    }

}
