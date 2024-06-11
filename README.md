# Automation Exercise 1

# Overview

This exercise demonstrates the testing framework that supports Behavior Driven Development for Automation Testing of web applications. 

# Goal

Create an automated script that will cover the below scenario.

1.	Open https://risk.lexisnexis.co.uk/ 

2.	Please make sure the elements below are present and clickable:

In Home page, Under Choose Your Industry heading 

-	Financial Services
-	Insurance
-	Life and Pensions
-	Corporations and Non-Profits

In Choose your Industry Tab, Select an Industry, then Select Financial Services

-	Financial Crime Compliance
-	Customer Data Management
-	Collections & Recovery
-	Risk Orchestration
-	Fraud and Identity Management
-	Credit Risk Assessment
-	Investigations and Due Diligence

# Report

Test results should be handled by designated reporting tool

# Criteria

The tests are first written in a simple scenario form that describes the expected behavior of the system from the users perpective. 
Cucumber must be easily read 

Note: Any popup windows like “Accept cookies” must be handled gracefully. 

# Technologies

Stack: Java, Selenium, Cucumber

Reporting:  JUnit

# Usage

Use ``mvn test`` to execute the test & results will be stored in ``Report1`` 
