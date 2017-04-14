<%@ page pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="utf-8">  
<title>上传图片</title>  
</head>  
<body>  
<script type="text/javascript">

 $.ajax({
                    type: "post",                  
                    url: "Upload",
                    data: 'name=1212',
                    datatype:"text",                    
                     success: function(data) {  
                     var result = JSON.parse(data);
                     alert("1212121");
                      alert(result);                     
                     },
                    });
                    </script>
<form action="Upload" method="post" enctype="multipart/form-data">  
<input type="file" name="file" /> <input type="submit" value="Submit" /></form>  
</body>  
</html>  