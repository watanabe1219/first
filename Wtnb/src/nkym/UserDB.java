package nkym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
	boolean flg =false;
	public boolean login(String id,String pass){

		//JDBCの接続で使う「url,id,pw」を定義それぞれ中身を入れておく
		String url = "jdbc:mysql://localhost/lesson20xx";//urlの中の最後のデータベース名
		String id1 = "root";
		String pw = "password";
	//「connection,statement,resultset」各オブジェクトを変数定義しておく
		Connection cnct = null;
		Statement st =null;
		ResultSet rs = null;

			try {
	//JDBCドライバの登録
				Class.forName("com.mysql.jdbc.Driver");
	//MySQLへ接続(データベースまで)
				cnct = DriverManager.getConnection(url,id1,pw);
				st = cnct.createStatement();
	//SQL文の発行
				rs = st.executeQuery("SELECT * from user");
	//while文にてuserテーブルのレコードをnextメソッドで回していく
				while(rs.next()) {
	//getXXXXメソッドを使い、userテーブル内の「login_cd,login_pw」をそれぞれ変数名
	//「name,pass1」に格納
					String name = rs.getString("login_cd");
					String pass1 = rs.getString("login_pw");
	//loginメソッドの引数id、passとDBから格納した「name、pass1」を比較

						if(id.equals(name)&&pass.equals(pass1)) {
							flg=true;
						}
				}
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch(SQLException ex) {
				ex.printStackTrace();
			} finally {
				try {
		//JDBC接続の解除
				if (rs!=null) rs.close();
				if (st!=null) st.close();
				if (cnct!=null) cnct.close();
				} catch(Exception ex) { }
			}
	//比較し一致した結果は呼び出し元に戻す
			return flg;
	}

}


