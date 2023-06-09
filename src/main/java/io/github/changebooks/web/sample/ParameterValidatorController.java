package io.github.changebooks.web.sample;

import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author changebooks@qq.com
 */
@Api(value = "ParameterValidatorController", tags = "参数验证")
@Validated
@RequestMapping("parameter-validator")
@RestController
public class ParameterValidatorController {

    @ApiOperation(value = "验证Get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", example = ""),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "Integer", example = "0")
    })
    @GetMapping(value = "/validate-get")
    public Result<?> validateGet(@NotBlank(message = "用户名必填") @Length(min = 2, message = "用户名长度必须大于2") String username,
                                 @Min(value = 1, message = "年龄必须大于0") Integer age) {
        return ResultUtils.toSuccess(username);
    }

    @ApiOperation(value = "验证Post")
    @PostMapping(value = "/validate-post")
    public Result<?> validatePost(@Validated @RequestBody UserRequest userRequest) {
        return ResultUtils.toSuccess(userRequest);
    }

}
