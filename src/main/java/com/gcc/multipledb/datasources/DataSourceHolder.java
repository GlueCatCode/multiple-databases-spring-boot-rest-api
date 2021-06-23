package com.gcc.multipledb.datasources;

public class DataSourceHolder {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

	public static void setBranchContext(String client) {
		threadLocal.set(client);
	}

	public static String getBranchContext() {
		return threadLocal.get();
	}

	public static void clearBranchContext() {
		threadLocal.remove();
	}
	
}
