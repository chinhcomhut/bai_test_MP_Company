package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.DM_NhaCC;
import com.codegym.wbdlaptop.model.DM_Nuoc;
import com.codegym.wbdlaptop.model.DM_VatTu;
import com.codegym.wbdlaptop.service.Impl.DM_NhaCCServiceImpl;
import com.codegym.wbdlaptop.service.Impl.DM_NuocServiceImpl;
import com.codegym.wbdlaptop.service.Impl.DM_VatTuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class DM_VatTu_API {
    @Autowired
    DM_VatTuServiceImpl dm_vatTuService;
    @Autowired
    DM_NuocServiceImpl dm_nuocService;
    @Autowired
    DM_NhaCCServiceImpl dm_nhaCCService;
    @PostMapping("/dm_vat_tu")
    public ResponseEntity<?> createDMVatTu(@Valid @RequestBody DM_VatTu dm_vatTu){
        dm_vatTuService.save(dm_vatTu);
        return new ResponseEntity<>(new ResponseMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/pagination_dm_vat_tu") //Lay du lieu va phan trang
    public ResponseEntity<?> pageDMVatTu(@PageableDefault(sort = "maVT", direction = Sort.Direction.ASC) Pageable pageable){
        Page<DM_VatTu> vatTuPage = dm_vatTuService.findAll(pageable);
        if(vatTuPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vatTuPage, HttpStatus.OK);
    }
    @PutMapping("/dm_vat_tu/{id}")
    public ResponseEntity<?> updateDMVatTu(@Valid @RequestBody DM_VatTu dm_vatTu,@PathVariable Long id){
        Optional<DM_VatTu> dm_vatTu1 = dm_vatTuService.findById(id);
        if(!dm_vatTu1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dm_vatTu1.get().setMaKKS(dm_vatTu.getMaKKS());
        dm_vatTu1.get().setTenVT(dm_vatTu.getTenVT());
        dm_vatTu1.get().setDvTinh(dm_vatTu.getDvTinh());
        dm_vatTu1.get().setMaVT(dm_vatTu.getMaVT());
        dm_vatTuService.save(dm_vatTu1.get());
        return new ResponseEntity<>(new ResponseMessage("update_success"), HttpStatus.OK);
    }
    @GetMapping("/dm_vat_tu")
    public ResponseEntity<?> getDMVatTu(){
        List<DM_VatTu> dm_vatTus = dm_vatTuService.findAll();
        if(dm_vatTus.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dm_vatTus, HttpStatus.OK);
    }
 @DeleteMapping("/dm_vat_tu/{id}")
    public ResponseEntity<?> deleteDMVatTu(@PathVariable Long id){
        Optional<DM_VatTu> dm_vatTu = dm_vatTuService.findById(id);
        if(dm_vatTu.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dm_vatTuService.delete(id);
        return new ResponseEntity<>(new ResponseMessage("delete_success"), HttpStatus.OK);
 }
 @GetMapping("/page_vattu_by_ma_nuoc") //Lay du lieu vat tu theo ma nuoc
    public ResponseEntity<?> pageVatTuByMaNuoc(@PathVariable Long id, @PageableDefault(sort = "maVT", direction = Sort.Direction.ASC)Pageable pageable){
        Optional<DM_Nuoc> dm_nuoc = dm_nuocService.findById(id);
        Page<DM_VatTu> vatTuPage = dm_vatTuService.findByDm_nuoc(dm_nuoc.get().getMaNuoc());
        return new ResponseEntity<>(vatTuPage, HttpStatus.OK);
 }
 @GetMapping("/page_vattu_by_ma_nhacc") //Lay du lieu bang vat tu theo ma nha cc
    public ResponseEntity<?> pageVatTuByNhaCC (@PathVariable Long id, @PageableDefault(sort = "maVT", direction = Sort.Direction.ASC)Pageable pageable){
        Optional<DM_NhaCC> dm_nhaCC = dm_nhaCCService.findById(id);
        Page<DM_VatTu> vatTuPage = dm_vatTuService.findByDm_nhaCC(dm_nhaCC.get().getMaNCC());
        return new ResponseEntity<>(vatTuPage, HttpStatus.OK);
 }
}
