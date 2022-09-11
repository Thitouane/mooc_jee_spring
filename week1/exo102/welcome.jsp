<%
// TODO : check if authenticated !
//   if not : show an error an a link to auth.jsp
if (session.getAttribute("auth") == null || session.getAttribute("auth") == "error") {
    out.print("<h1>Error</h1>")
    out.print("[ <a href="/exo102/auth.jsp" style="color: red; text-decoration: none">REDIRECT</a> ]")
} else {
    out.print("<h1>Welcome Admin !</h1>");
    out.print("[ <a href="auth?logout" style="color: red; text-decoration: none">DISCONNECT</a> ]");
}
%>