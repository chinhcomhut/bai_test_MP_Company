package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.DM_VatTu;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDM_VatTuRepository extends JpaRepository<DM_VatTu, Long> {
    Page<DM_VatTu> findByDm_nhaCC(Integer ma_nhaCC);
    Page<DM_VatTu> findByDm_nuoc(Integer ma_nuoc);
}

