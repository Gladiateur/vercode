/*
 * @(#)Config.java	1.0 17/08/02
 * 
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 */

package gla.vercode.standard;

import java.util.Map;

/**
 * 配置文件接口，定义获取配置映射的方法。
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-3
 */
public interface Config {
	/**
	 * 获取配置文件的Map集合
	 * 
	 * @return Map<String,String>
	 */
	public Map<String,String> getConfigMap();
}
