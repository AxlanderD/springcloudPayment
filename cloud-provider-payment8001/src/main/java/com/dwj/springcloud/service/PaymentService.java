package com.dwj.springcloud.service;

import com.dwj.springcloud.dao.PaymentDao;
import com.dwj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    Payment getPaymentBySerial(@Param("serial") String serial);

    Payment[] getAllPayment();

}
