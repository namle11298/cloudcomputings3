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
	"name": "MSI D6 GAMING X",
    "rating": 5,
    "rating_count": 1,
    "price_usd": 349.99,
    "chipset": "GeForce GTX 1650",
    "memory": "4 GB",
    "core_clock": "1485 MHz",
    "boost_clock": "1710 MHz",
    "color": "Black",
    "length": "245 mm"
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "videocard")
public class Gpu extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "rating")
    private int rating;
    @DynamoDBAttribute(attributeName = "rating_count")
    private int rating_count;
    @DynamoDBAttribute(attributeName = "price_usd")
    private Float price_usd;
    
    @DynamoDBAttribute(attributeName = "chipset")
    private String chipset;

    @DynamoDBAttribute(attributeName = "memory")
    private String memory;

    @DynamoDBAttribute(attributeName = "core_clock")
    private String core_clock;

    @DynamoDBAttribute(attributeName = "boost_clock")
    private String boost_clock;

    @DynamoDBAttribute(attributeName = "color")
    private String color;

    @DynamoDBAttribute(attributeName = "length")
    private String length;
}
