package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.petclinic.CubapetclinicTestContainer;
import com.haulmont.petclinic.entity.Vet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Collection;

public class VetServiceTest {

    @ClassRule
    public static CubapetclinicTestContainer cont = CubapetclinicTestContainer.Common.INSTANCE;

    private VetService vetService;

    @Before
    public void setUp() {
        vetService = AppBeans.get(VetService.class);
    }

    @Test
    public void TestGetAllVets(){
        Collection<Vet> vets = vetService.findAll();
        Assert.assertNotNull(vets);
        Assert.assertTrue(vets.size() > 0);
    }

}
