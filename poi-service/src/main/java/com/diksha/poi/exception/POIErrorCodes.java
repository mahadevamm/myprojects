/** Filename: POIErrorCodes.java
 * Author:Mallikarjuna
 * Creation: 2016 May
 * 
 * (C) Snipe IT Solutions
 *
 * All rights are reserved. Reproduction or transmission in whole or in part,in 
 * any form or by any means, electronic, mechanical or otherwise, is prohibited 
 * without the prior written permission of the copyright owner.
 * 
 **/
package com.diksha.poi.exception;

/**
 * 
 * Contains all error codes and messages to expose clients
 *
 */
public enum POIErrorCodes {

	DHC_FILE_NOT_FOUND(404, "Specified resource doesn't exist"),
	DHC_UPLOAD_ERROR(500,"Error in "),
	DHC_IMAGE_NOT_FOUND(404, "Specified image not found");

	private final int errorCode;

	private final String errorMessage;

	private POIErrorCodes(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
