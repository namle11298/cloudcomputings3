package com.cc.three.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.three.components.PartDao;
import com.cc.three.model.parts.PcPart;

@Service
public class PartService implements CrudService<PcPart> {

    private PartDao partDao;

    @Autowired
    public PartService(PartDao dao) {
        this.partDao = dao;
    }

    @Override
    public PcPart create(PcPart user) {
        return partDao.create(user);
    }

    @Override
    public PcPart read(String userId) {
        return partDao.read(userId);
    }

    @Override
    public PcPart update(PcPart user) {
        return partDao.update(user);
    }

    @Override
    public void delete(String userId) {
    	partDao.delete(userId);
    }
    
}
