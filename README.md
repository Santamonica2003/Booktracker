# **BookTracker - Reading Tracking Application**

### Description

BookTracker is a command-line application that allows you to manage your reading history easily. You can add users, record books you've read, and retrieve statistical information about your reading habits.

### Features

Add new users.

Register books read and the number of pages read.

Modify the title of a registered book.

Delete reading records.

Check the average age of registered users.

Get the number of users who have read a specific book.

View the total number of pages read by all users.

Identify how many users have read more than one book.

### Installation and Usage

#### Requirements
To run BookTracker, you need:

- Java (JDK 11 or later) installed.
- SQLite (if you want to manage the database manually).

#### Installation

- Download the BookTracker.jar file or compile the source code (see developer instructions).
- Ensure that the booktracker.db database file is in the same folder as the program.

#### Basic Usage

Run the application from the terminal using:

java -jar BookTracker.jar

Once inside, you can access different options through the interactive menu.
Available Commands:

-Add a user:

-Enter their name and age when prompted.

-Register a book:

-Provide the title and the number of pages read.

-Check your reading history:

-View the list of books you have read.

-Modify a book title:

-Specify the current name and the new name.

-Delete a reading record:

-Enter the record ID.

-View statistics:

-Retrieve information about the user community.

#### Alternative Compilation Method
If the standard compilation method does not work, try compiling manually using the following command:

javac -cp "lib/sqlite-jdbc-3.49.1.0.jar" src/DatabaseConnection.java src/Main.java

This will generate the necessary .class files. Then, run the application with:

java -cp ".;lib/sqlite-jdbc-3.49.1.0.jar;src" Main

If you still encounter issues, ensure that:
-The JDBC driver is correctly located in the lib/ folder.

-The database file (booktracker.db) is in the correct location.

-You are using the correct Java version (JDK 11 or later).

#### Contact and Support

If you have any questions or issues, contact me.
