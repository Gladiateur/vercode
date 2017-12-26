/*
 * @(#)MixedCanvas.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Verification code for mixed Chinese and English characters.
 */

package gla.vercode.canvas;

import java.awt.Font;

/**
 * 该类是字母数字中文的混合的验证码
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-4
 */
public class MixedCanvas extends GBCharacterCanvas {
	@Override
	public String createVerification(Font font, int number) {
		String code = "";
		for (int i = 0; i < number; i++) {	//	number=4
			int flag = random.nextInt(2);
			if(flag==0){
				//随机获取下标
				int index=random.nextInt(DATAPOOL.length());
				//获取指定索引的字符
				char ch=DATAPOOL.charAt(index);
				code+=ch;
				drawChar(i, font, ch,60,30);
			}else if(flag==1){
				char ch = getRandomChar();
				code+=ch;
				drawChar(i, font, ch,60,30);
			}	
		}
		System.out.println(code);
		return code;
	}
}
