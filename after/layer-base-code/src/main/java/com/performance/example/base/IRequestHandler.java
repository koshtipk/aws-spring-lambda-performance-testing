package com.performance.example.base;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * This interface represents only single method handleReqeust() being
 * implemented by different implementations.
 */
public interface IRequestHandler {

	/**
	 * Handle request method for lambda execution.
	 *
	 * @param input   the input
	 * @param context the context
	 * @return the response entity
	 */
	public ResponseEntity<String> handleRequest(Map<String, Object> input, Context context);

}
