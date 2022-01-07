package com.ufrst.abcd.arcoredataprocessingservice.Controler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Model;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Plane;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Points;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static void parse(String body) throws JsonProcessingException {
        final JsonNode nodeModel = new ObjectMapper().readTree(body).get("model");
        int idModel = nodeModel.asInt();
        if (!ModelManager.getListModel().containsKey(idModel)) {
            ModelManager.addModel(idModel, new Model(idModel));
        }
        Model model = ModelManager.getModelById(idModel);
        final JsonNode arrNodePlans = new ObjectMapper().readTree(body).get("plans"); //pointeur sur les objts plans
        if (arrNodePlans.isArray()) {
            int nbPlan = 0;
            int i = 0;
            for (final JsonNode objPlans : arrNodePlans) {
                int idPlane = objPlans.get("idP").asInt();
                final JsonNode arrNodePoints = new ObjectMapper().readTree(body).get("plans").get(i).get("Points");
                if (arrNodePoints.isArray()) {
                    List<Points> listPoints = new ArrayList<>();
                    for (final JsonNode objPoint : arrNodePoints) {
                        Points point = new Points(
                                objPoint.get("idp").asInt(),
                                objPoint.get("vx").asDouble(),
                                objPoint.get("vy").asDouble(),
                                objPoint.get("vz").asDouble(),
                                objPoint.get("vnx").asDouble(),
                                objPoint.get("vny").asDouble(),
                                objPoint.get("vnz").asDouble());
                        listPoints.add(point);
                    }
                    i++;
                    model.add(new Plane(idPlane, listPoints));
                    nbPlan++;
                }
            }
            System.out.println("Il y a " + nbPlan + " plans dans cette requete");
        }
    }
}


        /*
        JSONArray jsonPlansArray = nodePlans.;
        List<Plans> listPlans = new ArrayList<>();
        for (int i = 0; i < jsonPlansArray.length(); i++) {
            List<Points> listPoints = new ArrayList<>();
            JSONObject jsonPlan = jsonPlansArray.getJSONObject(i);
            JSONArray jsonPoints = jsonPlan.getJSONArray("Points");
            for (int y = 0; y < jsonPoints.length(); y++) {
                JSONObject jsonPoint = jsonPoints.getJSONObject(y);
                Points point = new Points(jsonPoint.getInt("idp"), jsonPoint.getDouble("texture"), jsonPoint.getDouble("normal"));
                listPoints.add(point);
            }
            int idPlan = jsonPlan.getInt("idP");
            Plans plan = new Plans(idPlan, listPoints);
            //demande un id pour le model afin d'ajouter les datas au bon model
            listPlans.add(plan);*/

            /*
            if (ModelCreator.get(l 'id du model').existe()){
                modelcreator.get(i).add(listPlans);
            }
            Model model = new Model(id, listPlans);*/

