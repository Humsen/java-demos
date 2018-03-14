<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言区设计</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/message.css">

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/message.js"></script>

</head>
<body>
	<div>
    <form style="width: 805px">
      <textarea class="form-control meessage-input" rows="3" placeholder="请输入留言..."></textarea>
      <button type="submit" class="btn btn-success navbar-right" style="margin-top: 5px">提交留言</button>
    </form>
  </div>
  
  <div id="message_box">
  
  </div>

</body>
</html>