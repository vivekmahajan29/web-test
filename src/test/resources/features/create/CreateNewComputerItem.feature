@regression @create
Feature: Create new computer item in computer database

  In order to create a new computer item
  As a User
  I want to be able to save this item in computer database


  Scenario Outline: Should be able to create new computer item in computer database

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

    Examples:
      | computer name   |
      | Test Computer 1 |

  Scenario Outline: Should be able to create new computer item with optional fields in computer database

    # Pre Condition
    Given I am on application home page
      # Performs Delete Operation(includes delete successful msg and scenario when no record is present)
      # Want to delete duplicate entries before creating new item
    When I find nothing for "<computer name>" item in search

    # Creates new item with no optional data(includes success msg)
    Then I should be able to successfully create new computer item as
      | Computer name | <computer name> |

    # Search and verifies computer item
    When I search by computer name "<computer name>"
    Then I should be able to successfully view its details
      | Computer name | <computer name> |
      | Introduced    | -               |
      | Discontinued  | -               |
      | Company       | -               |

    Examples:
      | computer name   |
      | Test Computer 4 |



