Eyeretum Assignment


The server start with the following commands:
mvn spring-boot:run

The application is accessible in the browser at this url: http://localhost:8080/user

APIs:
 
These APIs are secure with Spring Security using BASIC authentication

Add on header : 
header Name = authorization 
header value = Basic YmlsbDphYmMxMjM=

- Retrieve an array of all users.

  ==> GET,  http://localhost:8080/user/all    


- Add a user. If a user with this email already exists, an error should be returned.

  ==> POST  http://localhost:8080/user
  
  JSON structure  :
  
{
	"email": "mail",
	"firstName": "firstname",
	"lastName": "lastname",
	"dateOfBirth": "12-05-2015",
	"phoneNumber" : "0126757789",	 
	"password" : "password"
}

- Remove a user. Should return a boolean value if the user was successfully deleted.
  
  ==> DELETE http://localhost:8080/user?email=

- Verify if provided password is correct for an existing user
  ==> POST http://localhost:8080/user/check?email= , password in argument  

For simplicity, I use an in-memory DB (HSQLDB)

