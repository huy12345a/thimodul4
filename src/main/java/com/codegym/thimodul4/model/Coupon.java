package com.codegym.thimodul4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "coupon")
@Data
public class Coupon {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoiGianBatDau;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoiGianKetThuc;

    @Column(name = "muc_giam_gia", nullable = false)
    private Double mucGiamGia;

    @Column(name = "chi_tiet", columnDefinition = "TEXT")
    private String chiTiet;
}
