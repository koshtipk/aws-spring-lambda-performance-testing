package com.performance.example.base;

/**
 * This is wrapper class of BaseLambdaAbstractWrapper abstract class which is
 * being extended by individual implementations to get the request handler based
 * on input.
 */
public abstract class BaseAbstractHandler extends BaseLambdaAbstractWrapper {

	/**
	 * Gets the request handler.
	 *
	 * @return the request handler
	 */
	protected abstract IRequestHandler getRequestHandler();

}
