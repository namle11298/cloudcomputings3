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
 * "name": "NZXT H510",
    "rating": 4,
    "rating_count": 103,
    "price_usd": 69.98,
    "type": "ATX Mid Tower",
    "color": "Black",
    "power_supply": null,
    "side_panel_window": "Tempered Glass",
    "external_5.25"_bays": "0",
    "internal_3.5"_bays": "2"
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "case")
public class Case extends PcPart {

    @DynamoDBHashKey(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "type")
    private String type;
    @DynamoDBAttribute(attributeName = "color")
    private String color;
    @DynamoDBAttribute(attributeName = "power_supply")
    private String power_supply;
    @DynamoDBAttribute(attributeName = "side_panel_window")
    private String side_panel_window;
    @DynamoDBAttribute(attributeName = "external_5.25\"_bays")
    private int external_525_bays;
    @DynamoDBAttribute(attributeName = "internal_3.5\"_bays")
    private int external_35_bays;
	
}
