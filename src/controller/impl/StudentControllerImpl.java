package controller.impl;



import controller.StudentController;
import model.dao.StudentDao;
import model.vo.Student;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentControllerImpl implements StudentController{
	public  void WriteTxt(String fileName) throws IOException {
		 List<Student> list=new ArrayList<Student>();
		StudentDao sd=new StudentDao();
		 list = sd.queryallstudent();
		File f=new File(fileName);
		Writer out=null;
		out=new FileWriter(f);
		for(int i=0;i<list.size();i++)
		{
			String str=list.get(i).toString();
			out.write(str+"\r\n");
		}
		out.close();
		
	}
	@SuppressWarnings({ "resource", "unused" })
	@Override
	public List<Student> ReadFromTxt(String fileName) throws IOException {
		List<Student> list1 = new ArrayList<Student>();
		FileInputStream fileInputStream = new FileInputStream(fileName);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"gbk");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		BufferedReader in=new BufferedReader(new FileReader(fileName));
		String info = null;
		while((info=reader.readLine())!=null){
			String[] s = info.split(",");
			Student student = new Student();
			for(int i=1; i<=s.length; i++){
				if(i==1){
               	student.setsId(s[0]);
               }else if(i==2){
               	student.setsName(s[1]);
               }else if(i==3){
               	student.setsSex(s[2]);
               }else if(i==4){
               	student.setsBirthday(s[3]);
               }else if(i==5){
               	student.setsProvince(s[4]);
               }else if(i==6){
               	student.setsHobby(s[5]);
               }else if(i==7) {
               	student.setsPhone(s[6]);
               }
			}
			list1.add(student);
		}
		return list1;
	}
	

	@Override
	public ResultSet queryForCondition(String[] data){
		ResultSet rs = null;
		
		StudentDao studentDao = new StudentDao();
		rs = studentDao.queryForCondition(data);
	
		return rs;
	}
	@Override
	public boolean deleteStudentController(String sid) {
		
		StudentDao dao = new StudentDao();
		boolean flag = dao.deleteStudentInfoForSid(sid);
		
		
		return flag;
	}
}
