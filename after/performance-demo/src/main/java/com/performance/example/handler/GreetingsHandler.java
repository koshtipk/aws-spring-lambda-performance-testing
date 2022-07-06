package com.performance.example.handler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.performance.example.base.BaseRequestHandler;
import com.performance.example.base.model.DataModel;
import com.performance.example.base.util.BaseUtil;
import com.performance.example.util.DataUtil;

/**
 * This is concrete implementation of lambda function which extends
 * BaseRequestHandler base class and implements their own handleRequest() method
 * for their purpose.
 */
@Component
public class GreetingsHandler extends BaseRequestHandler {

	/** The base utility class to generate sample data. */
	@Autowired
	BaseUtil baseUtil;

	/** The data utility class to prepare csv file. */
	@Autowired
	DataUtil dataUtil;

	/**
	 * Handle request.
	 *
	 * @param input   the input
	 * @param context the context
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<String> handleRequest(Map<String, Object> input, Context context) {

		List<DataModel> dataList = baseUtil.generateSampleData();

		try {
			return dataUtil.exportCSV(dataList);

		} catch (IOException e) {

			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
