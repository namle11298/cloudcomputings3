package com.cc.three.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.cc.three.model.User;
import com.cc.three.model.parts.Cpu;
import com.cc.three.service.PartService;
import com.cc.three.service.UserService;
import com.cc.three.util.ErrorMessage;

@RestController
public class PartController {

    private PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/cpu/create", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> payload) throws ErrorMessage {
    	Cpu cpu = new Cpu();
    	cpu.setName("Test CPU");
    	partService.create(cpu);
        try {
        	return ResponseEntity.ok(partService.create(new Cpu()));
            /*User response = partService.readByEmail((String)payload.get("email"));
            if (response != null) {
            	if (response.getPassword().equalsIgnoreCase((String)payload.get("password"))) {
            		return ResponseEntity.ok(response);
            	} else {
            		throw new ErrorMessage("You have entered an invalid password.");
            	}
            } else {
            	throw new ErrorMessage("That email could not be found in the database.");
            }*/
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    
}
