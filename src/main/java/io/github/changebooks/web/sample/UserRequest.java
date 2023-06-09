package io.github.changebooks.web.sample;

import io.github.changebooks.web.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author changebooks@qq.com
 */
@ApiModel
public final class UserRequest extends BaseRequest {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true, dataType = "Long", example = "0")
    private Long id;

    @NotBlank(message = "用户名必填")
    @Length(min = 2, message = "用户名长度必须大于2")
    @Length(max = 6, message = "用户名长度必须小于6")
    @ApiModelProperty(value = "用户名", required = true, dataType = "String", example = "''")
    private String username;

    @Min(value = 1, message = "年龄必须大于0")
    @ApiModelProperty(value = "年龄", required = true, dataType = "Integer", example = "0")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
