@trello_api
Feature: Trello api related features
  @board_api_test
  Scenario:create board and cart
    When user create a board
    And user create two cart on board
    And user update one of the cart randomly
    And user delete all carts
    And user delete the board

