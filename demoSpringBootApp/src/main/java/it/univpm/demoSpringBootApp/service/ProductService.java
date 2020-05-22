package it.univpm.demoSpringBootApp.service;

import java.util.Collection;

import it.univpm.demoSpringBootApp.model.Product;

public interface ProductService {
	
	public abstract void CreateProduct(Product product);
	public abstract void UpdateProduct(Integer id, Product product);
	public abstract void DeleteProduct(Integer id);
	public abstract Collection<Product> getProducts();
}
