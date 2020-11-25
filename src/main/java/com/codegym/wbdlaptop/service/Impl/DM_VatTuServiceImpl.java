package com.codegym.wbdlaptop.service.Impl;

import com.codegym.wbdlaptop.model.DM_VatTu;
import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.repository.IDM_VatTuRepository;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.IDM_VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DM_VatTuServiceImpl implements IDM_VatTuService {
    @Autowired
    IDM_VatTuRepository vatTuRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    public void delete(Long id) {
       vatTuRepository.deleteById(id);
    }

    @Override
    public DM_VatTu save(DM_VatTu dm_vatTu) {
        User user = userDetailsService.getCurrentUser();
        dm_vatTu.setUser(user);
        return vatTuRepository.save(dm_vatTu);
    }

    @Override
    public Optional<DM_VatTu> findById(Long id) {
        return vatTuRepository.findById(id);
    }

    @Override
    public List<DM_VatTu> findAll() {
        return vatTuRepository.findAll();
    }

    @Override
    public Page<DM_VatTu> findAll(Pageable pageable) {
        return vatTuRepository.findAll(pageable);
    }

    @Override
    public Page<DM_VatTu> findByDm_nhaCC(Integer ma_nhaCC) {
        return vatTuRepository.findByDm_nhaCC(ma_nhaCC);
    }

    @Override
    public Page<DM_VatTu> findByDm_nuoc(Integer ma_nuoc) {
        return vatTuRepository.findByDm_nuoc(ma_nuoc);
    }
}
