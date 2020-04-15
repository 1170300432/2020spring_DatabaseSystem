package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connect {
	
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/database_lab1?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    private String user;
    private String pswd;

    public Connect(String user, String pswd) {
    	this.user = user;
    	this.pswd = pswd;
    }
    
    public List<String> query(String sql) throws ClassNotFoundException, SQLException {
    	List<String> result = new ArrayList<String>();
    	ResultSet rs = null;
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection(DB_URL, user, pswd);
    	Statement stmt = conn.createStatement();
    	rs = stmt.executeQuery(sql);
    	int length = rs.getMetaData().getColumnCount();
    	while(true){
    		boolean flag = rs.next();
    		String string = new String();
    		if(flag) {
    			for (int i = 1; i <= length; i++) {
    				if(i != length) {
    					string += rs.getString(i) + "\t";						
    				} else {
    					string += rs.getString(i);
    				}
				}
    			result.add(string);
    		} else {
    			break;
    		}
    	}
    	rs.close();
    	stmt.close();
    	conn.close();
    	return result;
    }
    
    public void insertAndDelete(String sql) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, user, pswd);
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		stmt.close();
		conn.close();
    }
    
}