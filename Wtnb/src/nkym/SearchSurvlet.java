package nkym;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchSurvlet extends HttpServlet {
	//SearchBean型のArraylist を定義
public static ArrayList<SearchBean> sbl;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//search.jspから受け取ったsearch、categoryに対応する値をそれぞれ取得
		String SearchWord = req.getParameter("search");
		String category = req.getParameter("category");
		System.out.println(SearchWord);
		//CategoryDBをインスタンス化
		CategoryDB cd = new CategoryDB();
		//SearchBean型のリストにgetProductメソッド
		//の引数SearchWord、Categoryの該当するものを上から順に格納
		sbl = cd.getProductDb(SearchWord, category);

		//RequestDispatcher rd = req.getRequestDispatcher("SearchResult");
		//セッションの継続確認と検索結果のリスト「productList」をセッションオブジェクトに格納
		HttpSession session = req.getSession(false);
		session.setAttribute("productList", sbl);

		//SearchResult.jspを表示
		// 画面遷移処理
		RequestDispatcher rd = req.getRequestDispatcher("SearchResult.jsp");
		rd.forward(req, resp);
	}

	}



