package me.quantumti.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 * @author july
 *
 */
public class ExceptionUtil {

	public static String returnException(Exception e){
		String remark="";
		if(e!=null){
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			remark = sw.toString();
		}
		return remark;
	}
	
}
