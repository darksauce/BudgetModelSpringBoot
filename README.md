## Budget Modelling with Spring Boot REST API and Angular 11 Front End UI
This project is a Budget Modelling Application based on Spring Boot/REST API,
and an Angular 11 front-end user interface.

Users can enter income and expense events that occur in their budget, indicating the frequency
and amount of each budget item, and then project their budget into the future, by first providing
a starting balance.

## Build Spring Boot
The Spring Boot back-end code can be built using Maven:

`mvn clean install`

## Run Spring Boot
The Spring Boot back-end REST services can be run with Java:

`java -cp <classpath> au.com.whitellama.budgetmodelling.BudgetModellingApplication`

## Run Angular Front End
See the README file in the ng/budget-model folder for build/run instructions of Angular UI.
