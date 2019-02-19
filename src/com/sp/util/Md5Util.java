package com.sp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * �������ڶ��ַ�������MD5����
 * @author Administrator
 *
 */
public class Md5Util {
	
	
	
	/*�õ�ָ���ַ�����MD5���ܺ���ַ���*/
	public String getMd5(String pwd){
		
		
		MessageDigest md=null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//��ȡһ��ָ�������㷨Ϊmd5�� MessageDigest ����
		byte[] pwdBytes = pwd.getBytes(); //��ȡ�����byte[]���������ʽ
		md.update(pwdBytes); //��������
		byte[] newPwdBytes= md.digest();  //����ժҪ		
		
		return byteArrayToHex(newPwdBytes);   //�����ɵ��µ��ֽ�����ת��ΪString���ͷ���
	}
	
	
	/**
	 * ���淽�����ڽ�byte[]����ת��Ϊ�ַ���
	 * @param byteArray
	 * @return
	 */
	public String byteArrayToHex(byte[] byteArray) {
		 
	      // ���ȳ�ʼ��һ���ַ����飬�������ÿ��16�����ַ�
	 
	      char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };	 
	 
	      // newһ���ַ����飬�������������ɽ���ַ����ģ�����һ�£�һ��byte�ǰ�λ�����ƣ�Ҳ����2λʮ�������ַ���2��8�η�����16��2�η�����
	 
	      char[] resultCharArray =new char[byteArray.length * 2];
	 
	 
	      // �����ֽ����飬ͨ��λ���㣨λ����Ч�ʸߣ���ת�����ַ��ŵ��ַ�������ȥ
	 
	      int index = 0;
	 
	      for (byte b : byteArray) {
	 
	         resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
	 
	         resultCharArray[index++] = hexDigits[b& 0xf];
	 
	      }
	 
	      // �ַ�������ϳ��ַ�������	 
	      return new String(resultCharArray);
	}
}
