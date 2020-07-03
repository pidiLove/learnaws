#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET=s3-pei-lambda-dec7ddd4a90b8638

cd ..
mvn package

#cd src/main/resources

TEMPLATE=template-mvn.yml

aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file output-template-mvn.yml
aws cloudformation deploy --template-file output-template-mvn.yml --stack-name pei-lambda-cloudwatch --capabilities CAPABILITY_NAMED_IAM
