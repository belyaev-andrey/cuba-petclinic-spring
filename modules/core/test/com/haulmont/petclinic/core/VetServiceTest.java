package com.haulmont.petclinic.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.petclinic.CubapetclinicTestContainer;
import com.haulmont.petclinic.entity.Vet;
import com.haulmont.petclinic.entity.Visit;
import com.haulmont.petclinic.service.VetService;
import com.haulmont.petclinic.service.VisitService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class VetServiceTest {

    @ClassRule
    public static CubapetclinicTestContainer cont = CubapetclinicTestContainer.Common.INSTANCE;

    private Metadata metadata;
    private Persistence persistence;
    private DataManager dataManager;
    private VetService vetService;

    @Before
    public void setUp() throws Exception {
        metadata = cont.metadata();
        persistence = cont.persistence();
        dataManager = AppBeans.get(DataManager.class);
        vetService = AppBeans.get(VetService.class);
    }

    @Test
    public void TestGetAllVets(){
        Collection<Vet> vets = vetService.findAll();
        Assert.assertNotNull(vets);
        Assert.assertTrue(vets.size() > 0);
    }

}
