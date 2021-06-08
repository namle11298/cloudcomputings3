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
import com.cc.three.model.User;
import com.cc.three.service.CrudService;

@Component
public class UserDao implements CrudService<User> {

    private DynamoDBMapper map;

    @Autowired
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.map = dynamoDBMapper;
    }

    @Override
    public User create(User user) {
        map.save(user);
        return user;
    }

    @Override
    public User read(String userId) {
        return map.load(User.class, userId);
    }
    
    public User readByEmail(String email) {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        scanExpression.addFilterCondition("email", new Condition()                                           
           .withComparisonOperator(ComparisonOperator.EQ)                                                
           .withAttributeValueList(new AttributeValue().withS(email)));
        List<User> results = map.scan(User.class, scanExpression);
    	return results.size() > 0 ? results.get(0) : null;
    }

    @Override
    public User update(User user) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(user.getUserId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        map.save(user, saveExpression);
        return user;
    }

    @Override
    public void delete(String userId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("userId", new ExpectedAttributeValue(new AttributeValue().withS(userId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        User user = User.builder().userId(userId).build();
        map.delete(user, deleteExpression);
    }
}