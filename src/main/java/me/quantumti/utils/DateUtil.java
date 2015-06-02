package me.quantumti.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 日期工具类
 * 
 * @author july
 *
 */
public class DateUtil {
	
	/**
	 * 比较两个时间大小
	 * @param fDateStr
	 * @param oDate
	 * @return true: 晚于 false:早于
	 */
	public static boolean isafterDate(String fDateStr, Date oDate) {
		if(StringUtils.isEmpty(fDateStr)||oDate==null)
			return false;
		Date fDate = DateUtil.returnDate(fDateStr);
		return fDate.after(oDate);
	}
	
	/**
	 * 获取两个日期相差天数
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int getIntervalDays(Date fDate, Date oDate) {
		if (null == fDate || null == oDate) {
			return -1;
		}
		long intervalMilli = oDate.getTime() - fDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}
	
	public static String returnString(Date date){
		if(date==null)
			return "";
		 DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");          
		 return format.format(date);
	}
	
	public static Date returnDate(String dateStr){
		Date date = null;
		if(StringUtils.isEmpty(dateStr))
			return date;
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(DateUtil.returnDate("2014-1-2"));
		
//		 DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");           
//         String date = "2015-04-1 12:22:30";  
//		int temp = DateUtil.getIntervalDays(format.parse(date), new Date());
//		System.out.println(temp);
//		System.out.println(format.parse("2014-1-2 17:22:22"));
	}
}
