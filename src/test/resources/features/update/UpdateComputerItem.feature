@regression @update
Feature: Update computer item from the application into computer database

  In order to modify a computer item
  As a User
  I want to be able to update and save this item in computer database


  Scenario Outline: Should be able to update and save computer item in computer database
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

    # When Scenario
      # Able to update computer item(includes update success msg)
    When I am able to update details of "<computer name>" with
      | Introduced date   | 2014-01-01 |
      | Discontinued date | 2015-01-01 |
      | Company           | Apple Inc. |

    # Then Scenario
      # Search and verifies computer item
    And I search by computer name "<computer name>"
    Then I should be able to successfully view its details
      | Computer name | <computer name> |
      | Introduced    | 01 Jan 2014     |
      | Discontinued  | 01 Jan 2015     |
      | Company       | Apple Inc.      |

    Examples:
      | computer name   |
      | Test Computer 2 |

  Scenario Outline: Should be able to update and save computer item with incomplete details in computer database
    # Pre Condition
    Given I am on application home page
      # Performs Delete Operation(includes delete successful msg and scenario when no record is present)
      # Want to delete duplicate entries before creating new item
    When I find nothing for "<computer name>" item in search
    # Creates new item with no optional data(includes success msg)
    Then I should be able to successfully create new computer item as
      | Computer name     | <computer name> |

    # When Scenario
      # Able to update computer item filling all optional values(includes update success msg)
    When I am able to update details of "<computer name>" with
      | Introduced date   | 2014-01-01 |
      | Discontinued date | 2015-01-01 |
      | Company           | Apple Inc. |

    # Then Scenario
      # Search and verifies computer item
    And I search by computer name "<computer name>"
    Then I should be able to successfully view its details
      | Computer name | <computer name> |
      | Introduced    | 01 Jan 2014     |
      | Discontinued  | 01 Jan 2015     |
      | Company       | Apple Inc.      |

    Examples:
      | computer name   |
      | Test Computer 5 |



