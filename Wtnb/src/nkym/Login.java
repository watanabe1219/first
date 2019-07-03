package nkym;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");


		String id = req.getParameter("name");
		String pass = req.getParameter("pass");
		PrintWriter out = resp.getWriter();
		//入力されたidとpassの文字列を変数に代入
		int id_num = id.length();
		int pass_num = pass.length();

		//セッション開始（セッションオブジェクトあり）
		HttpSession session = req.getSession(true);
		//HttpSessionへのデータの格納
		session.setAttribute(id,pass);
		//JDBCインスタンス化
			UserDB D =new UserDB();

		//UserDBクラスのloginメソッドを呼び出し引数に引数idとpassを代入
		D.login(id,pass);

			out.println("<html>");
			out.println("<head><title>ログイン</title></head>");
			out.println("<body>");

		if(D.flg==true) {
		//if文にてuserDBから戻ってきたflgの結果がtrueであればSearch.jspに遷移
			if(D.flg==true) {
				RequestDispatcher rd = req.getRequestDispatcher("Search.jsp");

				rd.forward(req,resp);
				}
		//間違っていた場合
		}else{
		//未入力の場合の処理
			if((id_num == 0)||(pass_num == 0)) {
			out.println("<p>名前またはパスワードを入力してください</p>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			}
		//入力内容が間違っていた場合の処理
			out.println("<p>名前またはパスワードが一致しません</p>");
			out.println("</body>");
			out.println("</html>");
			out.close();

		}


	}
}



