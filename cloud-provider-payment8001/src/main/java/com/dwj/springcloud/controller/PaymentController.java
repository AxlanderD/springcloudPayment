package com.dwj.springcloud.controller;

import com.dwj.springcloud.entities.CommonResult;
import com.dwj.springcloud.entities.Payment;
import com.dwj.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@Api(description = "用户操作接口")
@RestController
//用于日志输出
@Slf4j
@RequestMapping("/api/payment/")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @ApiOperation(value = "创建payment对象",
            notes = "通过传入serial创建支付订单")
    @ApiImplicitParam(name = "serial",
            value = "传入流水号创建支付订单实体",
            paramType = "query",
            required = true,
            dataType = "Payment"
    )
    @PostMapping("create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("result:"+result);
        if(result>0){
            return new CommonResult(200,"增加成功",result);
        }else{
            return new CommonResult(400,"添加操作失败",null);
        }
    }

    @GetMapping("getPaymentById")
    public CommonResult getPaymentById(@RequestParam("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("result:"+result);
        if(result == null){
            return new CommonResult(401,"查询失败,无记录",null);
        }else{
            return new CommonResult(200,"查询成功",result);
        }
    }

    @GetMapping("getPaymentBySerial")
    public CommonResult getPaymentBySerial(@RequestParam("serial") String serial){
        Payment result = paymentService.getPaymentBySerial(serial);
        log.info("result:"+result);
        if(result == null){
            return new CommonResult(401,"查询失败,无记录",null);
        }else{
            return new CommonResult(200,"查询成功",result);
        }
    }

    @GetMapping("getAllPayment")
    public CommonResult getAllPayment(){
        Payment[] result = paymentService.getAllPayment();
        log.info("result:"+result);
        if(result == null){
            return new CommonResult(401,"查询失败,无记录",null);
        }else{
            return new CommonResult(200,"查询成功",result);
        }
    }
}
