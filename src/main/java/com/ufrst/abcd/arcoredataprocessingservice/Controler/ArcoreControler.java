package com.ufrst.abcd.arcoredataprocessingservice.Controler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufrst.abcd.arcoredataprocessingservice.Process.JsonParser;

import com.ufrst.abcd.arcoredataprocessingservice.Process.ModelCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArcoreControler {

    @PostMapping("/api/v1/parsePlans")
    ResponseEntity parseModele(@RequestBody String body) throws JsonProcessingException {
        JsonParser.parse(body);
        System.currentTimeMillis();
        return new ResponseEntity("Data received", HttpStatus.OK);
    }

    @PostMapping("api/v1/createModel")
    ResponseEntity createModel(@RequestBody String body) {
        ModelCreator.getModelById(Integer.parseInt(body)).createModel();
        return new ResponseEntity("Creating model in progress", HttpStatus.OK);
    }

}