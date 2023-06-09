package io.github.changebooks.web.sample;

import io.github.changebooks.web.DocketProperties;
import io.github.changebooks.web.DocketSupport;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author changebooks@qq.com
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties({DocketProperties.class})
public class DocketImpl extends DocketSupport {

    @Bean
    @Override
    public Docket docket(DocketProperties docketProperties) {
        return super.docket(docketProperties);
    }

}
