package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.DM_VatTu;

import java.util.List;
import java.util.Optional;

public interface IDM_VatTuService {
    void delete(Long id);
    DM_VatTu save(DM_VatTu dm_vatTu);
    Optional<DM_VatTu> findById(Long id);
    List<DM_VatTu> findAll();
}
