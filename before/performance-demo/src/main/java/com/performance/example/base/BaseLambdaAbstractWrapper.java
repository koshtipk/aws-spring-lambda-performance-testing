package com.performance.example.base;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * This is the base class which originally implements RequestHandler class to
 * implement its handleRequest() method. Internally it first identifies request
 * handler and then invoke their respective handleRequest() method based on
 * handler identified.
 */
public abstract class BaseLambdaAbstractWrapper implements RequestHandler<Map<String, Object>, ResponseEntity<String>> {

	/** The base abstract handler. */
	protected BaseAbstractHandler baseAbstractHandler;

	/**
	 * Sets the base abstract handler which is being injected by BaseLambda class.
	 *
	 * @param baseAbstractHandler the new base abstract handler
	 */
	protected void setBaseAbstractHandler(BaseAbstractHandler baseAbstractHandler) {
		this.baseAbstractHandler = baseAbstractHandler;
	}

	/**
	 * Handle request method which first identified the handler and then invoke
	 * their handleRequest() method.
	 *
	 * @param input   the input
	 * @param context the context
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<String> handleRequest(Map<String, Object> input, Context context) {

		IRequestHandler iRequestHandler = baseAbstractHandler.getRequestHandler();
		return iRequestHandler.handleRequest(input, context);

	}

}
