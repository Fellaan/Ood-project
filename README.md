# Ood-project

# Project description:
This project is about us making a program that can create sustainable products using various materials and calculating their environmental impact.
We will make a menu based program that is run in the console without a GUI.

# System purpose:
The program creates, lists, views and calculates the materials and products environmental impact aswell as the cost of making the products.

# Team roles:
Paul - Software Developer  
Felix - Software Developer  
Leo - Software Developer  
Johan - Software Developer  
Isak - Software Developer  

# Git workflow description
A branch named version/development which goes parallel to main  
## Branch Structure:  
Feature/ClassName/MethodName/Datum


# List of domain concepts
## Nouns :  
Material  
Product   
Menu  
Account  
Name  
Recycling Category  
Product Category  
Lifespan  
Environmental Impact  

## Verbs:  
Create (create objects/products with chosen material, accounts)  
Change ( Change an object e.g Changing the material of an existing product)  
List / View (Display created products / Materials  / material usage / view detailed list etc… )  
Delete (A created item/product etc)  
Calculate ( environmental impact, lifespan, price of product)  

# Class/Layer representation:  

## Domain Layer/Business logic:  
Account  
ImpactCalculationStrategy (interface)  
Material  
Product  
RecyclingGuidance  
WeightedByLifespanStrategy  
SimpleSumStrategy  
  
## Application Layer/Use Cases:  
ProductApplicationService  
MaterialApplicationService  
LoginService  
  
## Presentation Layer:  
ConsoleUi  
More menus will be added as we go further in project.  

## Infrastructure Layer:  
Repository (interface)  
productRepository  
materialRepository  
recyclingRepository  
accountRepository  

# Motivation:  
ImpactCalculationStrategy interface was placed in the domain layer because it is/contains business logic.  
Repository interface was placed in the infrastructure layer beacuse it is only used to save and load files with different repositories. We decided to use an interface beacause if we wanted to expand the program with other saves/loads we can easily implement the interface which is good according to the OCP principle.  

# Dependency direction:  
The dependency direction goes from presentation layer --> application layer --> domain layer where the presentation layer calls the application layer and the application layer calls the domain layer.  
The application layer works as a "transporter" between presentation and domain.  
## Presentation layer
This layer is only a presenter, it takes an input from the user, delegates to the application layer and the presents the returned information as an output to the user.  

## Application layer
This layer is our use cases and our services, this layer calls our repositories and also calls the domain layer.  

## Domain layer
This layer is the business logic, it contains no framework imports and is pure java/code.  
