package com.codegym.wbdlaptop.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dmnhacc")
public class DM_NhaCC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maNCC;
    @Size(max = 25)
    private String tenNCC;
    @ManyToOne
    User user;

    public DM_NhaCC() {
    }

    public DM_NhaCC(Long id, Integer maNCC, String tenNCC, User user) {
        this.id = id;
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
