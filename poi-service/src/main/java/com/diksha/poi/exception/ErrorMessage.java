/** Filename: ErrorMessage.java
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

public class ErrorMessage {

	private String code;
	private String message;
	private String reason;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
