Feature: Create new user

  Scenario Outline: Create new user
    When user sends request to create new user with required data
      |name       |<name>       |
      |username   |<username>   |
      |email      |<email>      |
      |street     |<street>     |
      |suite      |<suite>      |
      |city       |<city>       |
      |zipcode    |<zipcode>    |
      |lat        |<lat>        |
      |lng        |<lng>        |
      |phone      |<phone>      |
      |website    |<website>    |
      |c_name     |<c_name>     |
      |catchPhrase|<catchPhrase>|
      |bs         |<bs>         |
    Then response code is 201
    And response returns correct user data
      |name       |<name>       |
      |username   |<username>   |
      |email      |<email>      |
      |street     |<street>     |
      |suite      |<suite>      |
      |city       |<city>       |
      |zipcode    |<zipcode>    |
      |lat        |<lat>        |
      |lng        |<lng>        |
      |phone      |<phone>      |
      |website    |<website>    |
      |c_name     |<c_name>     |
      |catchPhrase|<catchPhrase>|
      |bs         |<bs>         |

  Examples:
    |name           |username        |email               |street                  |suite           |city      |zipcode        |lat|lng|phone|website|c_name|catchPhrase|bs|
    |luctus accumsan|tortor posuere  |ac ut consequat     |semper viverra          |nam libero justo|laoreet   |sit amet cursus|luctus |accumsan |tortor |posuere |consequat |semper |viverra |
    |sit amet       |dictum sit amet |usto donec enim diam|vulputate ut pharetra   |sit amet aliquam|id diam   |maecenas       |libero |justo |laoreet |sit amet|cursus |sit amet|dictum |
    |ultricies mi   |eget            |mauris pharetra     |et ultrices neque ornare|aenean euismod  |elementum |nisi quis      |donec |enim |diam |vulputate |ut pharetra|aliquam |id diam|
