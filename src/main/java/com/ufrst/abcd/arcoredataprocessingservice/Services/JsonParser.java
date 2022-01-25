package com.ufrst.abcd.arcoredataprocessingservice.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufrst.abcd.arcoredataprocessingservice.Model.ModelManager;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Model;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Plane;
import com.ufrst.abcd.arcoredataprocessingservice.Objects.Point;

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
        final JsonNode arrNodePlanes = new ObjectMapper().readTree(body).get("Planes"); //pointeur sur les objts plans
        if (arrNodePlanes.isArray()) {
            int i = 0;
            for (final JsonNode objPlane : arrNodePlanes) {
                int idPlane = objPlane.get("idP").asInt();
                final JsonNode arrNodePoints = new ObjectMapper().readTree(body).get("Planes").get(i).get("Points");
                if (arrNodePoints.isArray()) {
                    List<Point> listPoints = new ArrayList<>();
                    for (final JsonNode objPoint : arrNodePoints) {
                        Point point = new Point(
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
                }
            }
        }
    }
}

