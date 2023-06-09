package io.github.changebooks.web.sample;

import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changebooks@qq.com
 */
@Api(value = "ResponseBodyController", tags = "规范响应结果")
@RequestMapping("response-body")
@RestController
public class ResponseBodyController {

    @ApiOperation(value = "成功")
    @GetMapping(value = "/success")
    public Result<String> success() {
        return ResultUtils.toSuccess("success");
    }

    @ApiOperation(value = "失败")
    @GetMapping(value = "/failed")
    public Result<String> failed() {
        return ResultUtils.fromMessage("failed");
    }

}
