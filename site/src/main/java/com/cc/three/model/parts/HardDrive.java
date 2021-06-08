package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

/*
 * 
	"name": "Samsung 970 Evo",
    "rating": 4,
    "rating_count": 213,
    "priceusd": 139.99,
    "capacity": "1 TB",
    "price/_gb": "$0.140",
    "type": "SSD",
    "cache": "1024 MB",
    "form_factor": "M.2-2280",
    "interface": "M.2 (M)"
 */

public class HardDrive extends PcPart {

    @DynamoDBAttribute(attributeName = "capacity")
    private String capacity;
    @DynamoDBAttribute(attributeName = "price/_gb")
    private String price_gb;
    @DynamoDBAttribute(attributeName = "type")
    private String type;
    @DynamoDBAttribute(attributeName = "cache")
    private String cache;
    @DynamoDBAttribute(attributeName = "form_factor")
    private String form_factor;
    @DynamoDBAttribute(attributeName = "interface")
    private String interface_type;
    
}
