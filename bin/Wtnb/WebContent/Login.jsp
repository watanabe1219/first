
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

		<head>
		<!-- cssの呼び出しURL」 -->
			<link rel="stylesheet" href="Login.css" type="text/css" />
			<meta charset="UTF-8">
			<title>Login♪</title>

			<div class="title">

			<h1>⋱╲　QUARTET　╱⋰</h1>

			</div>

		</head>

		<body>

					<!-- 送信先 -->
					<!-- actionにはweb.xmlで書いたパス -->
					<form method="post" action="Login">


		<div class="LOGIN">

				<h2>L O G I N</h2>
				<h5>☆彡　Welcome　☆彡</h5>


		</div>

		<br>


		<div class="NP">
			<p><!-- formにてname、pass、ボタンの情報を送信 -->
				▼Name...
					<input type="text"name="name"><br>

			</p>
			<p>
				▼Password...
					<input type="password" name="pass"><br>

					<div class="LoginB">

				<input type="submit" value="LOGIN" style="text-align:center" class="LOGINBB">

		</div>
		</div>


			</form>
		</body>
</html>