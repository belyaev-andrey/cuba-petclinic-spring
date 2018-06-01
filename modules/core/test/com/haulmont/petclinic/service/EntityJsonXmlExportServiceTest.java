package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.petclinic.CubapetclinicTestContainer;
import com.haulmont.petclinic.entity.Vet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.Collection;

public class EntityJsonXmlExportServiceTest {

    private EntityJsonXmlExportServiceBean exportService;

    @Before
    public void setUp() throws Exception {
        exportService = new EntityJsonXmlExportServiceBean();

    }

    @Test
    public void TestJsonToXml() {
        String json = "[" +
                "  {" +
                "    '_entityName': 'cubapetclinic$Vet'," +
                "    'id': '1'," +
                "    'firstName': 'James'," +
                "    'lastName': 'Carter'," +
                "    'version': 1," +
                "    'specialities': []" +
                "  }," +
                "  {" +
                "    '_entityName': 'cubapetclinic$Vet'," +
                "    'id': '2'," +
                "    'firstName': 'Helen'," +
                "    'lastName': 'Leary'," +
                "    'version': 1," +
                "    'specialities': [" +
                "      {" +
                "        '_entityName': 'cubapetclinic$Speciality'," +
                "        'id': '1'," +
                "        'name': 'radiology'," +
                "        'version': 1" +
                "      }" +
                "    ]" +
                "  } " +
                "]";
        System.out.println(json);
        String xml = exportService.jsonToXml(json, "vets");
        System.out.println(xml);
        Assert.assertTrue(xml.length() > 0);

    }


}
