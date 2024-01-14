package ra.bai1.mapper;

import org.springframework.stereotype.Component;
import ra.bai1.dto.request.CategoriesRequest;
import ra.bai1.dto.response.CategoriesResponse;
import ra.bai1.model.Categories;

@Component
public class CategoriesMapper implements GenericMapper<Categories, CategoriesRequest, CategoriesResponse> {
    @Override
    public Categories mapperRequestToEntity(CategoriesRequest categoriesRequest) {
        return Categories.builder().id(categoriesRequest.getId())
                .name(categoriesRequest.getName())
                .priority(categoriesRequest.getPriority())
                .description(categoriesRequest.getDescriptions())
                .status(categoriesRequest.isStatus()).build();
    }

    @Override
    public CategoriesResponse mapperEntityToResponse(Categories categories) {
        return new CategoriesResponse(
                categories.getId(),
                categories.getName(),
                categories.getPriority(),
                categories.getDescription(),
                categories.isStatus()
                );
    }
}
