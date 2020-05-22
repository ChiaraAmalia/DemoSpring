package it.univpm.demoSpringBootApp.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import it.univpm.demoSpringBootApp.model.Product;
import it.univpm.demoSpringBootApp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	//hashmap
	private static Map<Integer, Product> productRepo = new HashMap<>();
	//contatore generatore di id
	private final AtomicLong counter = new AtomicLong();
	
	public ProductServiceImpl() {
		
		Product honey = new Product();
		honey.setId((int)counter.incrementAndGet());
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);
		
		Product almond = new Product();
		almond.setId((int)counter.incrementAndGet());
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}
	/**
	 * Si va a verificare se esiste gia un prodotto con lo stesso id
	 * e se esiste, viene generata un'eccezione
	 */
	@Override 
	public void CreateProduct(Product product) {
		
		if(productRepo.containsKey(product.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existing id...");
		}
		productRepo.put(product.getId(), product);
	}
	/**
	 *l'update non fa altro che rimuovere l'elemento dalla hashmap, 
	 *setta l'identificatore e riaggiorna
	 */
	@Override
	public void UpdateProduct(Integer id, Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
	}

	@Override
	public void DeleteProduct(Integer id) {
		productRepo.remove(id);
	}
	
	/**
	 * viene utilizzato per ottenere la lista i tutti i prodotti
	 */
	@Override
	public Collection<Product> getProducts() {

		return productRepo.values();
	}

}
