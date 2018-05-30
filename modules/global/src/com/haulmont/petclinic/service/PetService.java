package com.haulmont.petclinic.service;


import com.haulmont.petclinic.entity.Pet;
import com.haulmont.petclinic.entity.PetType;

import java.util.List;

public interface PetService {
    String NAME = "cubapetclinic_PetService";

    /**
     * Retrieve all {@link PetType}s from the data store.
     * @return a Collection of {@link PetType}s.
     */
    List<PetType> findPetTypes();

    /**
     * Retrieve a {@link Pet} from the data store by id.
     * @param id the id to search for
     * @return the {@link Pet} if found
     */
    Pet findById(Integer id);

    /**
     * Save a {@link Pet} to the data store, either inserting or updating it.
     * @param pet the {@link Pet} to save
     */
    void save(Pet pet);


}