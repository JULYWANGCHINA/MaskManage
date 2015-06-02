package me.quantumti.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
/**
 * 
 * <p>Title: PropertiesUtils</p>
 * <p>Description: Properties Util</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: http://www.ghtech.com.cn/</p>
 * @author WangTian <mailto:skyina7x@gmail.com>
 * @date 2013年9月15日
 * @version 1.0
 */
public class PropertiesUtils {

	static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	//配置文件目录
	public static final String FILE_CONFIG = "/config/config.properties",
							   FILE_JDBC = "/config/mysql.properties";
	
	//属性信息
	private static final String KEY_DATABASE_DIALECT_ = "dialect";
	
	private static String VALUE_DIALECT;
	
	public static String getDialect(){
		if(StringUtils.isEmpty(VALUE_DIALECT))
			VALUE_DIALECT = PropertiesUtils.readConfig(PropertiesUtils.FILE_CONFIG, KEY_DATABASE_DIALECT_).toLowerCase();
		return VALUE_DIALECT;
	}
	
	static public String readConfig(String file,String key) {
		String value = "";
		File resourceFile = new File(PropertiesUtils.class.getResource(
				file).getPath());
		try {
			Properties properties = readConfig(resourceFile);
			value = properties.getProperty(key);
		} catch (Exception e) {
			logger.error("readConfig error,", e);
		}
		return value;
	}
	
	/**
	 * 读取Properties配置
	 * 
	 * @param config
	 * @return
	 * @throws IOException
	 */
	static public Properties readConfig(File config) throws IOException {
		Properties props = new Properties();
         InputStream in = new BufferedInputStream (new FileInputStream(config));
         props.load(in);
         return props;
	}

	/**
	 * 更新指定的Properties文件中的某几个参数的值,
	 * 
	 * @param config
	 * @param attributes
	 * @throws IOException
	 */
	static public void updateConfig(File config, Map<String, String> attributes)
			throws IOException {
		Properties props = new Properties();
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(config);
			props.load(is);
			is.close();
			is = null;

			for (Map.Entry<String, String> entry : attributes.entrySet()) {
				props.put(entry.getKey(), entry.getValue());
			}
			os = new FileOutputStream(config);
			props.store(os, new Date().toString());
			os.flush();
			os.close();
			os = null;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (Exception e) {
				}
			;
			if (os != null)
				try {
					os.close();
				} catch (Exception e) {
				}
			;
		}
	}

	/**
	 * 更新properties配置文件中某个参数的值
	 * 
	 * @param config
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	static public void updateConfig(File config, String key, String value)
			throws IOException {
		HashMap<String, String> attributes = new HashMap<String, String>(1);
		attributes.put(key, value);
		updateConfig(config, attributes);
	}
}
