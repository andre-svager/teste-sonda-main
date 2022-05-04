package br.com.elo7.sonda.candidato.controlcenter.infrastructure.config;

import br.com.elo7.sonda.candidato.SevenMarsApplication;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ProbeService;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.DomainProbeService;
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