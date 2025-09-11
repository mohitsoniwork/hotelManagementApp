Mohit’s Hotel Reservation App
Description

It is a console-based Java application that I implemented from scratch, following the architecture principles covered in the course.

The app demonstrates:

Designing classes using object-oriented programming

Managing and processing data using Java collections

Working with common Java data types

Using Maven for dependency management

Writing unit tests and mocking dependencies

The application allows customers to search for available rooms and make hotel reservations. It also includes an admin menu to manage customers and rooms.

Main menu:



How to Run in an IDE
Open the file:

text
src/main/java/com/udacity/hotel/HotelApplication.java
and run the main() method.

How to Run in Terminal
Navigate to the project’s source root:

bash
cd mohits-hotel-app/src/main/java
Compile the application:

bash
javac com/udacity/hotel/HotelApplication.java
Run the application:

bash
java com.udacity.hotel.HotelApplication
TODO
Priority
 Add instructions on how to run the app

 Add project description

 Add Javadoc for methods (especially public ones)

 Write unit tests

 Remove leftover FIXME and TODO tags

 Fix code issues reported by IntelliJ’s linter

 Add a code style enforcement plugin (Sonar) and resolve detected issues

Optional
 Improve error handling in UI layer

 Validate that check-in dates precede check-out dates

 Add check-in/out date validation in Reservation constructor

 Prevent duplicate bookings

 Refactor alternative date suggestions

 Sort printed output (reservations, customers)

 Add option to create rooms using the FreeRoom class

 Make classes final where applicable

 Verify against project specification

 Include variable values in exception messages

 Format printed dates to exclude time component

New Features to Implement
 Enhance room search to filter by free or paid rooms

 Add admin option to populate system with test data (customers, rooms, reservations)

 Allow configurable search for recommended rooms (e.g., within N days if no rooms are available)

