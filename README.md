Project Overview
In this project, I have implemented the logic for generating a JWT (JSON Web Token) 
when a user attempts to log in. The token is created only if the provided 
credentials are valid. Additionally, the user object is created dynamically at runtime using the
loadByUsername(String username) method of the UserDetailsService interface. 
This ensures that the user details are retrieved and authenticated during the login process.
