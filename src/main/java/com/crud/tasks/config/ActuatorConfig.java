package com.crud.tasks.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ActuatorConfig {
    @Value("${info.company.name}")
    private String companyName;

}
