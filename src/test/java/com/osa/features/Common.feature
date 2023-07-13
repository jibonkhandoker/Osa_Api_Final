  
Feature: This is common feature file that contains all the re useable steps
    
   Scenario:send a post call
    Given I have completed the authenticattion
    When I sent a "POST" request to "/students/registration"
    |V|statusCode   |201|
    |B|testdata.xlsx|A1|
    
    Then I verify the following fields
 
    #Scenario: send a get call
    #Given I have completed the authenticattion
    #When I sent a "GET" request to "/students/64aa5108372f207ea9c4db17"
    #|V|statusCode   |200|
    #|B|testdata.xlsx|A1|
    #
    #Then I verify the following fields
    
    #Scenario: send a patch call
    #Given I have completed the authenticattion
    #When I sent a "PATCH" request to "/students/64aa5108372f207ea9c4db17"
    #|V|statusCode   |200|
    #|B|testdata.xlsx|A1|
    #
    #Then I verify the following fields
      #Scenario: send a delete call
    #Given I have completed the authenticattion
    #When I sent a "DELETE" request to "/students/64aa5108372f207ea9c4db17"
    #|V|statusCode   |200|
    #|B|testdata.xlsx|A1|
    #
    #Then I verify the following fields
    
    