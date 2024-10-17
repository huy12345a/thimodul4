package com.codegym.thimodul4.service;

import com.codegym.thimodul4.model.Coupon;
import com.codegym.thimodul4.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CouponService implements ICouponService {
    @Autowired
    private ICouponRepository iCouponRepository;

    @Override
    public Iterable<Coupon> findAll() {
        return iCouponRepository.findAll();
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return iCouponRepository.findById(id);
    }

    @Override
    public void save(Coupon coupon) {
        iCouponRepository.save(coupon);
    }

    @Override
    public void remove(Long id) {
        iCouponRepository.deleteById(id);
    }
}
