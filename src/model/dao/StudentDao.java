package model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import controller.impl.StudentControllerImpl;
import model.vo.Student;
import util.DBManager;
import util.ShowMessageUtil;

public class StudentDao {
	public static int progress;
	
	// private final String FILE_PATH="d:\\student.xls";
	


	public static StudentDao getInstance() {
		StudentDao studentDao;
		return  studentDao= new StudentDao();
	}
	
	public ResultSet queryAll() {
		ResultSet rs = null;
		String sql = "select *from Student";
		System.out.println("sql语句======>" + sql);
		DBManager db = new DBManager();
		try {
			rs = db.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}

	public List<Student> queryallstudent() {

		List<Student> list1 = new ArrayList<Student>();
		String sql = "select *from Student";
		System.out.println("sql语句======>" + sql);
		DBManager db = new DBManager();
		ResultSet rs = null;
		try {
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Student student1 = new Student();
				student1.setsId(rs.getString("sId"));
				student1.setsName(rs.getString("sName"));
				student1.setsSex(rs.getString("sSex"));
				student1.setsBirthday(rs.getString("sBirthday"));
				student1.setsProvince(rs.getString("sProvince"));
				student1.setsHobby(rs.getString("sHobby"));
				student1.setsPhone(rs.getString("sPhone"));
				list1.add(student1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			db.close();
		}

		return list1;
	}

	public void WriteExcel(List<Student> list, String filepath) throws IOException {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("学生信息");
		HSSFRow row = sheet.createRow(0);
		String[] s = { "sId", "sName", "sSex", "sBirthday", "sProvince", "sHobby", "sPhone" };
		for (int i = 0; i < 7; i++) {
			row.createCell(i).setCellValue(s[i]);

		}
		for (int j = 0; j < list.size(); j++) {
			HSSFRow r = sheet.createRow(j + 1);
			r.createCell(0).setCellValue(list.get(j).getsId());
			r.createCell(1).setCellValue(list.get(j).getsName());
			r.createCell(2).setCellValue(list.get(j).getsSex());
			r.createCell(3).setCellValue(list.get(j).getsBirthday());
			r.createCell(4).setCellValue(list.get(j).getsProvince());
			r.createCell(5).setCellValue(list.get(j).getsHobby());
			r.createCell(6).setCellValue(list.get(j).getsPhone());

		}
		OutputStream out = new FileOutputStream(filepath);
		workbook.write(out);
		System.out.println("导入成功！");
		out.close();
	}

	public List<Student> ReadFromExcel(String fileName) throws IOException {

		InputStream is = new FileInputStream(fileName);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<Student> list = new ArrayList<Student>();
		int size = hssfWorkbook.getNumberOfSheets();

		for (int numSheet = 0; numSheet < size; numSheet++) {

			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}

			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {

				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				int minColIx = hssfRow.getFirstCellNum();
				int maxColIx = hssfRow.getLastCellNum();
				Student student = new Student();

				int i = 1;
				for (int colIx = minColIx; colIx < maxColIx; colIx++) {

					HSSFCell cell = hssfRow.getCell(colIx);
					if (cell == null) {
						continue;
					}
					if (i == 1) {
						student.setsId(getStringVal(cell));
					} else if (i == 2) {
						student.setsName(getStringVal(cell));
					} else if (i == 3) {
						student.setsSex(getStringVal(cell));
					} else if (i == 4) {
						student.setsBirthday(getStringVal(cell));
					} else if (i == 5) {
						student.setsProvince(getStringVal(cell));
					} else if (i == 6) {
						student.setsHobby(getStringVal(cell));
					} else if (i == 7) {
						student.setsPhone(getStringVal(cell));
					}

					i++;
				}
				list.add(student);
			}

		}
		hssfWorkbook.close();
		return list;
	}

	public void importDB(String fileName) throws IOException, SQLException, InterruptedException {
//		String url = "jdbc:mysql://localhost:3306/student_system?useUnicode=true&characterEncoding=utf-8"; // 鏁版嵁搴撹繛鎺ュ瓧绗︿覆锛屼竴鑸娇鐢ㄧ粺涓�璧勬簮瀹氫綅绗︼紙url锛夌殑褰㈠紡
//
//		String user = "root"; // 杩炴帴鏁版嵁搴撴椂鐨勭敤鎴�
//		String password = "980615"; 
		@SuppressWarnings("unused")
		String sql = "insert into student(sId,sName,sSex,sBirthday,sProvince,sHobby,sPhone) values(?,?,?,?,?,?,?)";
//		QueryRunner qr=new QueryRunner();
//		List<Student> list=ReadFromExcel(fileName);
//		DBManager db=new DBManager();
//		Connection con=(Connection) DriverManager.getConnection(url, user, password);
//		
//		int a=qr.update(con,sql, list);
//		System.out.println(a);
//		db.close();

		boolean a = false;
		int flag = 0;
		List<Student> list1 = null;
		try {
			list1 = this.ReadFromExcel(fileName);
		} catch (Exception e) {
			ShowMessageUtil.winMessage("未找到指定文件！");
		}

		List<Student> list = this.queryallstudent();

		List<Student> listall = new ArrayList<Student>();
		listall.addAll(list);
		listall.addAll(list1);
		progress = 10;
		// Thread.sleep(500);
		// listall=new ArrayList<Student>(new LinkedHashSet<>(listall));
		try {
			for (int i = 0; i < listall.size() - 1; i++) {
				for (int j = listall.size() - 1; j > i; j--) {
					if (listall.get(i).getsId().equals(listall.get(j).getsId())) {
						System.out.println(listall.get(i).getsId());

						System.out.println(listall.get(j).getsId());
						listall.remove(j);
						j--;
						listall.remove(i);
						i--;
					}
				}
			}
		} catch (Exception e) {
			ShowMessageUtil.winMessage("添加信息已存在");
			flag = 1;
		}

		// Thread.sleep(500);
		// progress=20;
		// Thread.sleep(1000);
		// int a1=80/listall.size()+1;
		try {
			Iterator<Student> it = listall.iterator();
			while (it.hasNext()) {
				Student s = new Student();
				s = it.next();
				a = insertstudentinformation(s);
				// progress+=a1;
				// Thread.sleep(500);
			}
			if (flag == 0) {
				ShowMessageUtil.winMessage("导入成功!");
			}

		} catch (Exception e) {
			System.out.println("导入失败!");
		}

	}

	public static String getStringVal(HSSFCell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		case Cell.CELL_TYPE_NUMERIC:
			cell.setCellType(Cell.CELL_TYPE_STRING);
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		default:
			return "";
		}
	}

