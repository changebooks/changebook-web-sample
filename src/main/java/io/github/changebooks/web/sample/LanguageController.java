package io.github.changebooks.web.sample;

import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author changebooks@qq.com
 */
@Api(value = "LanguageController", tags = "语言")
@RequestMapping("language")
@RestController
public class LanguageController {

    @ApiOperation(value = "英语")
    @GetMapping(value = "/english")
    public Result<?> english() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:message_en_gb");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());

        String message = messageSource.getMessage("OUTPUT_LANGUAGE", null, "", LocaleContextHolder.getLocale());
        return ResultUtils.toSuccess(message);
    }

    @ApiOperation(value = "汉语-简体")
    @GetMapping(value = "/chinese")
    public Result<?> chinese() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:message_zh_cn");
        messageSource.setDefaultEncoding("GBK");

        String message = messageSource.getMessage("OUTPUT_LANGUAGE", null, "", LocaleContextHolder.getLocale());
        return ResultUtils.toSuccess(message);
    }

    @ApiOperation(value = "漢語-繁體")
    @GetMapping(value = "/traditional")
    public Result<?> traditional() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:message_zh_tw");
        messageSource.setDefaultEncoding("GBK");

        String message = messageSource.getMessage("OUTPUT_LANGUAGE", null, "", LocaleContextHolder.getLocale());
        return ResultUtils.toSuccess(message);
    }

}
