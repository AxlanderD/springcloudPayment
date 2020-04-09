package com.dwj.springcloud.dao;

import com.dwj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    Payment getPaymentBySerial(@Param("serial") String serial);

    Payment[] getAllPayment();
}
