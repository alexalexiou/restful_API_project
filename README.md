# restful_API_project

API description

root: http: localhost:8080


GET
•	/products
Returns all the products from the db

•	/products/name{name}
Returns product(s) by name
path parameter: name

•	/products/price/desc
Returns products in descending order

•	/products/price/asc
Returns products in ascending order

•	/products/code/{code}
Returns product(s) by code
Path parameter: code

POST
•	/products
Inserts new products
Request Body: Product object

PUT
•	/products
Updates products
Request Body: Product object
	Path parameter: id

DELETE
•	/products/{id}
Deletes the product with the specific id
path parameter: id




- Database

•	H2 in memory database was used, since it can be used locally, similar to the recommended in the assignment SQLite. The DB is preloaded with a few entries for the convenience of testing.

Bonus:

1.	Describe in freeform text how much of your API / Code would be reused if you were to also develop an API that would be consumed from the mobile application (used by Vodafone Customers)?

Http needs to be changed to https since mobile platforms enforce https. The rest of the code doesn’t need any change. 


2.	User authentication: How would secure your API if you were requested to do so?

JWT (JSON Web Token)
Offers secure user authentication and encrypted transmission of the data through JWE (JSON Web Encryption)


- Compile and Run instructions

To compile and run the project using maven:

1.

	mvn compile
	mvn package
	java -jar target/rest_web_services_coding_assig-0.0.1-SNAPSHOT.jar

OR

2.

import the project into your IDE, using maven and run from there
