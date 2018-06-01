package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.petclinic.CubapetclinicTestContainer;
import com.haulmont.petclinic.entity.Visit;
import com.haulmont.petclinic.service.VisitService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;

public class VisitServiceTest {

    @ClassRule
    public static CubapetclinicTestContainer cont = CubapetclinicTestContainer.Common.INSTANCE;

    private Metadata metadata;
    private Persistence persistence;
    private DataManager dataManager;
    private VisitService visitService;

    @Before
    public void setUp() throws Exception {
        metadata = cont.metadata();
        persistence = cont.persistence();
        dataManager = AppBeans.get(DataManager.class);
        visitService = AppBeans.get(VisitService.class);
    }

    @Test
    public void TestFindByPetId(){
        List<Visit> visits = visitService.findByPetId(7);
        Assert.assertNotNull(visits);
        Assert.assertEquals(2, visits.size());
    }

}
