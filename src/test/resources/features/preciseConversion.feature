#Author: Juan Camilo Camargo

Feature: Precise Conversion
  As a precise unit converter user app
  I want to convert an physic measure unit
  into another one

  Background:
    Given I open the Precise Unit Conversion App

  Scenario Outline:Set a measure conversion as favorite
    And I want to convert "Hectare" to "Square meter"
    When  I set a "<Value>" to be converted
    And I click on favorite button
    Then  I see the conversion is saved in favorites section
    Examples:
      | Value |
      | 98798 |

  Scenario Outline:Convert Hectare to Square Meter
    And I want to convert "Hectare" to "Square meter"
    When  I set a "<Value>" to be converted
    Then  I see a "<Conversion>" generated
    Examples:
      | Value |  | Conversion |
      | 0     |  | 0          |
      | 1     |  | 10 000     |

  Scenario Outline:Convert Kilometer per hour to Mile per hour
    And I want to convert  "Kilometer per hour" to "Mile per hour"
    When  I set a "<Value>" to be converted
    Then  I see a "<Conversion>" generated
    Examples:
      | Value |  | Conversion |
      | 0     |  | 0          |
      | 1     |  | 0.6214     |

  Scenario Outline: Delete an input character
    And I want to convert "Hectare" to "Square meter"
    When  I set a "<Value>" to be converted
    And I click on delete button
    Then I see the "<New Input>" is shorter than the original value
    Examples:
      | Value |  | New Input |
      | 98798 |  | 9879      |

  Scenario Outline: Clean the source and target area
    And I want to convert "Hectare" to "Square meter"
    When  I set a "<Value>" to be converted
    And I click on clear button
    Then I see the source and target sections are cleared out
    Examples:
      | Value |
      | 98798 |

  Scenario Outline: Delete an input character
    And I want to convert "Hectare" to "Square meter"
    When  I set a "<Value>" to be converted
    And I click on show all button
    Then I see all conversions screen
    Examples:
      | Value |
      | 98798 |



