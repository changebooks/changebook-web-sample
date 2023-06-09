package io.github.changebooks.web.sample;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author changebooks@qq.com
 */
@Api(value = "ApplicationContextHolderController", tags = "应用上下文")
@RequestMapping("application-context-holder")
@RestController
public class ApplicationContextHolderController {

    @Resource
    private ApplicationContextHolder applicationContextHolder;

    @ApiOperation(value = "获取Bean实例")
    @GetMapping(value = "/get-bean")
    public ApplicationContextHolder getBean() {
        return applicationContextHolder.getBean("applicationContextHolder", ApplicationContextHolder.class);
    }

    @ApiOperation(value = "获取一个配置")
    @GetMapping(value = "/get-property")
    public String getProperty() {
        return applicationContextHolder.getProperty("spring.application.name");
    }

}
