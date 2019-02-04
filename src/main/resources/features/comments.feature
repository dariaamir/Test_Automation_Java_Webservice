Feature: Posts API call returns list of all posts

  Scenario Outline: Check a post author's id
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct <postID> as post id

    Examples:
      |id  |postID |
      |1   |1      |
      |15  |3      |
      |196 |40     |
      |219 |44     |
      |500 |100    |


  Scenario Outline: Check a post title
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct <name> as name

    Examples:
    |id |name                                                            |
    |1   |id labore ex et quam laborum                                   |
    |100 |et sint quia dolor et est ea nulla cum                         |
    |161 |nesciunt quidem veritatis alias odit nisi voluptatem non est   |
    |276 |inventore amet ut debitis ipsam reiciendis molestiae autem sed |
    |500 |ex eaque eum natus                                             |


  Scenario Outline: Check a post body
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct <email> as email

  Examples:
    |id  |email                   |
    |1   |Eliseo@gardner.biz      |
    |101 |Lura@rod.tv             |
    |255 |Delta_Welch@carleton.tv  |
    |379 |Afton.Medhurst@mina.info |
    |500 |Emma@joanny.ca          |

  Scenario Outline: Check a post body
    When user requests for the comment by it's <id> as id
    Then response code is 200
    And response for the comment returns correct comment <body> as body

    Examples:
      |id  |body                                                                                                                                                                        |
      |1   |"laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"                   |
      |2   |"st natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"|
      |119 |"et omnis consequatur ut\nin suscipit et voluptatem\nanimi at ut\ndolores quos aut numquam esse praesentium aut placeat nam"                                                |
      |433 |"oluptatem minus asperiores quasi\nperspiciatis et aut blanditiis illo deserunt molestiae ab aperiam\nex minima sed omnis at\net repellat aut incidunt"                     |
      |500 |"perspiciatis quis doloremque\nveniam nisi eos velit sed\nid totam inventore voluptatem laborum et eveniet\naut aut aut maxime quia temporibus ut omnis"                    |