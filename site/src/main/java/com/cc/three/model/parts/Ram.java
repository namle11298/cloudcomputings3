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
	"name": "Corsair Vengeance RGB Pro 16 GB",
    "rating": 4,
    "rating_count": 244,
    "priceusd": 94.99,
    "speed": "DDR4-3200",
    "modules": "2 x 8GB",
    "price/_gb": "$5.937",
    "color": "Black",
    "first_word_latency": "10 ns",
    "cas_latency": "16"
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "ram")
public class Ram extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "rating")
    private int rating;
    @DynamoDBAttribute(attributeName = "rating_count")
    private int rating_count;
    @DynamoDBAttribute(attributeName = "price_usd")
    private Float price_usd;
    @DynamoDBAttribute(attributeName = "speed")
    private String speed;
    @DynamoDBAttribute(attributeName = "modules")
    private String modules;
    @DynamoDBAttribute(attributeName = "price_/_gb")
    private String price_gb;
    @DynamoDBAttribute(attributeName = "color")
    private String color;
    @DynamoDBAttribute(attributeName = "first_word_latency")
    private String first_word_latency;
    @DynamoDBAttribute(attributeName = "cas_latency")
    private String cas_latency;
    
}
