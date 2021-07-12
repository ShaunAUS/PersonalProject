package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class blogDAO {
	
	
	
	Connection conn=null;

	public Connection getConnection() {
			

		try {
			
			
			//user name = mysql 접속할떄 쓰는거아닌가?
			//왜 나비켓은 root로 ?
			//user name =shaun 인데 왜 root로 해야 접속돼나
			// xammpp    vs   직접깐 mysql
            Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","951753");
		
            
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		
		return conn;
	}
	

	//커넥션 close
	public void close(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	//statement close
	public void close(Statement stmt) {
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//resultSet close
	public void close(ResultSet rset) {
		if(rset != null){
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
}
