package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.petclinic.entity.Owner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;

@Service(OwnerService.NAME)
public class OwnerServiceBean implements OwnerService {

    @Inject
    private Persistence persistence;

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findByLastName(String lastName) {
        return persistence.getEntityManager()
                .createQuery("SELECT DISTINCT owner FROM cubapetclinic$Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%", Owner.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findById(Integer id) {
        return persistence.getEntityManager()
                .createQuery("SELECT owner FROM cubapetclinic$Owner owner left join fetch owner.pets WHERE owner.id =:id", Owner.class)
                .setParameter("id", id)
                .getFirstResult();
    }

    @Override
    @Transactional
    public void save(Owner owner) {
        persistence.getEntityManager().persist(owner);
    }
}