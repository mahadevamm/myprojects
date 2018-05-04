/** Filename: POIException.java
 * Author: Mallikarjuna
 * Creation: 2016 
 * 
 * (C) Snipe IT Solutins
 *
 * All rights are reserved. Reproduction or transmission in whole or in part,in 
 * any form or by any means, electronic, mechanical or otherwise, is prohibited 
 * without the prior written permission of the copyright owner.
 * 
 **/
package com.diksha.poi.exception;



public class POIException extends RuntimeException {

	private static final long serialVersionUID = -5991323831883792612L;

	private ExceptionInfo exceptionInfo;

	public POIException(ExceptionInfo exceptionInfo) {
		super(exceptionInfo.getErrorMessage());
		this.exceptionInfo = exceptionInfo;
	}

	public POIException(ExceptionInfo exceptionInfo,
			Throwable cause) {
		super(exceptionInfo.getErrorMessage(), cause);
		this.exceptionInfo = exceptionInfo;
	}

	/**
	 * @return the exceptionInfo
	 */
	public ExceptionInfo getExceptionInfo() {
		return exceptionInfo;
	}

	/**
	 * @param exceptionInfo
	 *            the exceptionInfo to set
	 */
	public void setExceptionInfo(ExceptionInfo exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

}
