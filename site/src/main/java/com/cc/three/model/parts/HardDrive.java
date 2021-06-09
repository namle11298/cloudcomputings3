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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "harddrive")
public class HardDrive extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
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
