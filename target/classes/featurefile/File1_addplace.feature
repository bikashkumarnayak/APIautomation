Feature: Verify add place api

Scenario:Verify if Place is being Succesfully added using AddPlaceAPI
Given Add api payload
When User call "<Addplaceapi>" with post http request
Then  API call stass code success 200
And  "status" is responce body is "OK"
And "scope" is responce body "APP"
