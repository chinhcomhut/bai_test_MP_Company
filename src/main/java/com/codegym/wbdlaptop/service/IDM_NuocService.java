package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.DM_Nuoc;

import java.util.List;

public interface IDM_NuocService {
    DM_Nuoc save(DM_Nuoc dm_nuoc);
    void delete(Long id);
    List<DM_Nuoc> findAll();
}
