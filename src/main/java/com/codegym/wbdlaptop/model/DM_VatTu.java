package com.codegym.wbdlaptop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dmvattu")
public class DM_VatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 5)
    private String maVT;
    @Size(max = 25)
    private String maKKS;
    @NotBlank
    @Size(max = 50)
    private String tenVT;
    @NotBlank
    @Size(max = 25)
    private String dvTinh;
    @ManyToOne
    User user;
    @ManyToOne
    DM_Nuoc dm_nuoc;
    @ManyToOne
    DM_NhaCC dm_nhaCC;

    public DM_VatTu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaVT() {
        return maVT;
    }

    public void setMaVT(String maVT) {
        this.maVT = maVT;
    }

    public String getMaKKS() {
        return maKKS;
    }

    public void setMaKKS(String maKKS) {
        this.maKKS = maKKS;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getDvTinh() {
        return dvTinh;
    }

    public void setDvTinh(String dvTinh) {
        this.dvTinh = dvTinh;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DM_Nuoc getDm_nuoc() {
        return dm_nuoc;
    }

    public void setDm_nuoc(DM_Nuoc dm_nuoc) {
        this.dm_nuoc = dm_nuoc;
    }

    public DM_NhaCC getDm_nhaCC() {
        return dm_nhaCC;
    }

    public void setDm_nhaCC(DM_NhaCC dm_nhaCC) {
        this.dm_nhaCC = dm_nhaCC;
    }
}
