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

public class JsonParserException extends Exception {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 6150790058644974535L;

	public JsonParserException(String message, Throwable t) {
		super(message, t);
	}

}
