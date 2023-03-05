@trello_api
Feature: Trello api related features

  @board_api_test
  Scenario:create board and cart
    When user create a board
    And user get the board
    And user create a list on the board
    And user get the list
    And user create a card on the board list
    And user get a random card
    And user update the card
    And user delete all cards
    And user delete the board