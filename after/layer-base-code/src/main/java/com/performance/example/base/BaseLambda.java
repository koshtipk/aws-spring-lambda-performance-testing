package com.performance.example.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.performance.example.base.config.BaseConfig;

/**
 * This is the starting point of all lambda request which in turn invokes handle
 * request based on identified handler.
 */
public class BaseLambda extends BaseLambdaAbstractWrapper {

	/** The request handler. */
	@Autowired
	BaseAbstractHandler requestHandler;

	/** The ctx. */
	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
			BaseConfig.class.getPackage().getName());

	/**
	 * Instantiates a new base lambda and inject request handler dependencies.
	 */
	public BaseLambda() {
		ctx.getAutowireCapableBeanFactory().autowireBean(this);
		setBaseAbstractHandler(requestHandler);
	}

}
