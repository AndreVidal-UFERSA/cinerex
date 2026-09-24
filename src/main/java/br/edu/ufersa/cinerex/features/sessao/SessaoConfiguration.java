package br.edu.ufersa.cinerex.features.sessao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SessaoConfiguration {
    @Bean
    SessaoQuery sessaoQuery(SessaoRepository repository, SessaoMapper mapper) {
        return new SessaoQueryImpl(repository, mapper);
    }
}
