package com.dwj.springcloud.service.impl;

import com.dwj.springcloud.dao.PaymentDao;
import com.dwj.springcloud.entities.Payment;
import com.dwj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Payment getPaymentBySerial(String serial) {
        return paymentDao.getPaymentBySerial(serial);
    }

    @Override
    public Payment[] getAllPayment() {
        return paymentDao.getAllPayment();
    }
}
