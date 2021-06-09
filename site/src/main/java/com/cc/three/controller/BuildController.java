package com.cc.three.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.cc.three.model.ConfigurationParts;
import com.cc.three.service.ConfigurationService;

@RestController
public class BuildController {

    private ConfigurationService configService;

    @Autowired
    public BuildController(ConfigurationService service) {
        this.configService = service;
    }

    @CrossOrigin
    @RequestMapping(value = "/build", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<ConfigurationParts> createUser(@RequestBody ConfigurationParts c) {
        try {
        	ConfigurationParts response = configService.create(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/build/{buildId}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<ConfigurationParts> read(@PathVariable String buildId) {
        try {
        	ConfigurationParts response = configService.read(buildId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/build/user/{userId}", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<List<ConfigurationParts>> readUser(@PathVariable String userId) {
        try {
        	List<ConfigurationParts> response = configService.scanForUser(userId);
            return ResponseEntity.ok(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/build/update", produces = {"application/json"}, method = RequestMethod.PUT)
    public ResponseEntity<ConfigurationParts> updateUser(@RequestBody ConfigurationParts c) {
        try {
        	ConfigurationParts response = configService.update(c);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/build/{userId}", produces = {"application/json"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        try {
        	configService.delete(userId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}