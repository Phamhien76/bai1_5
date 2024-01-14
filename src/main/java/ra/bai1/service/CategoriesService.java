package ra.bai1.service;

import ra.bai1.dto.request.CategoriesRequest;
import ra.bai1.dto.response.CategoriesResponse;

import java.util.List;

public interface CategoriesService {
    List<CategoriesResponse> findAll();
    CategoriesResponse findById(int id);
    CategoriesResponse save(CategoriesRequest categoriesRequest);
    CategoriesResponse update(CategoriesRequest categoriesRequest, int id);
    boolean delete(int id);
    List<CategoriesResponse> find(String direction, String orderBy, int page, int size);
}
