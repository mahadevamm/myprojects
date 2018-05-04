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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable throwable) {
		super(throwable);
	}
}
