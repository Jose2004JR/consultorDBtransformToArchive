package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import bd.ConexaDAO;

public class Program {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("C:\\Users\\bduhe\\Desktop\\resultBD.txt"))) {

			conn = ConexaDAO.connct();

			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM seller");

			while (rs.next()) {
				bw.write(rs.getString("Name") + ",");
				bw.write(rs.getString("Email") + ",");
				bw.write(rs.getString("BirthDate") + ",");
				bw.write(String.format("%.2f", rs.getDouble("BaseSalary")));
				bw.write("" + rs.getInt("DepartmentId"));
				bw.newLine();
			}
			bw.close();
			System.out.println("SUCESS");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
