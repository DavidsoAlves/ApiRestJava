package com.api.productcontrol.services;

import com.api.productcontrol.models.ProductControlModel;
import com.api.productcontrol.repositories.ProductControlRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductControlService {


     final ProductControlRepository productControlRepository;

     public ProductControlService(ProductControlRepository productControlRepository){
         this.productControlRepository = productControlRepository;
     }

     @Transactional
    public ProductControlModel save(ProductControlModel productControlModel) {
         return productControlRepository.save(productControlModel);
    }

    public List<ProductControlModel> findAll() {
         return productControlRepository.findAll();

    }

    public Optional<ProductControlModel> findById(UUID id) {
         return productControlRepository.findById(id);
    }

    @Transactional
    public void delete(ProductControlModel productControlModel) {
         productControlRepository.delete(productControlModel);
    }
}
