package com.example.Company_data;




import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company_data.model.Company;
import com.example.Company_data.repositories.Company_repositorie;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Information")

public class CompanyController {
	
  @Autowired
  private Company_repositorie repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Company> getAllPets() {
	  
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Company getPetById(@PathVariable("id") ObjectId id) {
	  System.out.println(repository.findBy_id(id).getName());
      return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Company pets) {
    pets.set_id(id);
    repository.save(pets);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Company createPet(@Valid @RequestBody Company pets) {
    pets.set_id(ObjectId.get());
    repository.save(pets);
    return pets;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}
