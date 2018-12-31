package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



/*
 * 该类实现JDBC的封装，主要实现代码的重用
 * 核心是类的抽象过程（成员变量，成员方法），
 * 数据库的访问步骤：
 * （1）加载驱动，建立连接，创建语句对象（封装在构造方法中）
 * （2）对于insert，delete，update之类的操作，返回受影响的记录条数
 * 若>0，则表示操作成功，否则表示操作失败，需要实现一个方法
 * （3）对于select的操作，返回的是查询到的记录集，需要实现一个方法
 * （4）对数据库连接对象的关闭，以释放资源，如果资源不及时的释放，系统将会出现
 * “out of memory”的错误，导致系统奔溃
 *
 */
public class DBManager {
	//成员的成员变量
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	private String dirverName;
	private String url;
	private String username;
	private String password;

	//以下为封装的成员方法
	/*
	 * 1.构造方法，实现加载驱动，建立连接，创建语句对象
	 */
	public DBManager(){
		Properties pro = new Properties();
		try {
			FileInputStream in = new FileInputStream("G:\\eclipse1Workplace\\Practice\\src\\resources\\config.properties");
			pro.load(in);
			dirverName = pro.getProperty("driverName");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			Class.forName(dirverName);


			con = DriverManager.getConnection(url, username, password);

			//3.创建语句对象
			stm = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 2.对于insert，delete，update之类的操作,对于异常的出来，可以采取两种方式
	 * （1）使用try，catch
	 * （2)直接抛出，使用thows，即交给调用者进行处理
	 */
	public boolean executeUpdate(String sql) throws SQLException{
		boolean ret=false;
		int i=stm.executeUpdate(sql);
		if(i>0){
			ret=true;
		}

		return ret;
	}

	/*
	 * 3.对于select的操作
	 */

	public ResultSet executeQuery(String sql) throws SQLException{
		rs=stm.executeQuery(sql);
		return rs;
	}


	/*
	 * 4.资源的释放
	 */

	public void close(){
		try {
			if (rs != null) {

				rs.close();

			}

			if (stm != null) {
				stm.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





}