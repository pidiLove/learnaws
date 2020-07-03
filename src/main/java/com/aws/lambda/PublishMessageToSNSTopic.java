package com.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

/**
 * @author wangpei
 * @date 2020/7/3 08:17
 * @description
 */
public class PublishMessageToSNSTopic implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String snsEvent, Context context) {
        System.out.println("come in" + snsEvent);
        String message = "nihao" + System.currentTimeMillis();
        String topicArn = "arn:aws:sns:ap-southeast-1:494526681395:pei-sns-sns";

        SnsClient snsClient = SnsClient.builder()
//                .region(Region.AP_SOUTHEAST_1)
                .build();

        pubTopic(snsClient, message, topicArn);
        return "succeed";
    }

    public static void pubTopic(SnsClient snsClient, String message, String topicArn) {

        try {
            System.out.println("come in2");
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topicArn)
                    .build();
            System.out.println("come in3");

            PublishResponse result = snsClient.publish(request);
            System.out.println(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
