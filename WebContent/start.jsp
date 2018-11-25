<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <style>
   
      body {
         background-color : #E1E1E1;
      }
      
      header {
         text-align : center;
         
      }
      
      header a {
         text-dacoration : none;
         color : red;
      }
      
      header a:hover{
         text-decoration : underline;
      }
      
      nav {
         margin : 10px;
      }
      
      nav ul {
         list-style : none;
         text-align : center;
         border-top : 1px solid red;
         border-bottom : 1px solid red;
         padding : 10px 0;
      }
      
      nav ul li {
         display : inline;
         text-transform : uppercase;
         padding : 0 10px;
         letter-spacing : 10px;
      }
      
      nav ul a {
         text-dacoration : none;
         color : black;
      }
      
      nav ul li a:hover{
         text-decoration : underline;
      }
      
      img {
         height : 600px;
         width : 950px;
      }
      
      table {
         height : 750px;
         width : 1200px;
      }
      
      footer {
         text-align : center;
      }
      
      
   </style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data">
<header>
<h1><a href="start.one">Game Chang</a></h1>
</header>
   
<table align="center" border="0" cellspacing="0" cellpadding="1" style="text-align:justify">
   <tbody>
      <tr>
         <td style="width:70px;height:60px;">
           <div style = "text-align:center;line-height:1.8" align="center">
						<img src="mainimage_change.jpg" id="img"><br>
                  <input type="button" onclick="location.href='start.bo'" value="시작">
            </div>
         </td>
      
      </tr>
   
   </tbody>
   
   </table>
	
   <footer>404 Life Not Found</footer>
   </form>
</body>
</html>