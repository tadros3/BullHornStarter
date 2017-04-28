# Redirect from Servlet Example
This example illustrates many of the concepts of a Java EE application. We still have not connected to the database yet but we'll do that soon. To account for the database I've created classes such as DbUser which will be modified to connect to the database.

### Use the following commands to clone this project from GitHub


### Use the following commands to modify the git configuaration 

### Add the following lines of code back to the project to make it work again
I created the complete application and tested it. So it was working. Then I decided to make your life difficult by removing the following lines of code from somewhere in the project. Each line of code is the complete line of code and I did not intruduce any errors other than removing it from where it was and placing it in the list below. 

To get the application working again simply copy each line of code below back to where it came from.



### Review
#### By now you should have the application working again. Answer the following questions:
what is the action of the login form?
right-click on LoginServlet and select Run as. You should see the error page. Do you know why?
Now, right-click on the login.jsp and select Run as. You will see the login page. 
The title on every page is different. What are some ways you could use to make the title consistent on every page? Think about what would happen if you wanted to change the title on every page. How would you modify your application to allow you to change the title in only one place?
2. is the data for the login form sent through the url or embedded in the form object that is sent to the web server?
3. what is the name of the web server we are using?
4. when the data is sent to the web server what does the web server do next?
5. when is the data sent to the web server?
6. what data is sent to the web server?
7. write down the different methods that are executed (in order) once the user clicks "Login"
8. when using JSTL (the Java Standard Tag Library) which page directive must you include at the top of the JSP page?
9. modify this application to add another JSP for adding a new user. Create the JSP, name it adduser.jsp. Add it to the login page. That way if a user finds the login page but hasn't joined the site they would click on the "New User" link and go to the adduser.jsp. When adduser.jsp opens the user will see a form prompting for their username, email, password and motto. Don't worry about making the form work yet. We'll get to that later.
10. Make the addUser.jsp work. Since we haven't added the database to the site yet you only have to create a servlet to receive the data for addUser.jsp. You should be able to do that by now. Use login.jsp to motivate you.