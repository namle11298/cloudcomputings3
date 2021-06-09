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
import com.cc.three.service.UserService;
import com.cc.three.util.ErrorMessage;

@RestController
public class AuthenticationController {

    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/login", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> payload) {
        try {
            User response = userService.readByEmail((String)payload.get("email"));
            if (response != null) {
            	if (response.getPassword().equalsIgnoreCase((String)payload.get("password"))) {
            		return ResponseEntity.ok(response);
            	} else {
            		throw new ErrorMessage("You have entered an invalid password.");
            	}
            } else {
            	throw new ErrorMessage("That email could not be found in the database.");
            }
        } catch (ErrorMessage e) {
        	return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("errorMessage", e.getMessage()));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/register", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User response = userService.readByEmail(user.getEmail());
            if (response == null) {
            	
            	return ResponseEntity.ok(userService.create(user));
            	
            } else {
            	throw new ErrorMessage("That email already exists in the database.");
            }
        } catch (ErrorMessage e) {
        	return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("errorMessage", e.getMessage()));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    
    
}
