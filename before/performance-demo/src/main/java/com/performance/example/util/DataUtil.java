package com.performance.example.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.JsonObject;
import com.performance.example.base.model.DataModel;

/**
 * The data utility class used to consume data list and generate csv file.
 */
@Component
public class DataUtil {

	/**
	 * Export CSV.
	 *
	 * @param dataList the data list
	 * @return the response entity
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ResponseEntity<String> exportCSV(List<DataModel> dataList) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		OutputStreamWriter outputwriter = new OutputStreamWriter(out);

		/** Adding 1st row or the headers for the transactions */
		ICsvBeanWriter csvWriter = new CsvBeanWriter(outputwriter, CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "Id", "Status", "Date" };
		String[] mappingHeader = { "id", "status", "date" };

		csvWriter.writeHeader(csvHeader);

		dataList.forEach((dataModel) -> {
			try {
				csvWriter.write(dataModel, mappingHeader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		csvWriter.close();

		byte[] bytes = out.toByteArray();

		HttpHeaders headerMap = new HttpHeaders();

		ResponseEntity<String> responseEntity = ResponseEntity.status(HttpStatus.OK).headers(headerMap)
				.body(prepareResponseBody(bytes));

		return responseEntity;
	}

	/**
	 * Convert csv byte array to base64 and prepare response body .
	 *
	 * @param bytes the bytes
	 * @return the string
	 */
	private String prepareResponseBody(byte[] bytes) {

		String base64 = Base64.encodeBase64String(bytes);
		JsonObject responseObject = new JsonObject();
		responseObject.addProperty("content", base64);

		return responseObject.toString();

	}

}
