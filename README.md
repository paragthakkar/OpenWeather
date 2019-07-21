# Project Title
## Automation of OpenWeather Web Application using Selenium and Bdd Framework (Cucumber)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Running through Maven or Jenkins](#running-through-maven-or-jenkins)
* [Contact](#contact)

## General info
This project is to demonstrate the automation of the web application called "OpenWeather" that helps you to fetch the weather details for any specific city in the world.
	
## Technologies
Project is created with:
* Cucumber
* Page Object Model
* JUnit
* Extent Reporting
* Test Listeners
* Rest Assured

  
## Running through Maven or Jenkins
* Clone the project from the repository URL onto your local system:
```
$ git clone https://github.com/paragthakkar/OpenWeather.git
```

* Open the Project in Eclipse and and build the project and let the dependencies download

* To run this project locally using Eclipse, right-click on the TestRunner.java class and click "Run As" >> "JUnit Test"

* Once the Test Run completes, the report is generated automatically under Reports folder as "OpenWeatherTestReport.html"

* To run this project locally using Maven, open CMD, navigate to the path where the POM.xml is present and simply run the command:

```
$ mvn test
```
* To run this project locally using Jenkins, install Maven plugin and configure Jenkins Maven command:

```
$ clean install
```
And create a Maven Project job in Jenkins and mention the Workspace URL under Build tab, save the job and click Build Now.

## Contact
* Name : Parag Thakkar
* Email : theparagthakkar@gmail.com
