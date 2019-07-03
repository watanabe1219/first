package nkym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDao {
	private final String url = "jdbc:mysql://localhost/lesson20xx";
	private final String id1 = "root";
	private final String pw = "password";

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	//getItemメソッドで引数pro_nameを取得
	public ItemBean getItemDb(String pro_name){

		ItemBean item = new ItemBean();

		try {
			// JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			//MySQLへ接続
			conn = DriverManager.getConnection(url,id1,pw);
			st = conn.createStatement();
			// SQL文の発行
			//productテーブルとcategoryテーブルの「cat.id」を基準にinnner join
			//メソッドの引数とデータベースの商品名が適合した
			//場合に商品名、カテゴリー名、価格、在庫、紹介文、画像の情報を変数splに格納
			String sql = "select product.pro_name,category.cat_name,product.pro_price,product.stock_no,product.pro_msg,product.pro_img "
					+ "from category inner join product "
					+ "on category.cat_id = product.cat_id "
					+ "where product.pro_name = '" + pro_name  + "'";
			rs = st.executeQuery(sql);

			// rs.next()の値が存在する間ループ
			// rs.next():tableのカーソルを現在の位置から1行下に移動
			while (rs.next()) {
				// itemクラスに設定
				// rs.getString():column の値をString型で取得
				item.setName(rs.getString("pro_name"));
				item.setCategory(rs.getString("cat_name"));
				// rs.getInt():column の値をint型で取得
				item.setPrice(rs.getInt("pro_price"));
				item.setStock(rs.getInt("stock_no"));
				item.setMsg(rs.getString("pro_msg"));
				item.setImg(rs.getString("pro_img"));
			}
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				// 解放処理
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			}catch(Exception ex) {}
		}
		//取得した情報を変数itemに格納
		return item;




	}

}
