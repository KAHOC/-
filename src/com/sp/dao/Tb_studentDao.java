package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_manager;
import com.sp.entity.Tb_student;
import com.sp.util.DBHelper;

public class Tb_studentDao {

	public List<Tb_student> StudentList(){
		List<Tb_student> slist = new ArrayList<Tb_student>();
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("select * from tb_student");		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_student stu = new Tb_student();
				stu.setId(rs.getString("id"));
				stu.setAnswer(rs.getString("answer"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setJoinTime(rs.getString("joinTime"));
				stu.setProferrsion(rs.getString("proferrsion"));
				stu.setQuestion(rs.getString("question"));
				stu.setCardNo(rs.getString("cardNo"));
				slist.add(stu);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		
		
		return slist;
	}
	public boolean deleteStuInfo(String id){
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBHelper.getConn();  //��ȡ����
			pstmt = conn.prepareStatement("delete from tb_student where id=?");
			//���ò���
			pstmt.setString(1, id);			
			//��ʼִ��
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(null, pstmt, conn); // �ر���Դ
		}
		
		
		return flag;
	}
	
}
