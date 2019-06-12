Feature: User is able to create, edit and delete posts

  Scenario Outline: Create post
    When user creates new post with parameters <title>, <body> and <userId>
    Then response code is 201
    And response contains new post id <postId>


    Examples:
      |title                      |body                        | userId | postId|
      |Lorem ipsum dolor sit amet |consectetur adipiscing elit | 1      | 101   |


  Scenario Outline: Update a post
    When user updates a post with new values
    Then response code is 200
    And response returns updated values

    Examples:
      |post_field |new_value                   |
      |userID     | 2                          |
      |title      |Lorem ipsum dolor sit ametm |
      |body       |consectetur adipiscing elit |


  Scenario Outline: Update one value in the post
    When user finds a post by id <postId> and updates one field <post_field> with new value <new_value>
    Then response code is 200
    And response returns updated value <new_value> at the changed field <post_field>

    Examples:
    |postId|post_field |new_value                   |
    |1     |userID     | 2                          |
    |2     |title      |Lorem ipsum dolor sit ametm |
    |3     |body       |consectetur adipiscing elit |



  Scenario Outline: Delete post
    When user deleted post
    Then response code is 200

  Examples:
    |id  |email                   |
    |1   |Eliseo@gardner.biz      |
    |101 |Lura@rod.tv             |
    |255 |Delta_Welch@carleton.tv |
    |379 |Afton.Medhurst@mina.info|
    |500 |Emma@joanny.ca          |