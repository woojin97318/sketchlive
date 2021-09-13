package common;

import java.sql.Connection;
import java.sql.DriverManager;

// 데이터베이스 연결 클래스
public class DBClass {
	public static Connection conn;

	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.221.253.215:1521:xe", "team05", "0505");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
