Feature: deneme


  Scenario: deneme1
    Given user on "http://automationpractice.com"
    When  user log in with username as "deneme@gmail.com" and password as "deneme"
    Then  login should be successfull

    When user search "dress"
    Then the products should be listed

