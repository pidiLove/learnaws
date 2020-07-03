package com.aws.lambda;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CloudWatchLogsEvent;
import com.aws.dynamodb.DynamodbCRUD;


/**
 * @author wangpei
 * @date 2020/6/20 09:53
 * @description
 */
public class TestLambda implements RequestHandler<CloudWatchLogsEvent, Boolean> {

    @Override
    public Boolean handleRequest(CloudWatchLogsEvent s, Context context) {

       return DynamodbCRUD.putItem();
    }
}