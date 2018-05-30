package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.petclinic.entity.Visit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service(VisitService.NAME)
public class VisitServiceBean implements VisitService {

    @Inject
    private Persistence persistence;

    @Override
    public void save(Visit visit) {
        persistence.getEntityManager().persist(visit);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Visit> findByPetId(Integer petId) {
        return persistence.getEntityManager()
                .createQuery("select v from cubapetclinic$Visit v where v.pet.id = :id", Visit.class)
                .setParameter("id", petId)
                .getResultList();
    }
}