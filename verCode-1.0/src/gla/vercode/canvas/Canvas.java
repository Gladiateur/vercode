/*
 * @(#)Canvans.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * This abstract class is the root class of all canvas.
 */

package gla.vercode.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import gla.vercode.standard.CanvasContainer;

/**
 * 抽象的画布类。
 * <p>
 * 在生成验证码之前需要先准备一张纸，之后才能把验证码画到这张纸上。
 * 该类就相当于是一张纸，一张只能画验证码的纸。
 * </p>
 * <p>
 * 	变形分为准备和执行。
 * 	抽取扭曲变形的部分单独封装成方法，可以通过参数设置变形的程度，
 * 	这样在使用加法验证码时就可以根据具体的的问题设置参数。
 * </p>
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-2
 */
public abstract class Canvas implements CanvasContainer {
	protected int width;
	protected int height;

	private static final int x = 20;
	private static final int y = 20;

	protected BufferedImage bufferedImage;
	protected Graphics2D graphics;
	protected Random random = new Random();

	/**
	 * 创建一个BufferedImage的对象，将验证码的图像数据存储在该对象中。
	 */
	public BufferedImage createCanvans(int width, int height, Color background,
			Color border) {
		this.width = width;
		this.height = height;
		bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
		graphics.setColor(background);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(border);
		graphics.drawRect(0, 0, width - 1, height - 1);
		return bufferedImage;
	}

	/**
	 * 随机设置画笔颜色。
	 */
	protected void setRandomColor() {
		graphics.setColor(new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255)));
	}

	/**
	 * 继承这个类是具体的画布类，必须实现此方法。用于在创建验证码时调用该方法。
	 */
	public abstract String createVerification(Font font, int number);
	

	/**
	 * 干扰直线
	 */
	public void drawLines(int number) {
		int x1, x2, y1, y2;
		// graphics.setColor(color);
		setRandomColor();
		for (int i = 0; i < number; i++) { // number = 4;
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);
			x2 = random.nextInt(width);
			y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 干扰弧线
	 */
	public void drawArc(int number) {
		int x, y;
		setRandomColor();
		for (int i = 0; i < number; i++) {
			x = random.nextInt(width);
			y = random.nextInt(height);
			graphics.drawOval(x, y, width, height);
		}
	}

	/**
	 * 干扰点(噪点)
	 */
	public void drawPoints(int number) {
		int a, b;
		setRandomColor();
		graphics.setFont(new Font("Default", Font.BOLD, 5));
		for (int i = 0; i < number; i++) {
			a = random.nextInt(width);
			b = random.nextInt(height);
			graphics.drawString(".", a, b);
		}
	}

	/**
	 * 干扰字符串
	 */
	public void drawString(String str, Font font, int number) {
		int a, b;
		// graphics.setColor(color);
		setRandomColor();
		graphics.setFont(font);
		for (int i = 0; i < number; i++) {
			a = random.nextInt(width);
			b = random.nextInt(height);
			graphics.drawString(str, a, b);
		}
	}

	/**
	 * 把字符画到画布上
	 */
	protected void drawChar(int i, Font font, char ch, int limit, int offset) {
		// int x = 20;
		// int y = 20; // 抽取成参数
		// 写字符串
		// int jiaodu = random.nextInt(60) - 30;
		// double hudu = jiaodu * Math.PI / 180;
		// graphics.rotate(hudu, x + (i * 20), y);
		// setRandomColor();
		// // graphics.setFont(new Font("Default",Font.BOLD,20));
		// graphics.setFont(font);
		preDeformation(i, font, limit, offset);
		graphics.drawString("" + ch, x + (i * 20), y);
		executeDeformation(i);
	}

	/**
	 * 把字符串画到画布上
	 * 
	 * @param i
	 * @param font
	 * @param string
	 * @param limit
	 * @param offset
	 */
	protected void drawString(int i, Font font, String string, int limit,
			int offset) {
		// int x = 20;
		// int y = 20; // 抽取成参数
		// 写字符串
		// int jiaodu = random.nextInt(60) - 30;
		// double hudu = jiaodu * Math.PI / 180;
		// graphics.rotate(hudu, x + (i * 20), y);
		// setRandomColor();
		// // graphics.setFont(new Font("Default",Font.BOLD,20));
		// graphics.setFont(font);
		preDeformation(i, font, limit, offset);
		graphics.drawString(string, x + (i * 20), y);
		executeDeformation(i);
	}

	private double hudu;

	/**
	 * 准备变形
	 * 
	 * @param i
	 * @param font
	 * @param limit
	 * @param offset
	 */

	private void preDeformation(int i, Font font, int limit, int offset) {
		int jiaodu = random.nextInt(limit) - offset;
		hudu = jiaodu * Math.PI / 180;
		graphics.rotate(hudu, x + (i * 20), y);
		setRandomColor();
		// graphics.setFont(new Font("Default",Font.BOLD,20));
		graphics.setFont(font);
		// graphics.drawString(string, x + (i * 20), y);
		// graphics.rotate(-hudu, x + (i * 20), y);
	}

	/**
	 * 执行变形
	 */
	private void executeDeformation(int i) {
		graphics.rotate(-hudu, x + (i * 20), y);
	}
}
