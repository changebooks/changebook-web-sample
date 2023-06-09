package io.github.changebooks.web.sample;

import io.github.changebooks.code.base.Result;
import io.github.changebooks.code.biz.ResultUtils;
import io.github.changebooks.web.PageList;
import io.github.changebooks.web.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author changebooks@qq.com
 */
@Api(value = "JacksonController", tags = "Jackson")
@RequestMapping("jackson")
@RestController
public class JacksonController {

    @ApiOperation(value = "避免 long 丢失精度")
    @GetMapping(value = "/java-script-long")
    public Long jsLong() {
        return 123456789123456789L;
    }

    @ApiOperation(value = "分页1")
    @GetMapping(value = "/page-list-1")
    public PageList<Long> pageList1() {
        PageList<Long> pageList = new PageList<>();

        pageList.setTotalNum(123456789123456789L);
        pageList.setData(Collections.singletonList(123456789123456789L));
        pageList.setRequest(new PageRequest());

        return pageList;
    }

    @ApiOperation(value = "分页2")
    @GetMapping(value = "/page-list-2")
    public Result<PageList<Long>> pageList2() {
        PageList<Long> pageList = new PageList<>();

        pageList.setTotalNum(123456789123456789L);
        pageList.setData(Collections.singletonList(123456789123456789L));
        pageList.setRequest(new PageRequest());

        return ResultUtils.toSuccess(pageList);
    }

}
