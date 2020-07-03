package br.com.daysesoares.contasbancariasjob.processor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.daysesoares.contasbancariasjob.dominio.Cliente;
import br.com.daysesoares.contasbancariasjob.dominio.Conta;
import br.com.daysesoares.contasbancariasjob.enums.Tipo;

@Configuration
public class ContasBancariasJobProcessorConfig {

	private Set<String> clientes = new HashSet<>();
	private Conta conta = new Conta();
	
	@Bean
	public ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor(){
		return new CompositeItemProcessorBuilder<Cliente, Cliente>()
				.delegates(contaValidatingProcessor())
				.build();
	}

	private ValidatingItemProcessor<Cliente> contaValidatingProcessor() {
		ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
		processor.setValidator(validator());
		//processor.setFilter(true);
		return processor;
	}

	/*
	 * Validacao customizada
	 */
	private Validator<Cliente> validator() {
		return new Validator<Cliente>() {
			@Override
			public void validate(Cliente cliente) throws ValidationException {	
				conta.setCliente(cliente.getEmail());
				if (cliente.getFaixaSalarial() <= 3000) {
					conta.setTipo(Tipo.PRATA);
					conta.setLimite(500.00);
				} else if (cliente.getFaixaSalarial() > 3000 && cliente.getFaixaSalarial() <= 5000) {
					conta.setTipo(Tipo.OURO);
					conta.setLimite(1000.00);
				} else if (cliente.getFaixaSalarial() > 5000 && cliente.getFaixaSalarial() <= 10000) {
					conta.setTipo(Tipo.PLATINA);
					conta.setLimite(2500.00);
				} else if (cliente.getFaixaSalarial() > 10000) {
					conta.setTipo(Tipo.DIAMANTE);
					conta.setLimite(5000.00);
				}
				cliente.setConta(conta);
								
				clientes.add(cliente.toString());
			}
		};
	}
	
}
