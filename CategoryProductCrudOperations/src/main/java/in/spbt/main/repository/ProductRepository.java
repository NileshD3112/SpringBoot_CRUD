package in.spbt.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.spbt.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
