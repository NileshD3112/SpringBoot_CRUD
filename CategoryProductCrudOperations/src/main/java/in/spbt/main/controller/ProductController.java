package in.spbt.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.spbt.main.entities.Product;
import in.spbt.main.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id){
		return productRepository.findById(id);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product productDetails) {
		Optional<Product> productOptional=productRepository.findById(id);
		
		if(productOptional.isPresent()) {
			Product product=productOptional.get();
			product.setName(productDetails.getName());
			product.setPrice(productDetails.getPrice());
			return productRepository.save(product);
		}
	return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
	}
	

}
