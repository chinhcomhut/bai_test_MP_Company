package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.DM_Nuoc;

import java.util.List;
import java.util.Optional;

public interface IDM_NuocService {
    DM_Nuoc save(DM_Nuoc dm_nuoc);
    void delete(Long id);
    List<DM_Nuoc> findAll();
    Optional<DM_Nuoc> findById(Long id);
}
