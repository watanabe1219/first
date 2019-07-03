package nkym;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//テキストデータの使用の宣言
				resp.setContentType("text/html;charset=UTF-8");
				String THANKS = req.getParameter("thanks");	// name="thanks" 取得
		        String URL = null;
//Thanks.jspのformから受け取ったパラメータの内容でページ遷移
		        switch(THANKS) {
				case "Logout":
					// session 開始指定しているなら実行
					HttpSession session = req.getSession(false);
			        if (session != null) {
			        	// sessionを終了してlogin.jspに遷移
			        	session.invalidate();
			        }
			        URL = "Login.jsp";
			        break;
			 //Search.jspへ遷移
				case "Continue Shopping":
					URL = "Search.jsp";
					break;
			    }

		     // 画面遷移処理
				RequestDispatcher rd = req.getRequestDispatcher(URL);
				rd.forward(req, resp);
	}
}
