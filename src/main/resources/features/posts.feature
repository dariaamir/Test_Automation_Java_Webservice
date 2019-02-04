Feature: Posts API call returns list of all posts

  Background:

  Scenario Outline: Check a post author's id
    When user requests for the post by it's <id> as id
    Then response code is 200
    And response for the post returns correct <userID> as user ID

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
  And response for the post returns correct <title> as title

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
  And response for the post returns correct <body> as body

  Examples:
    |id |body                                                                                                                                                               |
    |1  |"quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"|
    |18 |"eveniet quo quis\nlaborum totam consequatur non dolor\nut et est repudiandae\nest voluptatem vel debitis et magnam"                                               |
    |60 |"asperiores sunt ab assumenda cumque modi velit\nqui esse omnis\nvoluptate et fuga perferendis voluptas\nillo ratione amet aut et omnis"                           |
    |76 |"ut animi facere\ntotam iusto tempore\nmolestiae eum aut et dolorem aperiam\nquaerat recusandae totam odio"                                                        |
    |100|"cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut"            |