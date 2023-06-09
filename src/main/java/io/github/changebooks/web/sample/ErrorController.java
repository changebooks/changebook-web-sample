package io.github.changebooks.web.sample;

import io.github.changebooks.web.Dispatcher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author changebooks@qq.com
 */
@Api(value = "ErrorController", tags = "重定向")
@RequestMapping("error")
@RestController
public class ErrorController {

    @ApiOperation(value = "重定向到“请求方式不支持”")
    @GetMapping(value = "/forward-page-not-found")
    public void forwardPageNotFound() {
        ServletRequestAttributes reqAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        assert reqAttributes != null;
        HttpServletRequest request = reqAttributes.getRequest();
        HttpServletResponse response = reqAttributes.getResponse();

        Dispatcher.forwardPageNotFound(request, response);
    }

    @GetMapping(value = "/page-not-found")
    public String pageNotFound() {
        return "pnf-404";
    }

}
