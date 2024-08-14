#Feature: Calculator operations
#
#  Scenario Outline: Perform arithmetic operations with various inputs
#    Given I have a calculator
#    When I <operation> <num1> and <num2>
#    Then the result should be <result>
#
#    Examples:
#      # Positive scenarios
#      | operation | num1 | num2 | result |
#      | add       | 5    | 3    | 8      |
#      | add       | -5   | -3   | -8     |
#      | add       | 7    | -2   | 5      |
#      | add       | 0    | 0    | 0      |
#      | subtract  | 5    | 3    | 2      |
#      | subtract  | -5   | -3   | -2     |
#      | subtract  | 7    | -2   | 9      |
#      | subtract  | 5    | 0    | 5      |
#      | multiply  | 5    | 3    | 15     |
#      | multiply  | -5   | -3   | -15    |
#      | multiply  | 7    | -2   | -14    |
#      | multiply  | 5    | 0    | 0      |
#      | division  | 6    | 3    | 2      |
#      | division  | -6   | -3   | -2     |
#      | division  | 7    | -2   | -3.5   |
#      | division  | 0    | 5    | 5      |