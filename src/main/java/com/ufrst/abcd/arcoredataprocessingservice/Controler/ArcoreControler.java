package com.ufrst.abcd.arcoredataprocessingservice.Controler;


import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArcoreControler {

    @PostMapping("/api/v1/parsePlanes")
    ResponseEntity parseModele(@RequestBody String body) throws JsonProcessingException {
        JsonParser.parse(body);
        System.currentTimeMillis();
        return new ResponseEntity("Data received", HttpStatus.OK);
    }

    @PostMapping("api/v1/createModel")
    ResponseEntity createModel(@RequestBody String body) {
        ModelManager.getModelById(Integer.parseInt(body)).createModel();
        System.currentTimeMillis();
        return new ResponseEntity("Creating model"+Integer.parseInt(body)+" in progress", HttpStatus.OK);
    }

}
