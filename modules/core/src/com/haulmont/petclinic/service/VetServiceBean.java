package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
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
        LoadContext<Vet> vets = LoadContext.create(Vet.class)
                .setQuery(LoadContext.createQuery("select v from cubapetclinic$Vet v"))
                .setView("vet-specialities-view");
        return dataManager.loadList(vets);
    }

}