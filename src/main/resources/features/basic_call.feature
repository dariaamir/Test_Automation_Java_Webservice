Feature: Basic call

Scenario: basic
  When User sends a call to address
  Then response code is 200
  And response answer id is 1