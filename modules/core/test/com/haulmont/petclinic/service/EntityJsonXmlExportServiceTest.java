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
            String json = "{\n" +
                    "   \"error\": {\n" +
                    "      \"message\": \"(#10) Application does not have permission for this action\",\n" +
                    "      \"type\": \"OAuthException\",\n" +
                    "      \"code\": 10,\n" +
                    "      \"fbtrace_id\": \"HEFmWcHfDaR\"\n" +
                    "   }\n" +
                    "}";
            String xml = exportService.jsonToXml(json, "");
            System.out.println(xml);
            Assert.assertTrue(xml.length() > 0);

    }


}
