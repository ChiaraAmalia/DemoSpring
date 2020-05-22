package it.univpm.demoSpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.univpm.demoSpringBootApp.model.Product;
import it.univpm.demoSpringBootApp.service.ProductService;

@RestController
public class ProductController {
	
	/**
	 * Autowired consente, all'interno del controller, di creare 
	 * un'istanza del nostro servizio che protremo utilizzare per 
	 * tutte le operazioni
	 */
	@Autowired
	ProductService productService;
	  
	/**
	 * aggiunta prodotto
	 */
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct(){
		 
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}
	  
	/**
	 * modifica prodotto. Si utilizza un PathVariable per indicare che l'id è mappato
	 * come un intero; viceversa, il body verrà convertito in Product
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		
		productService.UpdateProduct(id, product);
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> DeleteProduct(@PathVariable("id") Integer id){
		productService.DeleteProduct(id);
		return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> CreateProduct(@RequestBody Product product){
		productService.CreateProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
}
