Feature: Posts API call returns list of all posts

  Scenario Outline: Check a post author's id
    When user requests for the post by it's <id> as id
    Then response code is 200
    And response for the post returns correct user ID <userID>

    Examples:
      |id |userID |
      |1  |1      |
      |17 |2      |
      |55 |6      |
      |80 |8      |
      |100|10     |

  Scenario Outline: Check a post title
    When user requests for the post by it's <id> as id
    Then response code is 200
    And response for the post returns correct title <title>

    Examples:
    |id |title                                                                     |
    |1  |sunt aut facere repellat provident occaecati excepturi optio reprehenderit|
    |9  |nesciunt iure omnis dolorem tempora et accusantium                        |
    |35 |id nihil consequatur molestias animi provident                            |
    |98 |laboriosam dolor voluptates                                               |
    |100|at nam consequatur ea labore ea harum                                     |

  Scenario Outline: Check a post body
    When user requests for the post by it's <id> as id
    Then response code is 200
    And response for the post returns correct body <body>

    Examples:
      |id |body                                                                                                                                                           |
      |1  |quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto |
      |18 |eveniet quo quis laborum totam consequatur non dolor ut et est repudiandae est voluptatem vel debitis et magnam                                                |
      |60 |asperiores sunt ab assumenda cumque modi velit qui esse omnis voluptate et fuga perferendis voluptas illo ratione amet aut et omnis                            |
      |76 |ut animi facere totam iusto tempore molestiae eum aut et dolorem aperiam quaerat recusandae totam odio                                                         |
      |100|cupiditate quo est a modi nesciunt soluta ipsa voluptas error itaque dicta in autem qui minus magnam et distinctio eum accusamus ratione error aut             |


    Scenario Outline: Check that call for not-exiting post returns 404
      When user requests for the post by it's <id> as id
      Then response code is 404

      Examples:
        |id  |
        |0   |
        |-1  |
        |856 |
