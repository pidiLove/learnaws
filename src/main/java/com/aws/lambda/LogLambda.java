package com.aws.lambda;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CloudWatchLogsEvent;
import com.aws.dynamodb.DynamodbCRUD;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author wangpei
 * @date 2020/6/20 09:53
 * @description
 */
public class LogLambda implements RequestHandler<CloudWatchLogsEvent, String> {
    private static final Logger logger = LoggerFactory.getLogger(LogLambda.class);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(CloudWatchLogsEvent event, Context context) {

        logger.info("lambda: " + gson.toJson(event));
        return "succeed!";
    }
}