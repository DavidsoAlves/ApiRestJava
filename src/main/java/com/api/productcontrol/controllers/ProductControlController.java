package com.api.productcontrol.controllers;

import com.api.productcontrol.dtos.ProductControlDto;
import com.api.productcontrol.models.ProductControlModel;
import com.api.productcontrol.services.ProductControlService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product-control")
public class ProductControlController {

    final ProductControlService productControlService;

    public  ProductControlController(ProductControlService productControlService){
        this.productControlService = productControlService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProductControl(@RequestBody @Valid ProductControlDto productControlDto){
        var productControlModel = new ProductControlModel();
        BeanUtils.copyProperties(productControlDto, productControlModel);
        productControlModel.setProductRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return  ResponseEntity.status(HttpStatus.CREATED).body(productControlService.save(productControlModel));

    }

    @GetMapping
    public  ResponseEntity<List<ProductControlModel>> getAllProductControl(){
        return ResponseEntity.status(HttpStatus.OK).body(productControlService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProductControl(@PathVariable(value = "id") UUID id){
        Optional<ProductControlModel> productControlModelOptional = productControlService.findById(id);
        if(!productControlModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productControlModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductControl(@PathVariable(value = "id") UUID id){
        Optional<ProductControlModel> productControlModelOptional = productControlService.findById(id);
        if (!productControlModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        productControlService.delete(productControlModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductControl(@PathVariable(value = "id") UUID id,
                                                       @RequestBody @Valid ProductControlDto productControlDto){
        Optional<ProductControlModel> productControlModelOptional = productControlService.findById(id);
        if (!productControlModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        var productControlModel = productControlModelOptional.get();
        BeanUtils.copyProperties(productControlDto, productControlModel);
        return ResponseEntity.status(HttpStatus.OK).body(productControlService.save(productControlModel));
    }

}
