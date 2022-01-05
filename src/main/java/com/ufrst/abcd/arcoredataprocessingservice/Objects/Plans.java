package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.util.List;

public class Plans {

    private int idP;

    private List<Points> Points;

    public Plans(int idP, List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> points) {
        this.idP = idP;
        Points = points;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> getPoints() {
        return Points;
    }

    public void setPoints(List<com.ufrst.abcd.arcoredataprocessingservice.Objects.Points> points) {
        Points = points;
    }
}
