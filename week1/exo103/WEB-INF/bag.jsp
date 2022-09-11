<!DOCTYPE html>
    <head>
        <title>sac</title>
    </head>

    <body>
        <%@ page import="web.Bag" %>
        <%@ page session="false" %>

        <h1>sac</h1>
        <% 
            if (request.getAttribute("bag") != null) {
                out.println(request.getAttribute("bag"));
            } 
        %>
        
        <form action="/bag" method="post">
            <label>Article : </label><input name="article"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>