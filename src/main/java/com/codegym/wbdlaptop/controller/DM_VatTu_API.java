package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.DM_VatTu;
import com.codegym.wbdlaptop.service.Impl.DM_VatTuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/dm_vat_tu")
    public ResponseEntity<?> createDMVatTu(@Valid @RequestBody DM_VatTu dm_vatTu){
        dm_vatTuService.save(dm_vatTu);
        return new ResponseEntity<>(new ResponseMessage("create_success"), HttpStatus.OK);
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
}
