package ra.bai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.bai1.dto.response.CategoriesResponse;
import ra.bai1.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
@GetMapping
//    public ResponseEntity<List<CategoriesResponse>> findAll(){
//        List<CategoriesResponse> listCategories = categoriesService.findAll();
//        return new ResponseEntity<>(listCategories, HttpStatus.OK);
//    }
    public String hello(){
    return "Hello word";
}
}
