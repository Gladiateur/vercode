/*
 * @(#)VerificationCode.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Class library core class.
 */

package gla.vercode;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gla.vercode.canvas.PlusCanvas;
import gla.vercode.cfm.CanvasMapping;
import gla.vercode.cfm.ConfigChecker;
import gla.vercode.standard.CanvasContainer;
import gla.vercode.standard.ColorMap;
import gla.vercode.standard.Config;

/**
 * 该类为验证码。 由该类创建验证码并输出到浏览器。
 * 
 * @author Gladiateur
 * @version 1.0 2017-9-1
 */
public final class VerificationCode /* implements Verification */{
	private static Map<String, String> configMap = new ConfigChecker()
			.getConfigMap();
	private static Map<String, String> xmlMap = new CanvasMapping()
			.getConfigMap();
	private static CanvasContainer canvas = mode(ConfigChecker.MODE);
	private static int fontSize = canvas instanceof PlusCanvas ? 16 : 20;

	static {
		// 从检查器中获取参数(检查器：从配置文件中获取参数，并检查合法性)
		Config cc = new ConfigChecker();
		configMap = cc.getConfigMap();
	}

	private static Color setColor(String color) {
		return ColorMap.getColor(configMap.get(color));
	}

	// private CanvasContainer mode(String mode) {
	// if ("1".equals(mode)) {
	//			
	// return new CommonCanvas();
	// } else if ("2".equals(mode)) {
	// return new GBCharacterCanvas();
	// } else if ("3".equals(mode)) {
	// return new MixedCanvas();
	// } else if ("4".equals(mode)) {
	// return new PlusCanvas();
	// }
	// return null;
	// }

	/*
	 * 根据全类名反射出该类的对象。
	 */
	private static Object newInstance(String className) {
		Class<?> clazz = null;
		Object obj = null;
		try {
			clazz = Class.forName(className);
			obj = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;

	}

	/*
	 * mode方法应该是这样的：public CanvasContainer mode(Stringmode)
	 * 根据mode(其实是Map集合中的Key),通过get方法得到Map集合的value，这个value其实就是全类名，
	 * 之后，再根据全类名，反射实例化相应的对象。
	 */
	private static CanvasContainer mode(String mode) {
		String className = xmlMap.get(mode);
		return (CanvasContainer) newInstance(className);
	}

	/**
	 * 向浏览器输出验证码图片
	 * <p>
	 * 1. 通过创建画布对象，设置宽高，设置背景色，设置边框颜色 2. 通过画布创建画笔对象 3.
	 * 通过画笔对象创建字符对象，设置字体颜色，字体样式，字体大小(需验证) 4. 通过画笔对象创建干扰线，设置干扰线颜色 5.
	 * 将画布以XXX格式写入ImageIO.
	 * </p>
	 *
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public final void write(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int width = Integer.parseInt(ConfigChecker.WIDTH);
		int height = Integer.parseInt(ConfigChecker.HEIGHT);
		int fontNumber = Integer.parseInt(ConfigChecker.FONT_NUMBER);
		int lineNumber = Integer.parseInt(ConfigChecker.LINE_NUMBER);
		int pointNumber = Integer.parseInt(ConfigChecker.POINT_NUMBER);
		int arcNumber = Integer.parseInt(ConfigChecker.ARC_NUMBER);
		BufferedImage bufferedImage = (BufferedImage) canvas.createCanvans(
				width, height, setColor("BACKGROUND_COLOR"),
				setColor("BORDER_COLOR"));
		String result = canvas.createVerification(new Font(
				ConfigChecker.FONT_STYLE, Font.BOLD, fontSize), fontNumber);
		canvas.drawLines(lineNumber);
		canvas.drawPoints(pointNumber);
		canvas.drawArc(arcNumber);
		HttpSession session = request.getSession();
		if(session != null){
			session.setAttribute(ConfigChecker.VERIFICATION_NAME, result);
		}else{
			throw new NullPointerException("session is null");
		}
		ImageIO.write(bufferedImage, ConfigChecker.FORMAT, response
				.getOutputStream());
	}
	
	/**
	 * 字符串与验证吗对比的方法
	 */
	public static boolean check(String str, String vercode) {
		return str.equalsIgnoreCase(vercode);
	}
}
