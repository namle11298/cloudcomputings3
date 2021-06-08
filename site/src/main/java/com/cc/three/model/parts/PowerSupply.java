package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

/*
 * 
	"name": "Corsair RM (2019)",
    "rating": 4,
    "rating_count": 52,
    "price_usd": 140.93,
    "form_factor": "ATX",
    "efficiency_rating": "80+ Gold",
    "wattage": "850 W",
    "modular": "Full",
    "color": "Black"
 */

public class PowerSupply extends PcPart {

    @DynamoDBAttribute(attributeName = "form_factor")
    private String form_factor;
    
    @DynamoDBAttribute(attributeName = "efficiency_rating")
    private String efficiency_rating;
    
    @DynamoDBAttribute(attributeName = "wattage")
    private String wattage;

    @DynamoDBAttribute(attributeName = "modular")
    private String modular;
    
    @DynamoDBAttribute(attributeName = "color")
    private String color;
    
}
