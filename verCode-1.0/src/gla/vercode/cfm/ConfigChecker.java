/*
 * @(#)ConfigChecker.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Checker.
 */

package gla.vercode.cfm;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import gla.vercode.exception.CheckFailedException;
import gla.vercode.standard.Config;

/**
 * 配置数据检查器。
 * <p>
 * 该类定义了资源文件中的各个键。用于描述验证码的类型。画布的宽高，背景色，边框色等等。
 * 实现接口的意义在于从资源文件中获取配置的Map集合。
 * </p>
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-2
 */
public final class ConfigChecker implements Config {
	
	/**	验证码类型：MODE:默认为1 */
	public final static String MODE;
	
	/**	画布的宽：WIDTH	*/
	public final static String WIDTH;
	
	/**	画布的高：HEIGHT	*/
	public final static String HEIGHT;
	
	/**	画布矩形背景色：BACKGROUND_COLOR,默认白色	*/
	public final static String BACKGROUND_COLOR;
	
	/**	画布矩形边框颜色：BORDER_COLOR默认白色 */
	public final static String BORDER_COLOR;
	
	/**	字符个数	:FONT_NUMBER*/
	public final static String FONT_NUMBER;
	
	/**	干扰直线个数：LINE_NUMBER */
	public final static String LINE_NUMBER;
	
	/**	噪点个数：POINT_NUMBER */
	public final static String POINT_NUMBER;
	
	/**	干扰弧线个数：ARC_NUMBER */
	public final static String ARC_NUMBER;
	
	/**	字体:FONT_STYLE */
	public final static String FONT_STYLE;
	
	/**	验证码变量名：VERIFICATION_NAME:默认vercode*/
	public final static String VERIFICATION_NAME;
	
	/**	输出格式	: FORMAT: 默认jpg */
	public final static String FORMAT;
	
	private static Map<String, String> configMap = new HashMap<String, String>();
	
	static{
		//
		MODE=ResourceBundle.getBundle("v-config").getString("MODE"); 
		
		//
		WIDTH=ResourceBundle.getBundle("v-config").getString("WIDTH"); 
		HEIGHT=ResourceBundle.getBundle("v-config").getString("HEIGHT"); 
		
		//
		BACKGROUND_COLOR=ResourceBundle.getBundle("v-config").getString("BACKGROUND_COLOR"); 
		BORDER_COLOR=ResourceBundle.getBundle("v-config").getString("BORDER_COLOR"); 
		
		//
		FONT_NUMBER=ResourceBundle.getBundle("v-config").getString("FONT_NUMBER"); 
		LINE_NUMBER=ResourceBundle.getBundle("v-config").getString("LINE_NUMBER");
		POINT_NUMBER=ResourceBundle.getBundle("v-config").getString("POINT_NUMBER");
		ARC_NUMBER=ResourceBundle.getBundle("v-config").getString("ARC_NUMBER");
		
		//
		FONT_STYLE=ResourceBundle.getBundle("v-config").getString("FONT_STYLE");
		VERIFICATION_NAME=ResourceBundle.getBundle("v-config").getString("VERIFICATION_NAME");
		FORMAT=ResourceBundle.getBundle("v-config").getString("FORMAT");
	}
	
	/**
	 * 初始化检查器时判断配置文件中的部分参数是否合法。
	 */
	public ConfigChecker(){
		int width = Integer.parseInt(WIDTH);
		if(width < 50 || width > 500){
			throw new CheckFailedException("WIDTH:"+WIDTH+" 值不在范围内！");
		}
		int height = Integer.parseInt(HEIGHT);
		if(height < 15 || height > 200){
			throw new CheckFailedException("HEIGHT:"+HEIGHT+" 值不在范围内！");
		}
		int fontNumber = Integer.parseInt(FONT_NUMBER);
		if(fontNumber < 1 || fontNumber > 5){
			throw new CheckFailedException("FONT_NUMBER :"+FONT_NUMBER+" 值不在范围内！");
		}
		int lineNumber = Integer.parseInt(LINE_NUMBER);
		if(lineNumber < 0 || lineNumber > 50){
			throw new CheckFailedException("LINE_NUMBER :"+LINE_NUMBER+" 值不在范围内！");
		}
		int pointNumber = Integer.parseInt(POINT_NUMBER);
		if(pointNumber < 0 || pointNumber > 256){
			throw new CheckFailedException("POINT_NUMBER :"+POINT_NUMBER+" 值不在范围内！");
		}
		int arcNumber = Integer.parseInt(ARC_NUMBER);
		if(arcNumber < 0 || arcNumber > 50){
			throw new CheckFailedException("ARC_NUMBER :"+ARC_NUMBER+" 值不在范围内！");
		}
	}
	
	/**
	 * 获取资源配置文件的Map集合。
	 */
	public final Map<String,String> getConfigMap(){
		//自动迭代??
		configMap.put("MODE", MODE);
		configMap.put("WIDTH", WIDTH);
		configMap.put("HEIGHT", HEIGHT);
		configMap.put("BACKGROUND_COLOR", BACKGROUND_COLOR);
		configMap.put("BORDER_COLOR", BORDER_COLOR);
		
		configMap.put("FONT_NUMBER", FONT_NUMBER);
		configMap.put("LINE_NUMBER", LINE_NUMBER);
		configMap.put("POINT_NUMBER", POINT_NUMBER);
		configMap.put("ARC_NUMBER", ARC_NUMBER);
		
		configMap.put("FONT_STYLE", FONT_STYLE);
		configMap.put("VERIFICATION_NAME", VERIFICATION_NAME);
		configMap.put("FORMAT", FORMAT);
		return configMap;
	}
}