	public static int getprogress() {
		return progress;
	}

	/*
	 * 该方法实现按各个字段的组合查询，，各个查询参数存放于student对象中， 如student对象某个成员变量为null，则表示组合时忽略该字段,
	 * 由于该方法是被view所调用的，因此经常将查询结果集（ResultSet）转换为集合对象
	 */
	/*
	 * public List<Student> queryallstudent() {
	 * 
	 * 组合查询生成的动态sql语句
	 * 
	 * List<Student> list1 = new ArrayList<Student>(); String sql =
	 * "select * from student  "; System.out.println("sql语句======>" + sql);
	 * DBManager db = new DBManager(); ResultSet rs = null; try { rs =
	 * db.executeQuery(sql); while (rs.next()) { Student student1 = new Student();
	 * student1.setsId(rs.getString("sid"));
	 * student1.setsName(rs.getString("sname"));
	 * student1.setsSex(rs.getString("ssex"));
	 * student1.setsBirthday(rs.getString("sbirthday"));
	 * student1.setsPhone(rs.getString("sprovince"));
	 * student1.setsHobby(rs.getString("shobby"));
	 * student1.setsPhone(rs.getString("sphone")); list1.add(student1); } } catch
	 * (SQLException e) {
	 * 
	 * e.printStackTrace(); } finally { try { if (rs != null) { rs.close(); } }
	 * catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } db.close(); }
	 * 
	 * return list1; }
	 */

