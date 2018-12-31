package model.vo;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String sId;
	private String sName;
	private String sSex;
	private String sBirthday;
	private String sProvince;
	private String sHobby;
	private String sPhone;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(String sId, String sName, String sSex, String sBirthday,
			String sProvince, String sHobby, String sPhone) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sSex = sSex;
		this.sBirthday = sBirthday;
		this.sProvince = sProvince;
		this.sHobby = sHobby;
		this.sPhone = sPhone;
	}



	public String getsId() {
		return sId;
	}



	public void setsId(String sId) {
		this.sId = sId;
	}



	public String getsName() {
		return sName;
	}



	public void setsName(String sName) {
		this.sName = sName;
	}



	public String getsSex() {
		return sSex;
	}



	public void setsSex(String sSex) {
		this.sSex = sSex;
	}



	public String getsBirthday() {
		return sBirthday;
	}



	public void setsBirthday(String sBirthday) {
		this.sBirthday = sBirthday;
	}



	public String getsProvince() {
		return sProvince;
	}



	public void setsProvince(String sProvince) {
		this.sProvince = sProvince;
	}



	public String getsHobby() {
		return sHobby;
	}



	public void setsHobby(String sHobby) {
		this.sHobby = sHobby;
	}



	public String getsPhone() {
		return sPhone;
	}



	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}



	public static List<Student> getStudents() {
		return students;
	}



	public static void setStudents(List<Student> students) {
		Student.students = students;
	}



	public static List<Student> students=new ArrayList<Student>();
	
	public String toString() {
		return "学号:"+ sId+"\t" 
				+"姓名:"+ sName+"\t"
				+"性别:"+ sSex+"\t"
				+"生日:"+ sBirthday+"\t"
				+"省份:"+ sProvince+"\t"
				+"爱好:"+ sHobby+"\t" 
				+"电话:"+ sPhone;
	} 
}
