package com.gcc.multipledb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;

import com.gcc.multipledb.views.PrincipalView;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class MultipleDbApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Value("${gcc.databases}")
	private String[] gccDatabases;
	
	@Autowired
	private Environment env;
	
	private Map<String, String> hashListDatabases;
	
	@PostConstruct
	public void init() {
		hashListDatabases = new TreeMap<>();
		for(String database : gccDatabases) {
			hashListDatabases.put(database, env.getProperty("gcc.hash." + database));
		}
		restTemplate.getRestTemplate().setInterceptors(
			Collections.singletonList((request, body, execution) -> {
	            request.getHeaders()
	            	.add("hash-multipledb", "VhTbYbcQ3ypce4KBcs59hzn84mxTLDMhxw6ny8Nb");
	            return execution.execute(request, body);
	        }
		));
	}
	
	@Test
	public void principalController() {
		PrincipalView view = getForObject("/principal", PrincipalView.class);
		assertNotNull(view);
		assertNotNull(view.getUsuarios());
		assertEquals(view.getUsuarios().size(), 2);
		assertThat(view.getUsuarios().get(0).getNome()).contains("Administrador");
		assertNotNull(view.getFiliais());
		assertEquals(view.getFiliais().size(), 0);
		assertNotNull(view.getFormasDePagamento());
		assertEquals(view.getFormasDePagamento().size(), 0);
	}
	
	private <T> T getForObject(String url, Class<T> responseType) {
		return restTemplate.getForObject("http://localhost:" + port + url, responseType);
	}
	
}
