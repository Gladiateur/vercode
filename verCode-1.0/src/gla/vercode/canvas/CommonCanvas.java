/*
 * @(#)CommonCanvans.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * General digital alphabet mixed verification code.
 */

package gla.vercode.canvas;

import java.awt.Font;

/**
 * 这个类是一般的有字母和数字组成的验证码。
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-3
 */
public class CommonCanvas extends Canvas{

	@Override
	public String createVerification(Font font, int number) {
		String code = "";
		for (int i = 0; i < number; i++) {	//	number=4
			//随机获取下标
			int index=random.nextInt(DATAPOOL.length());
			//获取指定索引的字符
			char ch=DATAPOOL.charAt(index);
			code+=ch;
			drawChar(i, font, ch,60,30);
		}
		System.out.println(code);
		return code;
	}
}