	public void insertfromtxt(String fname) throws IOException, SQLException {
		List<Student> list2 = new ArrayList<Student>();
		StudentControllerImpl sc = new StudentControllerImpl();
		list2 = sc.ReadFromTxt(fname);
		int i = 0;
		for (i = 0; i < list2.size(); i++) {
			String sid = list2.get(i).getsId();
			String sname = list2.get(i).getsName();
			String ssex = list2.get(i).getsSex();
			String sbirthday = list2.get(i).getsBirthday();
			String sprovince = list2.get(i).getsProvince();
			String shobby = list2.get(i).getsHobby();
			String sphone = list2.get(i).getsPhone();
			String sql = "insert into student(sid,sname,ssex,sbirthday,sprovince,shobby,sphone) " + "values ('" + sid
					+ "', '" + sname + "', '" + ssex + "', '" + sbirthday + "', '" + sprovince + "', '" + shobby + "','"
					+ sphone + "')";
			DBManager db = new DBManager();
			db.executeUpdate(sql);
			db.close();
		}

	}

	public ResultSet queryForCondition(String[] data) {
		ResultSet rs = null;
		String sql = "select * from student where 1=1";
		int i = 0;
		if (!(data[0].equals(""))) {
			sql += " and sid='" + data[0] + "' ";
		}

		if (!(data[1].equals(""))) {
			sql += " and sname='" + data[1] + "' ";
		}

		if (!(data[2].equals(""))) {
			sql += " and sprovince='" + data[2] + "' ";
		}

		if (!(data[3].equals(""))) {
			sql += " and ssex='" + data[3] + "' ";
		}

		System.out.println("==========>条件查询的sql语句为：" + sql);

		DBManager db = new DBManager();
		try {
			rs = db.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	public boolean insertstudentinformation(Student student) {
		DBManager dbManager = new DBManager();
		String sid = student.getsId();// 通过student对象设置sid的值
		String sname = student.getsName();
		String ssex = student.getsSex();
		String sbirthday = student.getsBirthday();
		String sprovince = student.getsProvince();
		String shobby = student.getsHobby();
		String sphone = student.getsPhone();

		String sql = "insert into student(sid,sname,ssex,sbirthday,sprovince,shobby,sphone)" + "values('" + sid + "','"
				+ sname + "','" + ssex + "','" + sbirthday + "','" + sprovince + "','" + shobby + "','" + sphone + "')";
		// 向数据库插入数据语句
		boolean flag = false;// 定义一个boolean型变量，用于判断插入数据是否成功
		try {
			flag = dbManager.executeUpdate(sql);// 更新数据库信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbManager.close();
		return flag;

	}

	public int queryForsidinformation(String sid) {

		DBManager dbManager = new DBManager();
		String sql = "select * from student where sid=" + sid;// 通过sid查询数据库中是否有相同sid数据
		// System.out.println(sql);
		ResultSet rs = null;
		int count = 0;
		try {
			rs = (ResultSet) dbManager.executeQuery(sql);// 更新数据库保存到结果集里
			if (rs.next()) {// 找到相同的count++
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbManager.close();// 关闭数据库连接
		return count;// 返回count
	}

	public boolean updatestudentinformation(Student student) {
		DBManager dbManager = new DBManager();
		// String sid, String sname, String ssex, String sbirthday, String
		// sprovince, String hobby, String sphone
		String sql = "update student set sname=" + "'" + student.getsName() + "'" + " ," + " ssex=" + "'"
				+ student.getsSex() + "'" + " , " + " sbirthday=" + "'" + student.getsBirthday() + "' " + ","
				+ " sprovince=" + "'" + student.getsProvince() + "'" + " ," + " shobby=" + "'" + student.getsHobby()
				+ "'" + " ," + " sphone=" + "'" + student.getsPhone() + "'" + " where" + " sid=" + "'"
				+ student.getsId() + "'";// 通过sid查询数据库中是否有相同sid数据
		System.out.println("=========>更新的语句为：" + sql);
		boolean flag = false;
		try {
			flag = dbManager.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteStudentInfoForSid(String sid) {
		boolean flag = false;
		String sql = "delete from student where sid=" + "'" + sid + "'";
		DBManager dbManager = new DBManager();
		try {
			flag = dbManager.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
