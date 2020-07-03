#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=s3-pei-lambda-8d5bdbc0ea7fb559

cd ..
mvn package

#cd src/main/resources

TEMPLATE=template-mvn-sqs.yml

aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file output-template-mvn-sqs.yml
aws cloudformation deploy --template-file output-template-mvn-sqs.yml --stack-name pei-sqs-lambda-latest --capabilities CAPABILITY_NAMED_IAM
