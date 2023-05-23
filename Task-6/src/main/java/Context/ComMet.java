	package Context;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class ComMet {
    static Connection connection;
    static DataSource ds;
public  static DataSource dataSource() {
		
		try {			
			Context initContext = new InitialContext();
			ds=(DataSource) initContext.lookup("java:comp/env/jdbc/employee");

		}catch (Exception e) {
			System.out.println("data base error");
			System.out.println(e);
		}
		return ds;
		
	}
    public Connection getConnection() throws SQLException {
        connection=dataSource().getConnection();
        return connection;
    }
}