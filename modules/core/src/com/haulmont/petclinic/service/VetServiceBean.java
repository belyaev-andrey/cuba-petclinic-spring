package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.petclinic.entity.Vet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

@Service(VetService.NAME)
public class VetServiceBean implements VetService {

    @Inject
    private DataManager dataManager;

    @Override
    @Cacheable("vets")
    public Collection<Vet> findAll() {
        return dataManager.load(Vet.class)
                .query("select v from cubapetclinic$Vet v")
                .view("vet-specialities-view")
                .list();
    }

}