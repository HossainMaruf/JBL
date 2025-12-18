package com.example.jbl.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jbl.model.Ccsp;
import com.example.jbl.repository.CcspRepository;

@Service
public class CcspService {
   private final CcspRepository repository; 
   public CcspService(CcspRepository repository) {
    this.repository = repository;
   }

   // get all ccsps
   public List<Ccsp> getAllCcsps() {
    return repository.findAll();
   }

   // get ccsp by code
   public Optional<Ccsp> getCcspById(Long id) {
    return repository.findById(id);
   }

   // create or update ccsp
   public Ccsp saveCcsp(Ccsp ccsp) {
    return repository.save(ccsp);
   }

   // delete cccp by id
   public void deleteCcsp(Long id) {
    repository.deleteById(id);
   }
}