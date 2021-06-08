package com.cc.three.model.parts;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

/*
 * 
 	"name": "AMD Ryzen 7 3700X",
    "rating": 4,
    "rating_count": 490,
    "price_usd": 319.99,
    "core_count": "8",
    "core_clock": "3.6 GHz",
    "boost_clock": "4.4 GHz",
    "tdp": "65 W",
    "integrated_graphics": null,
    "smt": true
 */

public class Cpu extends PcPart {

    @DynamoDBAttribute(attributeName = "core_count")
    private int core_count;

    @DynamoDBAttribute(attributeName = "core_clock")
    private String core_clock;

    @DynamoDBAttribute(attributeName = "boost_clock")
    private String boost_clock;

    @DynamoDBAttribute(attributeName = "tdp")
    private String tdp;

    @DynamoDBAttribute(attributeName = "integrated_graphics")
    private String integrated_graphics;

    @DynamoDBAttribute(attributeName = "smt")
    private boolean smt;
}
