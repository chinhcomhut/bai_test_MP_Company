package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.DM_Nuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDM_NuocRepository extends JpaRepository<DM_Nuoc, Long> {
}
