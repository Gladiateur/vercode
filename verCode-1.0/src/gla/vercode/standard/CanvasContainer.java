/*
 * @(#)CanvanContainer.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * This interface defines the specification of the canvas.
 */

package gla.vercode.standard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 * 定义画布规则的容器。
 * <p>
 * 想要成为一个画布，就要实现这个接口。该接口定义了画布的规范。对于一般的画布，
 * 只需继承<span>Canvas</span>即可。
 * </p>
 * 
 * @author Gladiateur
 * @see gla.vercode.canvas.Canvas
 * @version 1.0 2017-8-3
 */
public interface CanvasContainer extends CommonData{
	
	/**
	 * 创建画布。
	 * <p>
	 * 在生成验证码之前需要创建画布。通过设置画布的宽高，背景色和边框颜色来创建。
	 * </p>
	 * 
	 * @param width
	 * @param height
	 * @param background
	 * @param border
	 * @return Image
	 */
	public Image createCanvans(int width,int height,Color background,Color border);
	
	/**
	 * 返回验证码的值。
	 * <p>
	 * 通过设置字体样式和字符个数创建验证码，并且返回它的值。
	 * </p>
	 * 
	 * @param font
	 * @param number
	 * @return Stirng
	 */
	public String createVerification(Font font,int number);
	
	/**
	 * 向画布画干扰直线。
	 * <p>
	 * 设置条数，然后在画布范围内随机生成干扰直线。
	 * </p>
	 * 
	 * @param number
	 */
	public void  drawLines(int number);
	
	/**
	 * 向画布画干扰弧线。
	 * <p>
	 * 设置条数，然后在画布范围内随机生成干扰弧线。
	 * </p>
	 * 
	 * @param number
	 */
	public void drawArc(int number);
	
	/**
	 * 向画布画噪点。
	 * <p>
	 * 设置点数，然后在画布范围内随机声生成噪点。
	 * </p>
	 * 
	 * @param number
	 */
	public void drawPoints(int number);
	
	/**
	 * 向画布画干扰字符。
	 * <p>
	 * 设置字符，然后在画布范围内随机生成该字符。
	 * </p>
	 * 
	 * @param str
	 * @param font
	 * @param number
	 */
	public void drawString(String str,Font font , int number);
	
}
