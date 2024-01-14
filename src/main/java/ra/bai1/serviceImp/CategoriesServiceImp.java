package ra.bai1.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.bai1.dto.request.CategoriesRequest;
import ra.bai1.dto.response.CategoriesResponse;
import ra.bai1.mapper.CategoriesMapper;
import ra.bai1.model.Categories;
import ra.bai1.repository.CategoriesRepository;
import ra.bai1.service.CategoriesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Override
    public List<CategoriesResponse> findAll() {
        List<Categories> listCategories = categoriesRepository.findAll();
        return listCategories.stream()
                .map(categories -> categoriesMapper.mapperEntityToResponse(categories))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse findById(int id) {
        Optional<Categories> optCatalog = categoriesRepository.findById(id);
        if (optCatalog.isPresent()){
            return categoriesMapper.mapperEntityToResponse(optCatalog.get());
        }
        return null;

    }

    @Override
    public CategoriesResponse save(CategoriesRequest categoriesRequest) {
        Categories categories = categoriesRepository.save(categoriesMapper.mapperRequestToEntity(categoriesRequest));

        return categoriesMapper.mapperEntityToResponse(categories);
    }

    @Override
    public CategoriesResponse update(CategoriesRequest categoriesRequest, int id) {
        boolean checkExist = categoriesRepository.existsById(id);
        if (checkExist){
            Categories categories = categoriesRepository.save(categoriesMapper.mapperRequestToEntity(categoriesRequest));
            return categoriesMapper.mapperEntityToResponse(categories);       }
        return null;
    }

    @Override
    public boolean delete(int id) {
        boolean checkExist = categoriesRepository.existsById(id);
        if (checkExist){
            categoriesRepository.deleteById(id);
        }
        return checkExist;
    }

    @Override
    public List<CategoriesResponse> find(String direction, String orderBy, int page, int size) {
        Pageable pageable;
        if (direction.equals("ASC")){
            pageable = PageRequest.of(page,size, Sort.by(orderBy).descending());

        }else {
            pageable = PageRequest.of(page,size,Sort.by(orderBy).descending());
        }
        List<Categories>listCategories = categoriesRepository.findAll(pageable).getContent();
        return listCategories.stream().map(categories -> categoriesMapper.mapperEntityToResponse(categories))
                .collect(Collectors.toList());
    }
}
