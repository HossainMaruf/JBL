package com.example.jbl.controller;

import java.util.List;

import com.example.jbl.dto.CcspDto;
import com.example.jbl.dto.DtoMapper;
import com.example.jbl.model.Ccsp;
import com.example.jbl.service.CcspService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ccsps")
public class CcspController {
  private final CcspService service; 
  public CcspController(CcspService service) {
    this.service = service;
  }

  // GET all ccsps
  @GetMapping
  public List<CcspDto> getCcsps() {
    List<Ccsp> ccsps = service.getAllCcsps();
    return ccsps.stream().map(DtoMapper::getCcspDto).toList();
  }

  // GET ccsp by code
  @GetMapping("/{code}")
  public ResponseEntity<CcspDto> getCcspByCode(@PathVariable Long code) {
    return service.getCcspByCode(code)
                .map(ccsp -> ResponseEntity.ok(DtoMapper.getCcspDto(ccsp)))
                .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // POST create ccsp
  @PostMapping
  public Ccsp createCcsp(@RequestBody Ccsp ccsp) {
    return service.saveCcsp(ccsp);
  }

  // PUT update ccsp
  public ResponseEntity<Ccsp> updateCcsp(@PathVariable Long code, @RequestBody Ccsp updatedCcsp) {
    return service.getCcspByCode(code).map(ccsp -> {
        ccsp.setName(updatedCcsp.getName());
        ccsp.setDepartment(updatedCcsp.getDepartment());
        ccsp.setTotalDuration(updatedCcsp.getTotalDuration());
        ccsp.setTermDuration(updatedCcsp.getTermDuration());
        ccsp.setTermType(updatedCcsp.getTermType());
        service.saveCcsp(ccsp);
        return ResponseEntity.ok(ccsp);
    }).orElse(ResponseEntity.notFound().build());
  }

  // DELETE ccsp by code
  @DeleteMapping("/{code}")
  public ResponseEntity<String> deleteCcsp(@PathVariable Long code) {
    return service.getCcspByCode(code).map(ccsp -> {
        service.deleteCcsp(code);
        return ResponseEntity.ok("Deleted ccsp with code "+code);
    }).orElse(ResponseEntity.notFound().build());
  }
}
