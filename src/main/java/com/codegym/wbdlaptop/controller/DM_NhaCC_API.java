package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.DM_NhaCC;
import com.codegym.wbdlaptop.service.Impl.DM_NhaCCServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class DM_NhaCC_API {
    @Autowired
    DM_NhaCCServiceImpl dm_nhaCCService;
    @PostMapping("/dm_nhacc")
    public ResponseEntity<?> createDMNhaCC(@Valid @RequestBody DM_NhaCC dm_nhaCC){
        dm_nhaCCService.save(dm_nhaCC);
        return new ResponseEntity<>(new ResponseMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/dm_nhacc")
    public ResponseEntity<?> getDMNhaCC(){
        List<DM_NhaCC> dm_nhaCCS = dm_nhaCCService.findAll();
        if(dm_nhaCCS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dm_nhaCCS, HttpStatus.OK);
    }
}
