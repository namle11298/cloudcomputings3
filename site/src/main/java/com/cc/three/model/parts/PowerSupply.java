package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "powersupply")
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
