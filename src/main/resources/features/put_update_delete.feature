Feature: User is able to create, edit and delete posts

  Scenario Outline: Create post
    When user creates new post with parameters <title>, <body>, <userId>
    Then response code is 201
    And response contains new post id <postId>
    And response contains сorrect parameters <title>, <body>, <userId>

    Examples:
      |title  |body | userId | postId|
      |foo    |boo  | 1      | 101   |


  Scenario Outline: Update post
    When user updates a post field with value
    Then response code is 200
    And response returns updated value

    Examples:
    |id |name                                                            |
    |1   |id labore ex et quam laborum                                   |
    |100 |et sint quia dolor et est ea nulla cum                         |
    |161 |nesciunt quidem veritatis alias odit nisi voluptatem non est   |
    |276 |inventore amet ut debitis ipsam reiciendis molestiae autem sed |
    |500 |ex eaque eum natus                                             |


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