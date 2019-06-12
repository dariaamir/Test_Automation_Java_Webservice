Feature: Comments API call returns list of all comments

  Scenario Outline: Check comment post id
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct post id <postID>

    Examples:
      |id  |postID |
      |1   |1      |
      |15  |3      |
      |196 |40     |
      |219 |44     |
      |500 |100    |


  Scenario Outline: Check comment name
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct name <name>

    Examples:
    |id  |name                                                           |
    |1   |id labore ex et quam laborum                                   |
    |100 |et sint quia dolor et est ea nulla cum                         |
    |161 |nesciunt quidem veritatis alias odit nisi voluptatem non est   |
    |276 |inventore amet ut debitis ipsam reiciendis molestiae autem sed |
    |500 |ex eaque eum natus                                             |


  Scenario Outline: Check comment id
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct email <email>

  Examples:
    |id  |email                   |
    |1   |Eliseo@gardner.biz      |
    |101 |Lura@rod.tv             |
    |255 |Delta_Welch@carleton.tv |
    |379 |Afton.Medhurst@mina.info|
    |500 |Emma@joanny.ca          |

  Scenario Outline: Check comment body
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct body <body>

    Examples:
      |id  |body                                                                                                                                                                     |
      |1   |laudantium enim quasi est quidem magnam voluptate ipsam eos tempora quo necessitatibus dolor quam autem quasi reiciendis et nam sapiente accusantium                     |
      |2   |est natus enim nihil est dolore omnis voluptatem numquam et omnis occaecati quod ullam at voluptatem error expedita pariatur nihil sint nostrum voluptatem reiciendis et |
      |119 |et omnis consequatur ut in suscipit et voluptatem animi at ut dolores quos aut numquam esse praesentium aut placeat nam                                                  |
      |433 |voluptatem minus asperiores quasi perspiciatis et aut blanditiis illo deserunt molestiae ab aperiam ex minima sed omnis at et repellat aut incidunt                      |
      |500 |perspiciatis quis doloremque veniam nisi eos velit sed id totam inventore voluptatem laborum et eveniet aut aut aut maxime quia temporibus ut omnis                      |

  Scenario Outline: Check that call for not-exiting comment returns 404
    When user requests for the comment by it's <id> as id
    Then response code is 404

    Examples:
      |id  |
      |0   |
      |-1  |
      |856 |
