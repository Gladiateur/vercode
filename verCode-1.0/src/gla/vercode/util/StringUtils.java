/*
 * @(#)StringUtils.java	1.0 17/08/02
 *
 * String tool class.
 */

package gla.vercode.util;

/**
 * 处理String的工具类
 * 
 * @author Gladiateur
 * @version 1.0 2017-7-30
 */
public class StringUtils {
	private StringUtils(){}
	
	/**
	 * 去掉末尾点标志之前的所有字符窜的方法，只需要末尾标志后的内容
	 * 比如：domain.Account我只想要Account
	 */
	public static String lastSubStirng(String string ,String lastFlag){
		return string.substring(string.lastIndexOf(lastFlag)+1);
	}
	
	/**
	 * 去掉最后一个字符
	 * 
	 * @param string
	 * @return String
	 */
	public static String subString(String string){
		return string.substring(0, string.length()-1);
	}
	
}
