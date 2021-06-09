package com.cc.three.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cc.three.model.parts.PcPart;
import com.cc.three.service.CrudService;

@Component
public class PartDao implements CrudService<PcPart> {

    private DynamoDBMapper map;

    @Autowired
    public PartDao(DynamoDBMapper dynamoDBMapper) {
        this.map = dynamoDBMapper;
    }

    @Override
    public PcPart create(PcPart part) {
        map.save(part);
        return part;
    }

    @Override
    public PcPart read(String id) {
        return map.load(PcPart.class, id);
    }

    @Override
    public PcPart update(PcPart part) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("name", new ExpectedAttributeValue(new AttributeValue().withS(part.getName())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        map.save(part, saveExpression);
        return part;
    }

    @Override
    public void delete(String name) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("name", new ExpectedAttributeValue(new AttributeValue().withS(name)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        PcPart part = new PcPart();
        part.setName(name);
        map.delete(part, deleteExpression);
    }

}
