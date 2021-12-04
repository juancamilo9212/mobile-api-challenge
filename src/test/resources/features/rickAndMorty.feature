Feature: Rick And Morty API
  As a Rick And Morty API user
  I want to be able to fetch characters,
  locations and episodes

  Scenario: Get all Rick And Morty characters
    Given I want to use Rick And Morty API
    When I send a GET request to the endpoint "/character/"
    Then I will see a 200 response code
    And I will see "826" in the response body

  Scenario Outline: Get a particular character
    Given I want to use Rick And Morty API
    When I send a GET request to the "/character/" with a specific "<Id>"
    Then I will see a 200 response code
    And I will see character "<Name>" in the response body
    Examples:
      | Id |  | Name         |
      | 1  |  | Rick Sanchez |
      | 2  |  | Morty Smith  |

  Scenario Outline: Try to fetch a not existing character
    Given I want to use Rick And Morty API
    When I send a GET request to the "/character/" with a specific "<Id>"
    Then I will see a 404 response code
    Examples:
      | Id   |
      | 1850 |

  Scenario Outline: Filter the list by character's name
    Given I want to use Rick And Morty API
    When I send a GET request to the "/character/" with a parameter "<Name>"
    Then I will see a 200 response code
    And I will see "107" in the response body
    Examples:
      | Name |
      | Rick |

