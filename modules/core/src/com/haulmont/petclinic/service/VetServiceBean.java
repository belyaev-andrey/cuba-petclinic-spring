package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.petclinic.entity.Vet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

@Service(VetService.NAME)
public class VetServiceBean implements VetService {

    @Inject
    private Persistence persistence;

    @Override
    @Cacheable("vets")
    @Transactional(readOnly = true)
    public Collection<Vet> findAll() {
        return persistence.getEntityManager()
                .createQuery("select v from cubapetclinic$Vet v", Vet.class).getResultList();
    }
}