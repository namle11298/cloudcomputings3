package com.cc.three.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.three.components.ConfigurationDao;
import com.cc.three.model.ConfigurationParts;

@Service
public class ConfigurationService implements CrudService<ConfigurationParts> {

    private ConfigurationDao dao;

    @Autowired
    public ConfigurationService(ConfigurationDao dao) {
        this.dao = dao;
    }

    @Override
    public ConfigurationParts create(ConfigurationParts u) {
        return dao.create(u);
    }

    @Override
    public ConfigurationParts read(String buildId) {
        return dao.read(buildId);
    }

    public List<ConfigurationParts> scanForUser(String userId) {
        return dao.scanForUser(userId);
    }
    
    @Override
    public ConfigurationParts update(ConfigurationParts u) {
        return dao.update(u);
    }

    @Override
    public void delete(String userId) {
    	dao.delete(userId);
    }
}