package com.cc.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

@Configuration
@ComponentScan
public class DynamoConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB dynamoClient = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIARRXNIMEVLB7AU2GV", "CA9Vy4sSlGw5F1rnpE8TveiOyxVxCIKOvoyjbnS1")))
                .withRegion(Regions.US_EAST_1)
                .build();
        return new DynamoDBMapper(dynamoClient, DynamoDBMapperConfig.DEFAULT);
    }
}