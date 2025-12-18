package com.example.jbl.controller;

import java.util.List;
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
  public List<Ccsp> getCcspById() {
    return service.getAllCcsps();
  }

  // GET ccsp by id
  @GetMapping("/{id}")
  public ResponseEntity<Ccsp> getCcspById(@PathVariable Long id) {
    return service.getCcspById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
  }

  // POST create ccsp
  @PostMapping
  public Ccsp createCcsp(@RequestBody Ccsp ccsp) {
    return service.saveCcsp(ccsp);
  }

  // PUT update ccsp
  public ResponseEntity<Ccsp> updateCcsp(@PathVariable Long id, @RequestBody Ccsp updatedCcsp) {
    return service.getCcspById(id).map(ccsp -> {
        ccsp.setId(updatedCcsp.getId());
        ccsp.setName(updatedCcsp.getName());
        ccsp.setDepartment(updatedCcsp.getDepartment());
        ccsp.setTotalDuration(updatedCcsp.getTotalDuration());
        ccsp.setTermDuration(updatedCcsp.getTermDuration());
        ccsp.setTermType(updatedCcsp.getTermType());
        service.saveCcsp(ccsp);
        return ResponseEntity.ok(ccsp);
    }).orElse(ResponseEntity.notFound().build());
  }

  // DELETE ccsp
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCcsp(@PathVariable Long id) {
    return service.getCcspById(id).map(ccsp -> {
        service.deleteCcsp(id);
        return ResponseEntity.ok("Deleted ccsp with id "+id);
    }).orElse(ResponseEntity.notFound().build());
  }
}
