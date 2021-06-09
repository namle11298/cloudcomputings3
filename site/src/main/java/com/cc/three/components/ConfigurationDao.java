package com.cc.three.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cc.three.model.ConfigurationParts;
import com.cc.three.service.CrudService;

@Component
public class ConfigurationDao implements CrudService<ConfigurationParts> {

    private DynamoDBMapper map;

    @Autowired
    public ConfigurationDao(DynamoDBMapper dynamoDBMapper) {
        this.map = dynamoDBMapper;
    }

    @Override
    public ConfigurationParts create(ConfigurationParts part) {
        map.save(part);
        return part;
    }

    @Override
    public ConfigurationParts read(String buildId) {
        return map.load(ConfigurationParts.class, buildId);
    }
    
    public List<ConfigurationParts> scanForUser(String userId) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        scanExpression.addFilterCondition("userId", new Condition()                                           
           .withComparisonOperator(ComparisonOperator.EQ)                                                
           .withAttributeValueList(new AttributeValue().withS(userId)));
        List<ConfigurationParts> results = map.scan(ConfigurationParts.class, scanExpression);
    	return results;
    }

    @Override
    public ConfigurationParts update(ConfigurationParts build) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("buildId", new ExpectedAttributeValue(new AttributeValue().withS(build.getBuildId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        map.save(build, saveExpression);
        return build;
    }

    @Override
    public void delete(String buildId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("buildId", new ExpectedAttributeValue(new AttributeValue().withS(buildId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        ConfigurationParts user = ConfigurationParts.builder().buildId(buildId).build();
        map.delete(user, deleteExpression);
    }
    
}