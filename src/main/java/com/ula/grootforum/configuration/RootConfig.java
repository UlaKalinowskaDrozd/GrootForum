package com.ula.grootforum.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Configuration
@ComponentScan(basePackages={"com.ula.grootforum"}, excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {
}
