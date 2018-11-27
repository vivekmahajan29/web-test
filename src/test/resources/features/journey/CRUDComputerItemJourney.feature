@smoke
Feature: CRUD operation on computer item

  In order to perform CRUD operation on computer item
  As a User
  I want to be able to create, update, read and delete this item from computer database


  Scenario Outline: Should be able to perform CRUD operation on computer item
    # Pre Condition
    Given I am on application home page

      # Performs Delete Operation(includes delete successful msg and scenario when no record is present)
      # Want to delete duplicate entries before creating new item
    When I find nothing for "<computer name>" item in search

    # Creates new item(includes success msg)
    Then I should be able to successfully create new computer item as
      | Computer name     | <computer name> |
      | Introduced date   | 2016-01-01      |
      | Discontinued date | 2017-01-01      |
      | Company           | IBM             |

    # Search and verifies computer item
    When I search by computer name "<computer name>"
    Then I should be able to successfully view its details
      | Computer name | <computer name> |
      | Introduced    | 01 Jan 2016     |
      | Discontinued  | 01 Jan 2017     |
      | Company       | IBM             |

    # Able to update computer item(includes update success msg)
    When I am able to update details of "<computer name>" with
      | Introduced date   | 2014-01-01 |
      | Discontinued date | 2015-01-01 |
      | Company           | Apple Inc. |

    # Search and verifies computer item
    And I search by computer name "<computer name>"
    Then I should be able to successfully view its details
      | Computer name | <computer name> |
      | Introduced    | 01 Jan 2014     |
      | Discontinued  | 01 Jan 2015     |
      | Company       | Apple Inc.      |


    Examples:
      | computer name   |
      | Test Computer 3 |



