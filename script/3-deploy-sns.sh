#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=s3-pei-lambda-1732739d2163d8b5

cd ..
mvn package

#cd src/main/resources

TEMPLATE=template-mvn-sns.yml

aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file output-template-mvn-sns.yml
aws cloudformation deploy --template-file output-template-mvn-sns.yml --stack-name pei-sns-lambda-cloudwatch --capabilities CAPABILITY_NAMED_IAM
