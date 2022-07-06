package com.performance.example.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.performance.example.base.BaseAbstractHandler;
import com.performance.example.base.IRequestHandler;

/**
 * This is concrete request handler class which is used to identify request
 * handler.
 */
@Component
public class RequestHandler extends BaseAbstractHandler {

	/** The greetings handler. */
	@Autowired
	GreetingsHandler greetingsHandler;

	/**
	 * Gets the request handler.
	 *
	 * @return the request handler
	 */
	@Override
	protected IRequestHandler getRequestHandler() {

		return greetingsHandler;
	}

}
