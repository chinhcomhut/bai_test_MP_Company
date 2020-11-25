package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.DM_Nuoc;
import com.codegym.wbdlaptop.service.Impl.DM_NuocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class DM_Nuoc_API {
    @Autowired
    DM_NuocServiceImpl dm_nuocService;
    @PostMapping("/dm_nuoc")
    public ResponseEntity<?> createDMNuoc(@Valid @RequestBody DM_Nuoc dm_nuoc){
        dm_nuocService.save(dm_nuoc);
        return new ResponseEntity<>(new ResponseMessage("create_success"), HttpStatus.OK);
    }
    @GetMapping("/dm_nuoc")
    public ResponseEntity<?> getDMNuoc(){
        List<DM_Nuoc> dm_nuocs = dm_nuocService.findAll();
        if(dm_nuocs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dm_nuocs, HttpStatus.OK);
    }
}
