package com.sp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsDateUtil {
	/**
	 * �÷������ڷ��ظ�ʽ�����ϵͳ��ǰʱ��
	 * @return
	 */
	public static String getNewSimpleDate(){
		Calendar ca=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s =  sdf.format(ca.getTime());  //��ø�ʽ���������ʱ��
		return s;
	}
}
