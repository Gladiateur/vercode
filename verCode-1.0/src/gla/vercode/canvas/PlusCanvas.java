/*
 * @(#)PlusCanvans.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * The addition of the verification code.
 */

package gla.vercode.canvas;

import java.awt.Font;

import gla.vercode.util.StringUtils;

/**
 * 做合验证码
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-5
 */
public class PlusCanvas extends Canvas {
	
	public final static int PLUSNUMBER_MAX = 80;
	
	@Override
	public String createVerification(Font font, int number) {
		String code = "";
		int result = 0 ;				//做合的累加器初始化为0
		for(int i = 0;i < number ; i++){
			int count = random.nextInt(PLUSNUMBER_MAX);	//加数最大值限定
			result += count;
			code += (Integer.toString(count)+"+");
		}
		code = StringUtils.subString(code);
		System.out.println(result);
		drawString(0, font, code,28,15);
		return Integer.toString(result); 
	}
}
