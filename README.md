# Digital Library

## Objective
The main objective of this project was to learn to digitize a product. 
In this case, it was a library. Due to the rise of the digital format, 
we were tasked with modeling and coding an app that allows cataloging any type of resource 
that might exists in the library. Initially, we focused on books
but designed the program to include other resources in the future.
## Basic Functions
The following basic functions were required for managing the library's book collection:
- **User Management**
  - Register, delete, or update a user
  - View a list of all registered users
- **Resource Management**
  - Register, delete, or update a resource
  - View a list of all registered resources
- **Loan Management**
  - Register or delete a loan
  - View all active loans (loans where the resource has not yet been returned)
  - View all finished loans (loans where the resource has already been returned)

## Additional Functionalities
As the project progressed, I implemented additional functionalities such as:
- **Resource Availability**
  - Check if a resource is available or not
- **Support for Multiple Resource Types**
  - Initially, only books were supported. I extended the catalog to include music 
and designed the program to allow future expansion to other types of digital resources.
- **Events Model**
  - A new model desgined speifically to try from moving stored data in cache to files, applying the open-close principle from SOLID.
-**Dynamic Menus**
  - Using an interface to develop a main menu and separate menus for each model, 
allowing access to the management options and navigation back and forth through the menus.
-**Enhanced Data Access Logic**
  - In the user model, I modified the `getUser` and `getAllUsers` methods to first check the cache. 
If the data is not found there, they look to retrieve it from files.
- **Testing**
  - Added a total of 42 tests covering all use cases for all models.
 Additionally, the user model tests include the data layer and the presentation layer.

As of 25/05/2024 the program works as intended and passes all tests
