package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_lesson;
import com.sp.entity.Tb_student;
import com.sp.util.DBHelper;

public class Tb_lessonDao {

	public List<Tb_lesson> LessonList(){
		List<Tb_lesson> leslist = new ArrayList<Tb_lesson>();
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("select * from tb_lesson");		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_lesson les = new Tb_lesson();
				les.setId(rs.getInt("id"));
				les.setName(rs.getString("name"));
				les.setJoinTime(rs.getString("joinTime"));
				leslist.add(les);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		
		
		return leslist;
	}
	public List<Tb_lesson> LessonName(){
		List<Tb_lesson> lesName = new ArrayList<Tb_lesson>();
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("select name,id from tb_lesson");		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_lesson les = new Tb_lesson();
				les.setId(rs.getInt("id"));
				les.setName(rs.getString("name"));
				lesName.add(les);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		return lesName;
	}
	public boolean deletelesInfo(String id){
		boolean flag=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBHelper.getConn();  //��ȡ����
			pstmt = conn.prepareStatement("delete from tb_lesson where id=?");
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
