package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.util.List;

public class Plane {

    private int idP;

    private List<Points> listPoints;

    public Plane(int idP, List<Points> points) {
        this.idP = idP;
        listPoints = points;
    }

    public List<Points> getListPoints() {
        return listPoints;
    }

}
