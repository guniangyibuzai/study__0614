package com.iflytek.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class JDBCUtil {
	//数据源接口
	private static DataSource dataSource;
	
	static{
		//实例化c3p0数据源
		dataSource = new ComboPooledDataSource(); // 加载默认配置参数
//		dataSource = new ComboPooledDataSource("mysql");//加载指定名称named-config的配置参数
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
}
