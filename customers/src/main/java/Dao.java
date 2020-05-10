import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.techlog.web.model.musteri;

public abstract class Dao {
	
	static Connection con = null;
	static Statement st = null;
	
	Dao() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekniksatistakip","root","Arturo19....?");
		st = con.createStatement();
		}
		catch (Exception e) {
			
		}
	}
	
	void closeConnection() {
		try {
		st.close();
		con.close();
		}
		catch(Exception e) {
			
		}
	}
	
	abstract musteri search();
	
}
