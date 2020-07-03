package com.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wangpei
 * @date 2020/7/3 07:10
 * @description
 */
public class ReadSQSLambda implements RequestHandler<SQSEvent, String> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(SQSEvent event, Context context) {

        LambdaLogger logger = context.getLogger();

        // process event
        for (SQSMessage msg : event.getRecords()) {
            logger.log("eventBody" + gson.toJson(msg.getBody()));
        }
        return "succeed";
    }
}
