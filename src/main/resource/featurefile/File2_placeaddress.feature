

@AddPlace
Feature:Verify the addplace apies

Scenario Outline: placeholder validation
Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then verifay responce code id 200
And take all pace "place_id"
And verifay the "status" is "OK"
And verify "place_id" created maps to "<name>" using "GetPlaceAPI"


Examples:
	|name 	 | language |address		        |
	|AAhouse |  English |World cross center|
#	|BBhouse | Spanish  |Sea cross center  |
#	|CChouse|Hindi      |NewDelhi | 

Scenario:Update place validation
Given update place add new address
|address|
|bhubaneswar|
When user calls "UpdateplaceAPI" with "PUT" http request
Then verify the success "msg"
And verifay responce code id 200

Scenario: Delete palce validation
Given Delete place payload validation 
When user calls "DeleteplaceAPI" with "POST" http request
Then verifay responce code id 200
And verifay the "status" is "OK"
