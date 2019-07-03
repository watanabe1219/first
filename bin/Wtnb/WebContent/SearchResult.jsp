<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- import -->
<%@ page import="java.util.ArrayList"%>
<%@ page import="nkym.SearchBean"%>
<% ArrayList<SearchBean> list = (ArrayList<SearchBean>)session.getAttribute("productList"); %>
<html>
	<head>
		<link rel="stylesheet" href="menu.css" type="text/css" />
		<link rel="stylesheet" href="SR.css" type="text/css" />
		<meta charset="UTF-8">
		<title>SarchResult♪</title>
	</head>

	<body>
		<header>
			<div class="title">
				<h1>⋱╲	QUARTET	╱⋰</h1>
			</div>
		</header>

		<div class="menu">
			<ul>
				<li><a href="Search.jsp">H o m e</a></li>
				<li><a href="Cart.jsp">C a r t</a></li>
				<li><a href="SearchResult.jsp">P r o d u c t  L i s t</a></li>
			</ul>
		</div>

		<form action = "SearchSurvlet" method ="POST">
			<div class="kensaku">
				<h2>◇ K E N S A K U ◇</h2>

				<input type="text" name="search">

				<select name="category">
					<option value="家電" style="font-family:'Impact'">家電</option>
					<option value="コスメ" style="font-family:'Impact'">コスメ</option>
					<option value="食品" style="font-family:'Impact'">食品</option>
					<option value="生活用品" style="font-family:'Impact'">生活用品</option>
					<option value="ゲーム" style="font-family:'Impact'">ゲーム</option>
				</select>
			</div>

			<div class="kensakuB">
				<input type="submit"value="KENSAKU"class="kensakuBB"name="search">
			</div>
		</form>

		<!-- ArrayList sblに値がない場合 -->

		<%if( list.size() == 0) {%>
			<div class="box">
				<h4>検索結果がありません(>ω< ;)</h4>
			</div>
		<!-- ArrayList sbl に値がある場合には上から順に表示 -->

		<%} else if(list.size() != 0){%>

		<!-- form機能で表示された商品名に該当する
			 ArrayList sbl内のパラメータをItemServletに送信 -->

			<form action ="ItemServlet" method = POST>
				<table align="center">
					<tr>
						<th>商品名</th>
						<th>価格</th>
						<th>詳細</th>
					</tr>
					<% for(SearchBean search:list) { %>
						<tr>
							<td><%= search.getName() %></td>
							<td><%= search.getPrice() %></td>
							<td><input id="syousai" type = "submit" class="SSBB" name="<%= search.getName() %>"  value ="詳細"></td>
						</tr>
					<% }%>
				</table>
			</form>
		<% }%>
	</body>
</html>