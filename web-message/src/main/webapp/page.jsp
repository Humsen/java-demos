<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页器</title>
</head>

<link href="css/pager.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/pager.js"></script>

<body>
 <div id="pager"></div>
 <script>
		function doChangePage(obj) {
			//TO DO
		}
		var pagerBox = document.getElementById('pager');

		var pager = new Pager({
			index : 1,
			total : 15,
			parent : pagerBox,
			onchange : doChangePage
		});
	</script>
</body>
</html>
	