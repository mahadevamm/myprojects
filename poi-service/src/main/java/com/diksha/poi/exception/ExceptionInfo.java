/** Filename: ExceptionInfo.java
 * Author: Mallikarjuna
 * Creation: 08-08-2016
 * 
 * Snipe IT Solutions, 2016
 *
 * All rights are reserved. Reproduction or transmission in whole or in part,in 
 * any form or by any means, electronic, mechanical or otherwise, is prohibited 
 * without the prior written permission of the copyright owner.
 **/
package com.diksha.poi.exception;

import java.io.Serializable;

public class ExceptionInfo implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -4531814707450498134L;

	private int errorCode;
	private String errorMessage;

	/**
	 * ExceptionInfo
	 */
	public ExceptionInfo() {
		super();
	}

	/**
	 * ExceptionInfo
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public ExceptionInfo(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the ErrorCode
	 * 
	 * @return errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets errormessage
	 * 
	 * @return errormessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the errorMessage
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
