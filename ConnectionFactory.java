package cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mercadinho_zeca";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}		
}
