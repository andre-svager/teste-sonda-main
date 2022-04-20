package br.com.elo7.sonda.candidato.infrastructure.config;

import br.com.elo7.sonda.candidato.SevenMarsApplication;
import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;
import br.com.elo7.sonda.candidato.domain.service.DomainProbeService;
import br.com.elo7.sonda.candidato.domain.service.ProbeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SevenMarsApplication.class)
public class BeanConfiguration {

    @Bean
    ProbeService probeService(ProbesRepository probesRepository, PlanetsRepository planetsRepository) {
       return new DomainProbeService(probesRepository, planetsRepository);
    }
}