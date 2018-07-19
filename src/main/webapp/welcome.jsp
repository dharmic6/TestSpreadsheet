<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	
	  <link rel="stylesheet" href="jqmath-0.4.3.css">
	
	<script src="jquery-1.4.3.min.js"></script>
	<script src="jqmath-etc-0.4.6.min.js" charset="utf-8"></script>
	
</head><body>

Upload File : <form action="fileupload" method="post" enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>

Text Upload.
<form action="textupload" method="post">
<textarea rows="100" cols="100" name="text">
Enter Text Here..
</textarea>
<input type="submit" value="Submit Text" />
</form>

${message}

</body>

</html>