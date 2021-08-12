<?php 
$user = "root";  
$password = "WEB@12#$";  
$host = "localhost";  
$dbase = "mailinglist";  
$table = "users";  
$email= $_POST['email']; 

$dbc= mysqli_connect($host,$user,$password, $dbase)  
or die("Unable to select database"); 
 
 
$query= "INSERT INTO $table  ". "VALUES ('$email')"; 
 
mysqli_query ($dbc, $query) 
or die ("Error querying database"); 
 
echo '<script>alert("Thankyou for subscribing to our newsletter")</script>';
mysqli_close($dbc); 
header("Location: index.html");
 

 
?> 
 