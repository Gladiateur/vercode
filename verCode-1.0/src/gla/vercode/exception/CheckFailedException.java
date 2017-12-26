/*
 * @(#)CheckFailedException.java	1.0 17/08/02
 *
 * Copyright (c) 2017 Gladiateur. All rights reserved.
 * This exception is used to check the validity of the parameter.
 */

package gla.vercode.exception;

/**
 * 检查失败异常
 * 
 * @author Gladiateur
 * @version 1.0 2017-8-3
 */
public class CheckFailedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CheckFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckFailedException(String message) {
		super(message);
	}

	public CheckFailedException(Throwable cause) {
		super(cause);
	}
}
