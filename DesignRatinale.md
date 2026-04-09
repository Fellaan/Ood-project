# Identified Weaknesses  
Product, material and LoginManager was doing too much which goes against the principle of SRP. We remade ImpactCalculationStrategy from a class to an Interfacce making it so classes can implement and fulfill OCP and DIP.  
Seeing that Product would have been responsible for everything regarding products as creating new products, save a list of all products, remove products and show products this would have caused testing issues aswell as a harder time to make changes. This applies to Material aswell.  
With these weaknesses it would have been painful to do anything in the program because we were unable to save objects in lists since the lists would have been overwritten everytime we created a new object. The managers got deleted and it's functionallity got moved to application services.  
  
# Applied Principles
In our case we hadn't applied SRP (Single Responsibility Principle) as both Product and Material was responsible for more than one thing.  
Too make the program more flexible, applying all three of the principles it allows for changes and extensions to be added later on in develpoment.  

# Refactoring Move
We added layers to our UML/program so that our UI and business logic is not in direct contact with eachother making it so that the UI doesn't call the methods directly and instead uses ApplicationService to reach the core of the program.  
We added many new classes to make the program more functional such as, ConsoleUI, ProductApplicationService, MaterialApplicationService, LoginService, SimpleSumStrategy, WeightedByLifespanStrategy. ImpactCalculationStrategy got changed from a standalone class to an Interface.   
With the help of our ApplicationService classes we solved the issue where UI cant be in direct contacct with business logic.  
  
# Design Impact
We can now change within the code/business logic without affecting how the UI behaves.  
Testing have become possible since no tests were able to be run from the V.1 UML design. We are also able to add new methods and classes without the program gets affected as a whole.
