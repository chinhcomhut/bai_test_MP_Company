package com.codegym.wbdlaptop.service.Impl;

import com.codegym.wbdlaptop.model.DM_NhaCC;
import com.codegym.wbdlaptop.model.User;
import com.codegym.wbdlaptop.repository.IDM_NhaCCRepository;
import com.codegym.wbdlaptop.security.service.UserDetailsServiceImpl;
import com.codegym.wbdlaptop.service.IDM_NhaCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DM_NhaCCServiceImpl implements IDM_NhaCCService {
    @Autowired
    IDM_NhaCCRepository nhaCCRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    public void delete(Long id) {
        nhaCCRepository.deleteById(id);
    }

    @Override
    public DM_NhaCC save(DM_NhaCC dm_nhaCC) {
        User user = userDetailsService.getCurrentUser();
        dm_nhaCC.setUser(user);
        return nhaCCRepository.save(dm_nhaCC);
    }

    @Override
    public List<DM_NhaCC> findAll() {
        return nhaCCRepository.findAll();
    }
}
