/** Filename: RestClientException.java
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

import org.springframework.http.HttpStatus;

public class RestClientException extends RuntimeException {

	private static final long serialVersionUID = -1846848191413700580L;

	private HttpStatus statusCode;

	private String body;

	public RestClientException(String msg) {
		super(msg);
	}

	public RestClientException(HttpStatus statusCode, String body, String msg) {
		super(msg);
		this.statusCode = statusCode;
		this.body = body;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
