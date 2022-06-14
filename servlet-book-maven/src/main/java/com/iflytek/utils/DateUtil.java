package com.iflytek.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private final static String defaultFormat = "yyyy-MM-dd"; // 默认模式，可以修改为最常用的

	/**
	 * 日期对象格式化为字符串
	 * 
	 * @param date
	 *            日期对象
	 * @return 返回默认格式化后的字符串
	 */
	public static String date2String(Date date) {
		return date2String(date, defaultFormat);
	}

	/**
	 * 日期对象格式化为字符串
	 * 
	 * @param date
	 *            日期对象
	 * @param format
	 *            指定格式化的模式
	 * @return 返回指定格式化后的字符串
	 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 日期字符串解析为日期对象
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return 返回按照默认格式解析后的日期对象
	 */
	public static Date string2Date(String strDate) {
		return string2Date(strDate, defaultFormat);
	}

	/**
	 * 日期字符串解析为日期对象
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param format
	 *            指定日期字符串的解析格式
	 * @return 返回按照指定格式解析后的日期对象
	 */
	public static Date string2Date(String strDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("日期解析错误", e);
		}
	}
}
