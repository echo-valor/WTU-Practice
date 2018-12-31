package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;
import util.MD5Util;
import view.Login;
import model.vo.User;

public class UserDao {

	
	public boolean checkUser(User  user){
		boolean ret=false;
		List<User> list=query(user);
		if(list.size()>0){
			ret=true;
		}
		return ret;
	}
	
	
	public List<User> query(User user){
		List<User> list=new ArrayList<User>();
		
		String sql="select * from user where 1=1 ";
		if(user.getUserName()!=null){
			sql+=" and userName='"+user.getUserName()+"' ";
		}
		if(user.getPassword()!=null){
			sql+=" and password='"+user.getPassword()+"' ";
		}
		
		System.out.println("sqlÓï¾ä£º======>"+sql);
		
		DBManager db=new DBManager();
		ResultSet rs=null;
		try {
			rs=db.executeQuery(sql);
			while(rs.next()){
				User user1=new User();
				user1.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				list.add(user1);				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.close();
		}
		
		return list;
	}
	
	public void modifypassword(String password) throws SQLException {
		String username=Login.yuanname;
		String s=MD5Util.string2MD5(password);
		String sql="update user set password='"+s+"'where userName="+"'"+username+"'";
		DBManager db=new DBManager();
		db.executeUpdate(sql);
		db.close();
		
	}

}
