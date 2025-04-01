package in.spbt.main.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import in.spbt.main.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

