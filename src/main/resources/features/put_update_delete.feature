Feature: User is able to create, edit and delete posts

  Scenario Outline: Create post
    When user creates new post with parameters
     |title |<title> |
     |body  |<body>  |
     |userId|<userId>|
    Then response code is 201
    Then response contains updated data
      |title |<title> |
      |body  |<body>  |
      |userId|<userId>|

    Examples:
      |title                      |body                                        | userId |
      |Lorem ipsum dolor sit amet |consectetur adipiscing elit                 | 1      |
      |Sed do eiusmod tempor      |incididunt ut labore et dolore magna aliqua | 2      |
      |Ut enim                    |ad minim veniam                             | 3      |


  Scenario Outline: Update a post
    When user finds a post by id and updates all post fields
      |postId |<postId> |
      |title |<title> |
      |body  |<body>  |
      |userId|<userId>|
    Then response code is 200
    And response contains updated data
      |title |<title> |
      |body  |<body>  |
      |userId|<userId>|

    Examples:
      |postId|title                         |body                                    |userId|
      |1     |Amet est placerat             |In egestas erat imperdiet               |5     |
      |2     |Turpis in eu mi bibendum      |Neque egestas congue quisque egestas    |6     |
      |3     |Sed egestas egestas fringilla |phasellus faucibus scelerisque eleifend |7     |




  Scenario Outline: Update one value in existing post
    When user finds a post by id and updates one field with new value
      |postId |<postId> |
      |post_field  |<post_field>  |
      |new_value|<new_value>|
    Then response code is 200
    And response returns updated value at the changed field
      |post_field  |<post_field>  |
      |new_value|<new_value>|

    Examples:
    |postId|post_field |new_value                   |
    |1     |userId     | 2                          |
    |2     |title      |Lorem ipsum dolor sit ametm |
    |3     |body       |consectetur adipiscing elit |



  Scenario Outline: Delete post
    When user deleted post by post id
      |postId|<postId>|
    Then response code is 200
    And response body is empty

  Examples:
    |postId  |
    |1       |
    |101     |
    |255     |
    |379     |
    |500     |