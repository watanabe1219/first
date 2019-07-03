package nkym;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class ItemServlet extends HttpServlet {


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String pro_name = null;
		// listの要素数分ループ
		for(SearchBean search:SearchSurvlet.sbl) {
			// searchリストの name がDB pro_name に存在する時
			if(req.getParameter(search.getName()) != null) {
				pro_name = search.getName();
				break;
			}
		}

		//ItemDaoをインスタンス化
		ItemDao ItD = new ItemDao();

		// session 開始指定しているなら実行
		HttpSession session = req.getSession(false);
		//getItemDbメソッド呼び出し、実行結果をセッションオブジェクトに格納
		session.setAttribute("item",ItD.getItemDb(pro_name));
		//Item.jspに画面遷移
		RequestDispatcher rd = req.getRequestDispatcher("item.jsp");
		rd.forward(req, resp);
	}
}



