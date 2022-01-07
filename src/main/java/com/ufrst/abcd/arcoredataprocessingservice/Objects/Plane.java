package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.util.List;

public class Plane {

    private int idP;

    private List<Points> listPoints;

    public Plane(int idP, List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> points) {
        this.idP = idP;
        listPoints = points;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> getListPoints() {
        return listPoints;
    }

    public void setPoints(List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> listPoints) {
        this.listPoints = listPoints;
    }
}
