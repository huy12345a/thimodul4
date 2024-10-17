package com.codegym.thimodul4.controller;

import com.codegym.thimodul4.model.Coupon;
import com.codegym.thimodul4.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private ICouponService couponService;

    @GetMapping
    public ModelAndView listCoupons() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("coupons", couponService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("coupon", new Coupon());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCoupon(@ModelAttribute("coupon") Coupon coupon) {
        couponService.save(coupon);
        return "redirect:/coupons";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Coupon> coupon = couponService.findById(id);
        if (coupon.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("coupon", coupon.get());
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/coupons");
        }
    }

    @PostMapping("/update")
    public String updateCoupon(@ModelAttribute("coupon") Coupon coupon) {
        couponService.save(coupon);
        return "redirect:/coupons";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Coupon> coupon = couponService.findById(id);
        if (coupon.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("coupon", coupon.get());
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/coupons");
        }
    }

    @PostMapping("/delete")
    public String deleteCoupon(@ModelAttribute("coupon") Coupon coupon) {
        couponService.remove(coupon.getId());
        return "redirect:/coupons";
    }
}
