package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

/*
 * "name": "Cooler Master Hyper 212 RGB Black Edition",
    "rating": 4,
    "rating_count": 137,
    "price_usd": 39,
    "fan_rpm": "650 - 2000 RPM",
    "noise_level": "8 - 30 dB",
    "color": "Black",
    "radiator_size": null
 */

public class CpuCooler extends PcPart {

    @DynamoDBAttribute(attributeName = "fan_rpm")
    private String fan_rpm;
    
    @DynamoDBAttribute(attributeName = "noise_level")
    private String noise_level;
    
    @DynamoDBAttribute(attributeName = "color")
    private String color;
    
    @DynamoDBAttribute(attributeName = "radiator_size")
    private String radiator_size;
    
}
