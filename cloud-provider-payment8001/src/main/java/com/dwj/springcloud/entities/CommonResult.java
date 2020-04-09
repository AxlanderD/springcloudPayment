package com.dwj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//用于封装返回信息到前端的实体类
public class CommonResult<T>
{
    private Integer code;
    private String  message;
    private T       data;

}
