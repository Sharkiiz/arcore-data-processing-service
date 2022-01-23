package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Plane> listPlane = new ArrayList<>();
    private int idM;

    public Model(int id) {
        this.idM = id;
    }

    public void add(Plane plane) {
        listPlane.add(plane);
    }

    public void createModel() {
        try {
            //modifier pour mettre les models dans un repertoire spécifique + delete le contenue si jamais il y a quelque chose dedans
            File file = new File("model"+idM+".txt");
            FileWriter fileWriter = new FileWriter(file, true);
            for(Plane plane : this.getListPlane()) {
               List<Point> lp = plane.getListPoints();
               for(Point point : lp) {
                   String str = "v "+point.getVx()+" "+point.getVy()+" "+point.getVz()+"\n";
                   fileWriter.write(str);
               }
               StringBuilder sb = new StringBuilder("f ");
               int i = 0;
               sb.append(lp.get(i).getIdp()).append(" ").append(lp.get(i+1).getIdp()).append(" ").append(lp.get(i+2).getIdp()).append(" ").append(lp.get(i+3).getIdp()).append("\n");
               fileWriter.write(sb.toString());
            }
            fileWriter.close();
       } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Plane> getListPlane() {
        return this.listPlane;
    }
}
