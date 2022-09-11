<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Exo101</title>
</head>

<body>
    <form method="post" class="form-signin">
        <label>latidude point A</label><input name="p1lat">    
        <label>longitude point A</label><input name="p1lng">  </br>

        <label>latidude point B</label><input name="p2lat">  
        <label>longitude point B</label><input name="p2lng">  </br>
            
        <button type="submit">OK</button>
    </form>

    <%
        String distance = (String) request.getAttribute("distance");
        if( distance != null ){
            out.println("Distance = " + distance + " km");
        }
    %>
</body>
</html>