package com.sp.util;

import java.security.NoSuchAlgorithmException;

public class Test {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		/*����md5Util�����Ƿ���ȷ*/
		Md5Util mu=new Md5Util();
		String newPwd =mu.getMd5("666666");
		System.out.println(newPwd);
	}

}
