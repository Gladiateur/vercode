/*
 * @(#)GBCharacterCanvans.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Chinese character verification code.
 */

package gla.vercode.canvas;

import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * 该类是中文验证码
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-3
 */
public class GBCharacterCanvas extends Canvas{

	@Override
	public String createVerification(Font font, int number) {
		String code = "";
		for (int i = 0; i < number; i++) {	//	number=4
			char ch = getRandomChar();
			code+=ch;
			drawChar(i, font, ch,60,30);
		}
		System.out.println(code);
		return code;
	}
	
	/*
	 * 随机生成中文字符
	 * http://blog.csdn.net/xlgen157387/article/details/44061585
	 * @return
	 */
	protected static char getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str.charAt(0);
    }
}
