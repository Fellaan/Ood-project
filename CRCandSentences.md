Week 2 - CRC and responsibility sentences  
  
## Class name Product  
 
| Responsibility                                |  Collaboration  |
 |-------|------|
| Knows its name, category, estimated lifespan  | Material  |
| Maintain list of materials (1…*) ( This contains amount of material in grams )    | Material  |    
 |Calculate total environmental impact          | Material, impact calculation strategy   |
 |Total product cost                            | Material, PriceCalculation   |
 
 
Product is responsible for representing a physical item that can be assessed of its environmental impact.   
The Product should know its name, category and estimated lifespan. It shall maintain a list of materials,   
its weight and use that composition to calculate total environmental impact as well as cost of material.  
  
  
## Class name Material  

|Responsibility                               | Collaboration|  
|-----------------------------------|------------------------------------|
|Knows it’s name, environmental impact, price/g       |  Product| 
| Knows its Recycling category and instruction | Product (Referenced by) |   
| Be reusable across multiple products  | | 
  
Material is responsible for representing the materials a product will be made of.   
Material should know its name/type, environmental impact,   
price, recycling category and be able to be used by multiple products.   
  
## Class name ImpactCalculationStrategy  
  
| Responsibility                             | Collaboration  | 
 |-----------------------------------|------------------------------------|
| Define a strategy for environmental impact | Product  | 
| Be compatible with other strategies        | Material  | 
| Compute a result from materials  | | 
  
ImpactCalculationStrategy is responsible for calculating the environmental impact of a product.   
It should know the calculation strategies. Where it can use different strategies to calculate and compute a result.  
  
## Class name RecyclingGuidance   
  
| Responsibility                                 | Collaboration | 
|-----------------------------------|------------------------------------|
| Derive ?product category / recycling guidance? for a product | Product  |   
| Handle special edge cases                      | RecyclingCategory  |   
| Combine rules across products                  | Product  | 
  
RecyclingGuidance is responsible for showcasing how to recycle a product.  
It can derive a ?products category / Recycle Guidance?,   
handle special edge cases and combine rules across different products.  
  
## Class name RecyclingCategory  
  
| Responsibility                          | Collaboration|   
|-----------------------------------|------------------------------------|
| Classify a materials category           | Material (owned by)|     
| Carry a recycling label                 | Recycling Guidance  |   
| Be stable and reusable across materials |  | 
  
RecyclingCategory is responsible for knowing the category of a material.  
It has a recycling label which is usable across different materials.  
  
## Class name LoginManager  
  
| Responsibility                  | Collaboration|   
|-----------------------------------|------------------------------------|
| Holds a list of accounts that exist in the program   |  Account|   
|Handles login verification      |  |
  
LoginManager is responsible for storing a list of accounts as well   
as verifying login credentials. LoginManager should know all of the existing   
registered accounts.  
  
## Class name Account  
  
|Responsibility            |Collaboration|   
|-----------------------------------|------------------------------------|
|Knows username, password and access privileges |  LoginManager |  

Account is responsible for storing accounts that will access the program and   
the privileges of each account. It knows the username and password of each account   
and if the account has access privileges.  
  
## Class name PriceCalculation  
  
|Responsibility  | Collaboration | 
|-----------------------------------|------------------------------------|
|Calculates the material cost of the product | Product |  

PriceCalculation calculates the material cost for the product.   
It knows the calculation methods.  


























