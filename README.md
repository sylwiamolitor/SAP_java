 # Application Instructions

## RESTful Spring Boot App

This application is a RESTful Spring Boot application that implements several algorithms and returns results based on a given integer number. The algorithms are accessible through specific endpoints.

## Running the Application

To run the application, use the following URL:

http://localhost:8080/

## Interacting with the Application

Once the application is running, you will see four buttons corresponding to four exercises. You can press any of these buttons to execute the respective exercise.

### Changing the Default Value

The application has a default value of `55`. To change this value, modify the last number in the URL. For example:

- **Default URL:** `http://localhost:8080/ex4/55`
- **Modified URL:** `http://localhost:8080/ex4/2`

This will change the value used for the exercise.

### Using the URL at the Beginning

You can also directly enter the desired URL at the beginning to execute a specific exercise with a custom value.

### Handling Invalid Input

If you enter a letter instead of a number in the URL, the application will calculate the result using the number `0`.

## Example URLs

- To execute exercise 4 with the default value:  
  `http://localhost:8080/ex4/55`

- To execute exercise 4 with a custom value of `2`:  
  `http://localhost:8080/ex4/2`

- To test invalid input (using a letter):  
  `http://localhost:8080/ex4/a`
  - Result will be calculated as if the input was `0`.
