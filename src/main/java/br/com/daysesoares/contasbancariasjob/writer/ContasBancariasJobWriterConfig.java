package br.com.daysesoares.contasbancariasjob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.daysesoares.contasbancariasjob.dominio.Cliente;

@Configuration
public class ContasBancariasJobWriterConfig {

	@Bean
	public ItemWriter<Cliente> jdbcCursorWriter(){
		return clientes -> clientes.forEach(System.out::println);
	}
	
}
