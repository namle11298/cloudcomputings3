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
 * "name": "Corsair LL120 3-Pack",
    "rating": 4,
    "rating_count": 52,
    "price_usd": 129.99,
    "size": "120 mm",
    "color": "White",
    "rpm": "2200 RPM",
    "airflow": "63 CFM",
    "noise_level": "36 dB",
    "pwm": true
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "casefan")
public class CaseFan extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "rating")
    private int rating;
    @DynamoDBAttribute(attributeName = "rating_count")
    private int rating_count;
    @DynamoDBAttribute(attributeName = "price_usd")
    private Float price_usd;
    @DynamoDBAttribute(attributeName = "size")
    private String size;

    @DynamoDBAttribute(attributeName = "color")
    private String color;

    @DynamoDBAttribute(attributeName = "rpm")
    private String rpm;

    @DynamoDBAttribute(attributeName = "airflow")
    private String airflow;

    @DynamoDBAttribute(attributeName = "noise_level")
    private String noise_level;

    @DynamoDBAttribute(attributeName = "pwm")
    private String pwm;
    
    
}