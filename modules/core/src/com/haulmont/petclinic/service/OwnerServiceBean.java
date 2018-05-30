package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.petclinic.entity.Owner;
import com.haulmont.petclinic.entity.Vet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

@Service(OwnerService.NAME)
public class OwnerServiceBean implements OwnerService {

    @Inject
    private Persistence persistence;

    @Inject
    private DataManager dataManager;

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findByLastName(String lastName) {
        return persistence.getEntityManager()
                .createQuery("SELECT DISTINCT owner FROM cubapetclinic$Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%", Owner.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public Owner findById(Integer id) {
        LoadContext<Owner> owners = LoadContext.create(Owner.class)
                .setId(id)
                .setView("owner-with-pets");
        return dataManager.load(owners);
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        persistence.getEntityManager().persist(owner);
    }
}