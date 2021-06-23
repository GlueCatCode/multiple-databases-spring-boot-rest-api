package com.gcc.multipledb.datasources;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouting extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getBranchContext();
	}

	public void initDatasource(Map<Object, Object> dataSourceMap, Object defaultDataSource) {
		this.setTargetDataSources(dataSourceMap);
		this.setDefaultTargetDataSource(dataSourceMap.get(defaultDataSource));
	}
	
}
