package com.ufrst.abcd.arcoredataprocessingservice.Objects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Plans> listPlan = new ArrayList<>();
    private int id;

    public Model(int id) {
        this.id = id;
    }

    public void add(Plans plan) {
        listPlan.add(plan);
    }

    public void createModel() {
        //try {
            //FileWriter fileWriter = new FileWriter("model"+id+".txt");
            for(Plans plans : this.getListPlan()) {
               List<Points> lp = plans.getPoints();
               for(Points point : lp) {
                   String str = "v "+point.getVx()+" "+point.getVy()+" "+point.getVz();
                   System.out.println(str);

               }
            }

       /*} catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public List<Plans> getListPlan() {
        return this.listPlan;
    }

    public int getId() {
        return id;
    }
}
