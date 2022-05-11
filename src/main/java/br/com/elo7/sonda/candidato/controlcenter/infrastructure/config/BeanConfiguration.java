package br.com.elo7.sonda.candidato.controlcenter.infrastructure.config;

import br.com.elo7.sonda.candidato.SevenMarsApplication;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.DomainControlCenterService;
import br.com.elo7.sonda.candidato.controlcenter.domain.service.ControlCenterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SevenMarsApplication.class)
public class BeanConfiguration {

    @Bean
    ControlCenterService probeService(ProbesRepository probesRepository, PlanetsRepository planetsRepository) {
       return new DomainControlCenterService(probesRepository, planetsRepository);
    }
}