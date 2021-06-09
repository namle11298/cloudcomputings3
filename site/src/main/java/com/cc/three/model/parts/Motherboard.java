package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "motherboard")
public class Motherboard extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "socket/_cpu")
    private String socket_cpu;

    @DynamoDBAttribute(attributeName = "form_factor")
    private String form_factor;
    
    @DynamoDBAttribute(attributeName = "memory_max")
    private String memory_max;
    
    @DynamoDBAttribute(attributeName = "memory_slots")
    private String memory_slots;
    
    @DynamoDBAttribute(attributeName = "color")
    private String color;
}
