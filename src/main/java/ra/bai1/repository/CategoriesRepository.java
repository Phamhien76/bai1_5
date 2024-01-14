package ra.bai1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.bai1.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
