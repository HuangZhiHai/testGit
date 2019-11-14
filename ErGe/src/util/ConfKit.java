package util;




import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

/**
 * 
 * <dl>
 *  <dd>绫�/鎺ュ彛鎻忚堪锛氶厤缃枃浠跺伐鍏�
 *	<dd>	
 * <dl>
 * @author 鏉庡穽
 * @2014-12-9 涓嬪崍09:20:07
 *
 */
public class ConfKit {

	private static Properties props = new Properties();
	static {
		try {
			             InputStream in = new BufferedInputStream (new FileInputStream("../util/wechat.properties"));
			             props.load(in);     ///加载属性列表
			             Iterator<String> it=props.stringPropertyNames().iterator();
			             while(it.hasNext()){
			                 String key=it.next();
			                 System.out.println(key+":"+props.getProperty(key));
			             }
			             in.close();
//			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("wechat.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return props.getProperty(key);
	}

    public static void setProps(Properties p){
        props = p;
    }
}
