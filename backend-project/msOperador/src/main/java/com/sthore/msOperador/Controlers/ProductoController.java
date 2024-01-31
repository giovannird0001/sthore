package com.sthore.msOperador.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sthore.msOperador.service.ProductService;

@RestController 
@RequestMapping("/product")
public class ProductoController {
    @Autowired
    public  ProductService productService;
    @GetMapping(value="")
    public ResponseEntity<String> getString(){
return  ResponseEntity.status(200).body("Esta es una respuesta personalizada");
    }

}
