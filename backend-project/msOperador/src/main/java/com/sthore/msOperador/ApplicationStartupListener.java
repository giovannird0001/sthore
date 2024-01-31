package com.sthore.msOperador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sthore.msOperador.models.Product;
import com.sthore.msOperador.service.ProductService;
 

@Component
public class ApplicationStartupListener {
    @Autowired
     private  ProductService productService;
   @Autowired
    private JdbcTemplate jdbcTemplate;
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
   
        System.out.println("gio La aplicación ha iniciado y está lista para ser utilizada.");
        if (isTableExists("product")) {
            System.out.println("La tabla 'product' existe en la base de datos.");
        } else {
            System.out.println("La tabla 'product' NO existe en la base de datos.");
            List<Product> sampleProducts = ApplicationStartupListener.getSampleProducts();
            productService.saveSampleProducts(sampleProducts);
        }
    }
    private boolean isTableExists(String tableName) {
   
        String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = ?";

     
        int count = jdbcTemplate.queryForObject(sql, Integer.class, tableName);

        return count > 0;
    }
    public static List<Product> getSampleProducts() {
        List<Product> productList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Product product = new Product();
            product.setName("Producto " + i);
            product.setPrice(10.0 * i);  // Precios variados para ejemplo
            product.setDescription("Descripción del producto " + i);
            product.setImageUrl("url_imagen_" + i);

            productList.add(product);
        }

        return productList;
    }
}
