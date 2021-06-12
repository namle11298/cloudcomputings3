package com.cc.three.controller;

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
import com.cc.three.model.parts.*;
import com.cc.three.service.PartService;
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
    public ResponseEntity<?> loginUser(@RequestBody Cpu cpu) throws ErrorMessage {
        try {
        	return ResponseEntity.ok(partService.create(cpu));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/cpu/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_cpu(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(Cpu.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/case/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_case(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(Case.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/casefan/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_casefan(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(CaseFan.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/ram/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_ram(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(Ram.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/powersupply/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_powersupply(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(PowerSupply.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/motherboard/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_motherboard(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(Motherboard.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/videocard/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_gpu(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(Gpu.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/cpucooler/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_cpucooler(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(CpuCooler.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/harddrive/search", produces = {"application/json"}, method = RequestMethod.POST)
    public ResponseEntity<?> search_harddrive(@RequestBody Map<String, Object> payload) {
        try {
        	return ResponseEntity.ok(partService.read(HardDrive.class, (String)payload.get("name")));
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
