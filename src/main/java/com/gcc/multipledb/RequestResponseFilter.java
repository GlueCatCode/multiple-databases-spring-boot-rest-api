package com.gcc.multipledb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.gcc.multipledb.datasources.DataSourceHolder;

@Component
public class RequestResponseFilter implements Filter {
	
	private static Logger log = LoggerFactory.getLogger(RequestResponseFilter.class);
	
	private Map<String, String> hashListDatabases;
	
	@Autowired
	private Environment env;
	
	@Value("${gcc.databases}")
	private String[] gccDatabases;
	
	public Map<String, String> getHashListDatabases() {
		if(hashListDatabases == null) {
			hashListDatabases = new HashMap<>();
			for(String database : gccDatabases) {
				hashListDatabases.put(env.getProperty("gcc.hash." + database), database);
			}
			log.info(hashListDatabases.toString());
		}
		return hashListDatabases;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String hash = httpRequest.getHeader("hash-multipledb");
		
		if(hash != null && getHashListDatabases().containsKey(hash)) {
			DataSourceHolder.setBranchContext(hashListDatabases.get(hash));
			log.info(hashListDatabases.get(hash) + " selected by hash: " + hash);
			chain.doFilter(request, response);
		}
		
		log.info("Request not accepted...");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return;
		
	}

}
