package com.aws.dynamodb;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

import java.util.HashMap;

/**
 * @author wangpei
 * @date 2020/6/20 10:38
 * @description
 */
public class DynamodbCRUD {

    public static boolean putItem() {

        String table_name = "Project_pei";
        HashMap<String, AttributeValue> item = new HashMap<>();
        item.put("projectName", new AttributeValue("projectName " + System.currentTimeMillis()));
        item.put("projectType", new AttributeValue("type1"));
        item.put("memberName", new AttributeValue("memberName5"));

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.AP_SOUTHEAST_1).build();

        try {
            ddb.putItem(table_name, item);
        } catch (ResourceNotFoundException e) {
            System.err.println("Be sure that it exists and that you've typed its name correctly!");
            return false;
        } catch (AmazonServiceException e) {
            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("Done!");
        return true;
    }

    public static void main(String[] args) {
        putItem();
    }
}
