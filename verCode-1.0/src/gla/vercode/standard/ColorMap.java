/*
 * @(#)ColorMap.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Color name and color object mapping.
 */

package gla.vercode.standard;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * 为了便于从配置文件设置颜色 我现在需要在配置文件中设置某键值或某属性值为：blue或BLUE
 * <p>
 * 这个是字符串类型，不能通过Color.XXX的形式设置颜色。在设置颜色时需要Color.XXX,为了
 * 更加便于配置。将颜色的字符串与颜色类型映射到Map集合中。在设置颜色时只需给出字符串名称
 * 即可。
 * </p> 
 * 
 * @author Gladiateur
 * @see java.awt.Color
 * @version 1.0 2017-8-2
 */
public final class ColorMap {
	private ColorMap(){}
	public static Map<String,Color> map;
	
	static{
		map=new HashMap<String, Color>();
		map.put("WHITE", Color.white);
		map.put("LIGHT_GRAY", Color.LIGHT_GRAY);
		map.put("GRAY", Color.GRAY);
		map.put("DARK_GRAY", Color.DARK_GRAY);
		map.put("BLACK", Color.BLACK);
		map.put("RED", Color.RED);
		map.put("PINK", Color.PINK);
		map.put("ORANGE", Color.ORANGE);
		map.put("YELLOW", Color.YELLOW);
		map.put("GREEN", Color.GREEN);
		map.put("MAGENTA", Color.MAGENTA);
		map.put("CYAN", Color.CYAN);
		map.put("BLUE", Color.BLUE);
		
		//map.put(ColorS, new Color())
	}
	
	public final static Color getColor(String colorName){
		return map.get(colorName);
	}
}
