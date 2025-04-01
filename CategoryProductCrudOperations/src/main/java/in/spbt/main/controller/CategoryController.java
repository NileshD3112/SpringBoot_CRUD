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

import in.spbt.main.entities.Category;
import in.spbt.main.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable Long id){
		return categoryRepository.findById(id);
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category categoryDetails) {
		Optional<Category> categoryOptional=categoryRepository.findById(id);
		if(categoryOptional.isPresent()) {
			Category category=categoryOptional.get();
			category.setName(categoryDetails.getName());
			return categoryRepository.save(category);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
	}
}
