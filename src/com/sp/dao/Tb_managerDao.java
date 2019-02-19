package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sp.entity.Tb_manager;
import com.sp.util.DBHelper;

public class Tb_managerDao {
	/**
	 * ��¼����
	 * @param manName
	 * @param pwd
	 * @return
	 */
	public Tb_manager Login(String manName,String pwd){
		Tb_manager manager = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn=DBHelper.getConn(); //��ȡ�����Դ
			pstmt = conn.prepareStatement("select * from tb_manager where manName=? and pwd=?");
			//���ò���
			pstmt.setString(1, manName);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();//ִ�в�ѯ
			if(rs.next()){
				manager = new Tb_manager();
				manager.setId(rs.getInt("id"));
				manager.setManName(rs.getString("manName"));
				manager.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeConn(rs, pstmt, conn);//�ر������Դ
		}
		
		return manager;
			
	}
	public List<Tb_manager> ManagerList(){
		List<Tb_manager> mlist = new ArrayList<Tb_manager>();
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("select * from tb_manager");			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Tb_manager man = new Tb_manager();
				man.setId(rs.getInt("id"));
				man.setManName(rs.getString("manName"));
				mlist.add(man);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		
		
		return mlist;
	}
	@SuppressWarnings("null")
	public Tb_manager getManForId(int id){
		Tb_manager man = null;
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("select * from tb_manager where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				man=new Tb_manager();
				man.setId(rs.getInt("id"));
				man.setManName(rs.getString("manName"));
				man.setPwd(rs.getString("pwd"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		return man;
	}
	public boolean updateMan(int id,String manName,String pwd){
		boolean flag = false;
		Connection conn = null;  //��ȡ���Ӷ���
		PreparedStatement pstmt = null;
		try{
			conn = DBHelper.getConn();//��ȡ���Ӷ���
			pstmt = conn.prepareStatement("update tb_manager set manName=?,pwd=? where id=?");
			//���ò�����ֵ
			pstmt.setString(1, manName);//��1������ֵ
			pstmt.setString(2, pwd);
			pstmt.setInt(3,id);  //��3��?�ŵ�ֵ
			int n = pstmt.executeUpdate();
			if(n>0){
				flag = true;
			}
		}catch(Exception ex){
			
		}
		finally{
			DBHelper.closeConn(null, pstmt, conn); //�ر���Դ
		}
		return flag;
	}
}
