@All
Feature: Amazon Assignment

Background:
Given user launch the browser
Then user enters  the amazon site


@TodaysDeals
Scenario: add third item to the cart from Todays Deals
Given user clicks on todays deals
When user clicks on third deal
Then user select the deal
And adds item to the cart
Then Item should be added to the cart
Then close the browser

@Mobiles
Scenario: Search Mobiles and get the last displayed item
Given user types Mobiles in search bar
When user clicks to search
Then user selects the last displayed item
Then the last displayed item deatils should be displyed
Then close the browser


