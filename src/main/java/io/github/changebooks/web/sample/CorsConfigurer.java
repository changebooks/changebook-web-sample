package io.github.changebooks.web.sample;

import io.github.changebooks.web.CorsConfigurerSupport;
import io.github.changebooks.web.CorsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.annotation.Resource;

/**
 * @author changebooks@qq.com
 */
@Configuration
@EnableConfigurationProperties({CorsProperties.class})
public class CorsConfigurer extends CorsConfigurerSupport {

    @Resource
    private CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addMappings(registry, corsProperties);
    }

}
