package com.performance.example.base.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.performance.example.base.model.DataModel;

/**
 * This is base utility class used to generate some sample data which helps to
 * generate some load for our performance testing. This will generate 2000
 * records which will be used to generate csv file by the handler
 * implementation.
 */
@Component
public class BaseUtil {

	/**
	 * Generate sample data of 2000 records.
	 *
	 * @return the list of data model class
	 */
	public List<DataModel> generateSampleData() {

		List<DataModel> dataList = new ArrayList<>();

		for (int i = 0; i < 2000; i++)
			dataList.add(generateDataNode());

		return dataList;
	}

	/**
	 * Generate some random data and store inside data model class.
	 *
	 * @return the data model class
	 */
	private DataModel generateDataNode() {

		DataModel model = new DataModel();
		model.setId((UUID.randomUUID()).toString());
		model.setStatus(new Random().nextBoolean());
		model.setDate(date().toString());

		return model;
	}

	/**
	 * Generate some random dates between 01-Jan-2012 to 01-Jan-2022.
	 *
	 * @return the local date time
	 */
	private LocalDateTime date() {

		long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
		long diff = end - offset + 1;
		Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
		return rand.toLocalDateTime();
	}

}
