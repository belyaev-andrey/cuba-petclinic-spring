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
    public void TestJsonToXml(){
            String json = "[\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"1\",\n" +
                    "    \"firstName\": \"James\",\n" +
                    "    \"lastName\": \"Carter\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": []\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"2\",\n" +
                    "    \"firstName\": \"Helen\",\n" +
                    "    \"lastName\": \"Leary\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": [\n" +
                    "      {\n" +
                    "        \"_entityName\": \"cubapetclinic$Speciality\",\n" +
                    "        \"id\": \"1\",\n" +
                    "        \"name\": \"radiology\",\n" +
                    "        \"version\": 1\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"3\",\n" +
                    "    \"firstName\": \"Linda\",\n" +
                    "    \"lastName\": \"Douglas\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": [\n" +
                    "      {\n" +
                    "        \"_entityName\": \"cubapetclinic$Speciality\",\n" +
                    "        \"id\": \"2\",\n" +
                    "        \"name\": \"surgery\",\n" +
                    "        \"version\": 1\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_entityName\": \"cubapetclinic$Speciality\",\n" +
                    "        \"id\": \"3\",\n" +
                    "        \"name\": \"dentistry\",\n" +
                    "        \"version\": 1\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"4\",\n" +
                    "    \"firstName\": \"Rafael\",\n" +
                    "    \"lastName\": \"Ortega\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": [\n" +
                    "      {\n" +
                    "        \"_entityName\": \"cubapetclinic$Speciality\",\n" +
                    "        \"id\": \"2\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"5\",\n" +
                    "    \"firstName\": \"Henry\",\n" +
                    "    \"lastName\": \"Stevens\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": [\n" +
                    "      {\n" +
                    "        \"_entityName\": \"cubapetclinic$Speciality\",\n" +
                    "        \"id\": \"1\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"_entityName\": \"cubapetclinic$Vet\",\n" +
                    "    \"id\": \"6\",\n" +
                    "    \"firstName\": \"Sharon\",\n" +
                    "    \"lastName\": \"Jenkins\",\n" +
                    "    \"version\": 1,\n" +
                    "    \"specialities\": []\n" +
                    "  }\n" +
                    "]";
            String xml = exportService.jsonToXml(json, "");
            System.out.println(xml);
            Assert.assertTrue(xml.length() > 0);

    }


}
