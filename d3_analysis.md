# D3 Analysis
## System Description
Our application will be an impulse tracker application for android phones and tablets. We decided this based on what we found in our interviews which was, young adults frequently have issues with over-spending related to limited experience with their new luxury of disposable income. This app will be directed at young adults who need help keeping track of spending 

The Impulse Tracker mobile app provides an easy and intuitive way to track your impulse spending habits, helping you make the right choice with every purchase.
This app will help the user build healthier spending habits that prevent regret, impulsive spending, under-planning, and unsustainable purchases. 

This application will require the user to have a <u>username</u>, <u>email</u>, and <u>password</u> for **user login**. The application will allow for the user to <u>input</u>, <u>delete</u>, and <u>modify</u> **user information**, **financial information** and **purchases** as well as <u>create</u> **purchases** for the future and present.   

This application will also allow for users to search their their **purchase history** which contains all their **purchases**. Once a particular **purchase** is found the **search function** will <u>display the resulting</u> **purchase** and the user can then <u>delete</u> or <u>modify</u> the **purchase**.

Based on the **purchase history** the application will create *x plots* and *y plots* for every individual **purchase**, which then allows the application to create a spending graph based on *date (x axis)* and *price (y axis)*.
## UML Diagram
![alt text](https://github.com/CS386-ImpulseTracker/MobileApp/blob/stage/img/uml-diagram.JPG "UML")
## Class Responsibilities 
We have the UserLogin and UserLogout as the basic function for our user to use our software. 
We will use UserFunds as a record-keeper to record user’s finance information if they choose to use it. The UserProfile is for our user to enter their personal information and help determine the ValueItem. The ValueItem class is for the user, to help them decide about items that they want to buy. The Purchase class is used for recording items that the user bought. We also have the PurchaseHistory class to keep a listed history of goods purchased and logged by the user. Our final classes are the PurchasePlot, PurchaseGraph and SearchSpending. PurchaseGraph has the PurchasePlot class that it uses to create a spending history graph in the PurchaseGraph class. SarchSpending is a class that uses PurchaseHistory and is able to find items from the listed purchases.
