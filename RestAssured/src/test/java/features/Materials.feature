Feature: Get a list of existing Materials in the system

  Scenario Outline: Get a Materials list from API
    Given User sends a GET request to the "<Resource>" (Materials)
    Then  User validates that the "<Attribute>" has this "<Value>" (Materials)
    Examples:
      | Resource      | Attribute       | Value      |
      | /v2/divisions | Data.divisionId | -762496764 |