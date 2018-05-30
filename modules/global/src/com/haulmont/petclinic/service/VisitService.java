package com.haulmont.petclinic.service;


import com.haulmont.petclinic.entity.Visit;

import java.util.List;

public interface VisitService {
    String NAME = "cubapetclinic_VisitService";

    /**
     * Save a <code>Visit</code> to the data store, either inserting or updating it.
     *
     * @param visit the <code>Visit</code> to save
     */
    void save(Visit visit);

    List<Visit> findByPetId(Integer petId);


}