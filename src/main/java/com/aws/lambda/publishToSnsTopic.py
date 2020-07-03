import json
import boto3

def lambda_handler(event, context):
    # Create an SNS client
    sns = boto3.client('sns')
    # Publish a simple message to the specified SNS topic
    print("----"+"come in")
    response = sns.publish(
        TopicArn='arn:aws:sns:ap-southeast-1:494526681395:pei-sns-sns',
        Message='Hello World!',
    )
    return

    # Print out the response
