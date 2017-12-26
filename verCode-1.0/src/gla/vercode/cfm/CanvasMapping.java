/*
 * @(#)CanvasMapping.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * Canvas mapping class.
 */

package gla.vercode.cfm;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import gla.vercode.standard.Config;

/**
 * 配置映射处理类
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-6
 */
@SuppressWarnings("unchecked")
public class CanvasMapping implements Config{
protected static Map<String, String> xmlMap = new HashMap<String, String>();
	
	static{
		//配置文件应该只加载一次init(),static{}，或重新加载reLoad()
		//异常：找不到文件
		SAXReader reader = new SAXReader();
		Document document = null;
		/**该方法便于获取服务器上的文件的路径，比较常用，应该收进sat4j库中
		 * 只需两个参数：Class class , String fileFullName
		 * */
		//System.out.println(CanvasMapping.class.getClassLoader().getResource("/").getPath()+"canvas-mapping.xml");
		//System.out.println(CanvasMapping.class.getClassLoader().getResource("canvas-mapping.xml"));
		try {
			InputStream in = CanvasMapping.class.getResourceAsStream("/canvas-mapping.xml");	
			document = reader.read(in);
		//	document = reader.read(CanvasMapping.class.getClassLoader().getResource("/").getPath()+"canvas-mapping.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Iterator<Element> iterable = document.getRootElement().elementIterator();
		while (iterable.hasNext()) {
			Element element = iterable.next();
			
			//Element mapping=element.element("mapping");
			String mode=element.attributeValue("mode");
			String clazz=element.attributeValue("class");
			
			xmlMap.put(mode, clazz);
		}
		System.out.println("canvas-mapping loaded!");
	}
	
	public Map<String, String> getConfigMap() {
		return xmlMap;
	}
}
