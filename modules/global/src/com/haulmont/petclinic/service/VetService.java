package com.haulmont.petclinic.service;


import com.haulmont.petclinic.entity.Vet;

import java.util.Collection;

public interface VetService {
    String NAME = "cubapetclinic_VetService";

    /**
     * Retrieve all <code>Vet</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Vet</code>s
     */
    Collection<Vet> findAll();
}