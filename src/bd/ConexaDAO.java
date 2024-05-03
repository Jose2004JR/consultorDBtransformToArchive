package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bd.exception.DBException;

public class ConexaDAO {
	private static Connection conn = null;

	public static Connection connct() {
		try {
			if (conn == null) {
				String url = "jdbc:mysql://localhost:3306/coursejbdc?user=root&password=1234";
				conn = DriverManager.getConnection(url);
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		return conn;
	}

	public static void closeBD() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
	}
}
