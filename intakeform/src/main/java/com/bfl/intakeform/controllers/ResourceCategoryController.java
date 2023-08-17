package com.bfl.intakeform.controllers;
import com.bfl.intakeform.model.ResourceCategory;
import com.bfl.intakeform.repository.ResourceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryRepository resourceCategoryRepository;

    public ResourceCategoryController(ResourceCategoryRepository resourceCategoryRepository){
        super();
        this.resourceCategoryRepository = resourceCategoryRepository;
    }

    @CrossOrigin
    @GetMapping("/resourceCategory")
    public Iterable<ResourceCategory> resourceCategories(){
        return resourceCategoryRepository.findAll();
    }

    //resourceCategory/2
    @GetMapping("/resourceCategory/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<ResourceCategory> resourceCategory = resourceCategoryRepository.findById(id);
        return resourceCategory.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @CrossOrigin
    @PostMapping("/resourceCategory")
    ResponseEntity<ResourceCategory> createResourceCategory(@Valid @RequestBody ResourceCategory resourceCategory) throws URISyntaxException {
        ResourceCategory result= resourceCategoryRepository.save(resourceCategory);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);

    }

    @CrossOrigin
    @PutMapping("/resourceCategory/{id}")
    ResponseEntity<ResourceCategory> updateResourceCategory(@Valid @RequestBody ResourceCategory resourceCategory){
        ResourceCategory result= resourceCategoryRepository.save(resourceCategory);
        return ResponseEntity.ok().body(result);
    }



    @DeleteMapping("/resourceCategory/{id}")
    ResponseEntity<?> deleteResourceCategory(@PathVariable Long id){
        resourceCategoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}