package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.DM_VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDM_VatTuRepository extends JpaRepository<DM_VatTu, Long> {

}
