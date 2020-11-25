package com.codegym.wbdlaptop.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dmnuoc")
public class DM_Nuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maNuoc;
    @Size(max = 25)
    private String tenNuoc;
@ManyToOne
User user;

    public DM_Nuoc() {
    }

    public DM_Nuoc(Long id, Integer maNuoc, String tenNuoc, User user) {
        this.id = id;
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(Integer maNuoc) {
        this.maNuoc = maNuoc;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
