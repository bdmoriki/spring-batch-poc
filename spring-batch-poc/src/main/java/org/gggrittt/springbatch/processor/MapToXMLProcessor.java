package org.gggrittt.springbatch.processor;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class MapToXMLProcessor implements ItemProcessor<Map<String, Object>, String> {

	@Override
	public String process(Map<String, Object> item) throws Exception {
		return item.toString();
	}

}
