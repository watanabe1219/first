<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	<!-- cssのリンクurl -->
		<link rel="stylesheet" href="menu.css" type="text/css" />
		<meta charset="UTF-8">
		<title>Sarch♪</title>
	</head>

	<body>
		<header>
			<div class="title">
				<h1>⋱╲	QUARTET	╱⋰</h1>
			</div>
		</header>
						<!-- 各ページへのリンク -->
		<div class="menu">
			<ul>
						<!-- 検索ページへ -->
				<li><a href="Search.jsp">H o m e</a></li>
						<!-- カートページへ -->
				<li><a href="Cart.jsp">C a r t</a></li>
						<!-- 検索結果ページへ -->
				<li><a href="SearchResult.jsp">P r o d u c t  L i s t</a></li>
			</ul>
		</div>
			<!-- formにてSearchSurvletに以下のボタンの情報を送信 -->
		<form action = "SearchSurvlet" method ="POST">
			<div class="kensaku">
				<h2>◇ K E N S A K U ◇</h2>
			<!-- 商品名検索入力用のテキストボックス。サーブレットに「search」の
			値として送信 -->
				<input type="text" name="search">
				<span style="font-family:'Impact'">▼Category... </span>
			<!-- 商品のカテゴリー名 -->
				<select name="category">
					<option value="食品" style="font-family:'Impact'">食品</option>
					<option value="家電" style="font-family:'Impact'">家電</option>
					<option value="コスメ" style="font-family:'Impact'">コスメ</option>
					<option value="生活用品" style="font-family:'Impact'">生活用品</option>
					<option value="ゲーム" style="font-family:'Impact'">ゲーム</option>
				</select>
			</div>

			<div class="kensakuB">
				<input type="submit"value="KENSAKU"class="kensakuBB">
			</div>
		</form>
	</body>
</html>
