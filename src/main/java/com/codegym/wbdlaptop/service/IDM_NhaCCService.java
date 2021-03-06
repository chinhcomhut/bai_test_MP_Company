package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.DM_NhaCC;

import java.util.List;
import java.util.Optional;

public interface IDM_NhaCCService {
    void delete(Long id);
    DM_NhaCC save(DM_NhaCC dm_nhaCC);
    List<DM_NhaCC> findAll();
    Optional<DM_NhaCC> findById(Long id);
}
