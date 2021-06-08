package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

/*
 * 
	"name": "Asus TUF GAMING X570-PLUS (WI-FI)",
    "rating": 4,
    "rating_count": 174,
    "priceusd": 189.99,
    "socket/_cpu": "AM4",
    "form_factor": "ATX",
    "memory_max": "128 GB",
    "memory_slots": "4",
    "color": "Black / Gold"
 */

public class Motherboard extends PcPart {

    @DynamoDBAttribute(attributeName = "socket/_cpu")
    private String socket_cpu;

    @DynamoDBAttribute(attributeName = "form_factor")
    private String form_factor;
    
    @DynamoDBAttribute(attributeName = "memory_max")
    private String memory_max;
    
    @DynamoDBAttribute(attributeName = "memory_slots")
    private int memory_slots;
    
    @DynamoDBAttribute(attributeName = "color")
    private String color;
}
