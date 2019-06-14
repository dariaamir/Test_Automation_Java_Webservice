Feature: User is able to create, edit and delete posts

  Scenario Outline: Create post
    When user creates new post with parameters <title>, <body> and <userId>
    Then response code is 201
    And response contains new post id <postId>


    Examples:
      |title                      |body                        | userId | postId|
      |Lorem ipsum dolor sit amet |consectetur adipiscing elit | 1      | 101   |



  Scenario Outline: Update a post
    When user finds a post by id <postId> and updates one field <post_field> with new value <new_value>
    Then response code is 200
    And response returns updated value <new_value> at the changed field <post_field>

    Examples:
    |postId|post_field |new_value                   |
    |1     |userID     | 2                          |
    |2     |title      |Lorem ipsum dolor sit ametm |
    |3     |body       |consectetur adipiscing elit |



  Scenario Outline: Delete post
    When user deleted post by post id <postId>
    Then response code is 200

  Examples:
    |postId  |
    |1       |
    |101     |
    |255     |
    |379     |
    |500     |