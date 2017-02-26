package org.gggrittt.springbatch.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class QueryPartitioner implements Partitioner {

	private final static Logger LOGGER = LoggerFactory.getLogger(QueryPartitioner.class);

	private Resource[] queriesLocation;

	private String tempDataLocation;

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		LOGGER.debug("Read queries in {}.", queriesLocation);
		LOGGER.debug("Dumb partionning, should be done on files read.");

		final Map<String, ExecutionContext> map = new HashMap<>();
		for (int i = 0; i < 50; i++) {
			final ExecutionContext e = new ExecutionContext();
			map.put("query_" + i, e);
			e.put("query", i);
			e.put("database", i);
			e.put("tempDataFileLocation", new FileSystemResource(tempDataLocation + "/tmp_" + i + ".data"));
		}

		return map;
	}

	public void setTempDataLocation(String tempDataLocation) {
		this.tempDataLocation = tempDataLocation;
	}

	public void setQueriesLocation(Resource[] queriesLocation) {
		this.queriesLocation = queriesLocation;
	}

}
