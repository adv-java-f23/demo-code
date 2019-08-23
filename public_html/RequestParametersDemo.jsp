<html>
  <head>
    <title>Team All By Myself</title>
  </head>

  <body>
    <h2>Request: a predefined JSP variable, specifically request.getParameter</h2>
    <h2>Description</h2>

    <strong>Official Oracle Definition:</strong><br/><br/>
        "Returns the value of a request parameter as a String , or null if the parameter does not exist. Request parameters are extra information sent with the request. For HTTP servlets,
          parameters are contained in the query string or posted form data."

   <p> <strong>Explanation:</strong><br/><br/>
        Remember that a JSP ultimately becomes a servlet in our java web applications.
            Just as servlets receive a request and produce a response, so too, do JSPs.

            <p>

            We might think of the "Request" as the request for some information.
            Part of that request (the explicit data) might include the text
            entered into a form.  When a form is submitted using a "GET" request
            (as opposed to a "POST"), we can view that request information in the browser address bar as shown below.
            <p>
            <img src="images/AmazonSearchExample.png" />
        <p>

            Above, the request parameters are listed with their values after the ?, which looks something like:<br> <strong>http://hosturl?parameter1=value1&amp;parameter2=value2</strong><br/>
        <p>
        <strong>The bottom line:</strong><br>
        request.getParameter allows us to retrieve values based on the parameter name.


    <br />
    <h2>Syntax</h2>
        Placing &lt;%=request.getParameter("parameter1")%&gt; in a jsp should write out the value of parameter1, or, using the example above: value1.

    <h2>Example</h2>
        This page is a working example of the code. To see it in action, append ?param1=stuff to the url and view the value below.<p>
        Here is the param1 value: <%=request.getParameter("param1")%>
    <h2>JSP Translator</h2>

    <p>
        <img src="images/translated.png" />
    <p>
        <img src="images/translated1.png" />

    <h2>Best Practices</h2>
        Use request.getParameter when you want to retrieve a parameter from a request.<br />
    <h2>Drawbacks</h2>
        <ol><li>Generally "request.getParameter()" will be used in servlets, as we tend not to use too much server side scripting in our view (jsp).
        </li>Null and Strings.

            <h2>Resources</h2>
    <a href="https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html">https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html</a>
  </body>
</html>