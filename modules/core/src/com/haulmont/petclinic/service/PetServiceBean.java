package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.petclinic.entity.Pet;
import com.haulmont.petclinic.entity.PetType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(PetService.NAME)
public class PetServiceBean implements PetService {

    @Inject
    private Persistence persistence;

    @Override
    @Transactional(readOnly = true)
    public List<PetType> findPetTypes() {
        return persistence.getEntityManager()
                .createQuery("SELECT t FROM cubapetclinic$PetType t ORDER BY t.name", PetType.class)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findById(Integer id) {
        return persistence.getEntityManager()
                .createQuery("SELECT p FROM cubapetclinic$Pet p WHERE p.id = :id", Pet.class)
                .setParameter("id", id)
                .getFirstResult();
    }

    @Override
    @Transactional
    public void save(Pet pet) {
        persistence.getEntityManager().persist(pet);
    }
}