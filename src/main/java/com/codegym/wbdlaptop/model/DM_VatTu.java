package com.codegym.wbdlaptop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dmVatTu")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="MaNuoc", referencedColumnName="maNuoc")
    })
    private DM_Nuoc dm_nuoc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="MaNCC", referencedColumnName="maNCC")
    })
    private DM_NhaCC dm_nhaCC;

    public DM_VatTu() {
    }

    public DM_VatTu(Long id, @NotBlank @Size(max = 5) String maVT, @Size(max = 25) String maKKS, @NotBlank @Size(max = 50) String tenVT, @NotBlank @Size(max = 25) String dvTinh, User user, DM_Nuoc dm_nuoc, DM_NhaCC dm_nhaCC) {
        this.id = id;
        this.maVT = maVT;
        this.maKKS = maKKS;
        this.tenVT = tenVT;
        this.dvTinh = dvTinh;
        this.user = user;
        this.dm_nuoc = dm_nuoc;
        this.dm_nhaCC = dm_nhaCC;
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
