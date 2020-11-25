package com.codegym.wbdlaptop.service.Impl;

import com.codegym.wbdlaptop.model.DM_Nuoc;
import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.repository.IDM_NuocRepository;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.IDM_NuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DM_NuocServiceImpl implements IDM_NuocService {
    @Autowired
    IDM_NuocRepository idm_nuocRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    public DM_Nuoc save(DM_Nuoc dm_nuoc) {
        User user = userDetailsService.getCurrentUser();
        dm_nuoc.setUser(user);
        return idm_nuocRepository.save(dm_nuoc);
    }

    @Override
    public void delete(Long id) {
    idm_nuocRepository.deleteById(id);
    }

    @Override
    public List<DM_Nuoc> findAll() {
        return idm_nuocRepository.findAll();
    }

    @Override
    public Optional<DM_Nuoc> findById(Long id) {
        return idm_nuocRepository.findById(id);
    }
}
