# Redirect from Servlet Example
This example illustrates many of the concepts of a Java EE application. We still have not connected to the database yet but we'll do that soon. To account for the database I've created classes such as `DbUser` which will be modified to connect to the database. DbUser will not go away... it will be the class that calls the database.

### Use the following command to clone this project from GitHub

```console
git clone https://<YOUR_GITHUB_USERNAME>@github.com/dave45678/BullhornStarter
```
### Use the following commands to modify the git configuaration 
Be sure to create your own git repository. If you call it anything other than
BullhornStarter then change the url below to match.
```console
git remote set-url origin https://<YOUR_GITHUB_USERNAME>@github.com/<YOUR_GITHUB_USERNAME>/BullhornStarter
```

### Add the following blocks of code back to the project to make it work again
I created the complete application and tested it. So it was working. Then I decided to make your day ~~difficult~~ fun by removing some blocks of code from somewhere in the project. Only I know where. And by tomorrow I'll have forgotten. 

Each block of code below is the complete code that was removed. I did not introduce any errors other than removing it from where it was and placing it below. You will not need to write any new code. 
You only have to cut each block of code below and paste it back where it belongs.

```java
@WebServlet("/ProfileServlet")
```
```html
<li><a href="feedback.jsp">Feedback</a></li>
```

```java
if(!action.isEmpty()||!(action==null)){
    if (request.getParameter("action").toString().equals("logout")){
        //Go back to login.jsp. 
        nextPage = "/login.jsp";
        response.sendRedirect(request.getContextPath() + nextPage);
        return;//return here exits the method and prevents an error
    }else{
        nextPage = "/home.jsp";
    }
}
```

```java
getServletContext().getRequestDispatcher(nextURL).forward(request,response);
```

```java
public static boolean isValidUser(String email, String password) {
    //at this point your code would query the database to see if this user
    //and password are valid then return either true or false
    //for the moment we'll assume they are valid
    return true;
}
```


### Review
#### By now you should have the application working again. Answer the following questions:
* what is the action of the login form?
* right-click on LoginServlet and select Run as. You should see the error page. Do you know why?
* Now, right-click on the login.jsp and select Run as. You will see the login page. 
* The title on every page is different. What are some ways you could use to make the title consistent on every page? Think about what would happen if you wanted to change the title on every page. How would you modify your application to allow you to change the title in only one place?
* is the data for the login form sent through the url or embedded in the form object that is sent to the web server?
*  what is the name of the web server we are using?
* when the data is sent from login.jsp to the web server what does the web server do next?
* when is the login data (email and password) actually sent to the web server?
* what data is sent to the web server?
* write down the different methods that are executed (in order) once the user clicks "Login"
* when using JSTL (the Java Standard Tag Library) which page directive must you include at the top of the JSP page?
* modify this application to add another JSP for adding a new user. Create the JSP, name it adduser.jsp. Add it to the login page. That way if a user finds the login page but hasn't joined the site they would click on the "New User" link and go to the adduser.jsp. When adduser.jsp opens the user will see a form prompting for their username, email, password and motto. Don't worry about making the form work yet. We'll get to that later.
* Make the addUser.jsp work. Since we haven't added the database to the site yet you only have to create a servlet to receive the data for addUser.jsp. You should be able to do that by now. Use login.jsp to motivate you.

### Modifications
Things you should do now...

Modify feedback.jsp to contain the following form. Then modify this form to make it go to a servlet called Feedback.java. You will need to create the Feedback servlet.

This servlet will receive the feedback from the form and store the values in variables. After we connect the database we will put the values of these variables in the database. So you should modify the doPost method of the FeedbackServlet to receive the data from this form and store it in Java variables.

```html
<form action="" method="post">
  <input type="radio" name="subject" value="Question" checked> Question<br>
  <input type="radio" name="subject" value="Complaint"> Complaint<br>
  <input type="radio" name="subject" value="Comment"> Comment<br><br>
  <textarea name="feedback" rows="6" cols="50"></textarea><br><br>
  <input type="submit" value="Send Feedback">
</form> 
```
---
Look at navbar.jsp. You will see several list items in the unordered list. Each is denoted with an `<li>` tag. 
Modify each `<li>` tag to include a style attribute to display inline as follows:

```html
<li style="display: inline;">
 ```
 Notice how this changes the display of your unordered list when you refresh a page that uses the navbar.
 
 ---
The following code can be found in the ProfileServlet. You can put this code in any servlet that to ensure the user is logged in. Then if they are not they will be redirected to login.jsp. Make that modification now. BUt don't check the LoginServlet! They won't be logged in there!

```java
//make sure a user is in the session. If they don't exist then go back to the login page.
if (session.getAttribute("user")==null){
    //http://stackoverflow.com/questions/13638446/checking-servlet-session-attribute-value-in-jsp-file
    nextURL = "/login.jsp";
    response.sendRedirect(request.getContextPath() + nextURL);
    return;//return prevents an error; Don't believe me? Take it out.
}
 ```
---
Create the Newsfeed servlet. It will be called from the navbar. When the servlet is called it will go to the database and get all the posts as an arraylist. The arraylist will be sent to the newsfeed.jsp using `request.setAttribute("posts",posts)`.

**Example Code**

```java
ArrayList<Post> posts = new ArrayList<Post>();
//create a class called Post that contains email and text fields.
Post p = new Post();
p.setEmail("lisa@fox.net");
p.setText("This is the text of my post");
posts.add(p);
```
