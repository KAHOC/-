package com.sp.services;

import java.security.NoSuchAlgorithmException;

import com.sp.dao.Tb_managerDao;
import com.sp.entity.Tb_manager;
import com.sp.util.Md5Util;

public class Tb_managerServices {
	/**
	 * ��¼����
	 * @param manName
	 * @param pwd
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public Tb_manager Login(String manName,String pwd) {
		//�ȵ���util���е�MD5Util���������м���
		Md5Util mu = new Md5Util();
		String newPwd = mu.getMd5(pwd);
		//����dao��ķ�����¼
		Tb_managerDao dao = new Tb_managerDao();
		return dao.Login(manName, newPwd);
		
	}
}
