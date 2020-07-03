#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=s3-pei-lambda-ce58f5106646d58c

cd ..
mvn package

#cd src/main/resources

TEMPLATE=template-mvn-log.yml

aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file output-template-mvn-log.yml
aws cloudformation deploy --template-file output-template-mvn-log.yml --stack-name pei-sqs-lambda --capabilities CAPABILITY_NAMED_IAM
