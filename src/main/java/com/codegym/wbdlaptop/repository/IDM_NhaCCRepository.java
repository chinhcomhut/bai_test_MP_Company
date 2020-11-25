package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.DM_NhaCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDM_NhaCCRepository extends JpaRepository<DM_NhaCC, Long> {
}
