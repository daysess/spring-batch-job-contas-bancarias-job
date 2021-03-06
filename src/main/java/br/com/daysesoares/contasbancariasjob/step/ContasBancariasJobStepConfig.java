package br.com.daysesoares.contasbancariasjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.daysesoares.contasbancariasjob.dominio.Cliente;

@Configuration
public class ContasBancariasJobStepConfig<Conta> {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step jdbcCursorReaderStep(
			ItemReader<Cliente> jdbcCursorReader, 
			ItemProcessor<Cliente, Cliente>  processarValidacao,
			ItemWriter<Cliente> writerValidacao) {
		return stepBuilderFactory
				.get("jdbcCursorReaderStep")
				.<Cliente, Cliente>chunk(1)
				.reader(jdbcCursorReader)
				.processor(processarValidacao)
				.writer(writerValidacao)
				.build();
	}
	
}
