package com.ufrst.abcd.arcoredataprocessingservice.Model;

import com.ufrst.abcd.arcoredataprocessingservice.Objects.Model;

import java.util.HashMap;
import java.util.Map;


public class ModelManager {

    private static Map<Integer,Model> listModel = new HashMap<>();

    public static void addModel(int idModel, Model model) {
        listModel.put(idModel, model);
    }

    public static Model getModelById(int idModel) {
        return listModel.get(idModel);
    }

    public static Map<Integer,Model> getListModel() {
        return listModel;
    }


}
