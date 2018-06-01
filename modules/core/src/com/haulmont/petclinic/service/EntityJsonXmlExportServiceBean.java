package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.app.importexport.EntityImportExportService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.View;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;

@Service(EntityJsonXmlExportService.NAME)
public class EntityJsonXmlExportServiceBean implements EntityJsonXmlExportService {

    private String defaultTagName = "entity";

    @Inject
    private EntityImportExportService importExportService;

    @Override
    public String exportEntitiesToJSON(Collection<? extends Entity> entities) {
        return importExportService.exportEntitiesToJSON(entities);
    }

    @Override
    public String exportEntitiesToJSON(Collection<? extends Entity> entities, View view) {
        return importExportService.exportEntitiesToJSON(entities, view);
    }

    @Override
    public String exportEntitiesToXML(Collection<? extends Entity> entities, String root) {
        return jsonToXml(importExportService.exportEntitiesToJSON(entities), root);
    }

    @Override
    public String exportEntitiesToXML(Collection<? extends Entity> entities, String root, View view) {
        return jsonToXml(importExportService.exportEntitiesToJSON(entities, view), root);
    }

    protected String jsonToXml(String jsonString, String rootElement) {
        JSONArray json = new JSONArray(jsonString);
        StringBuilder sb = new StringBuilder(jsonString.length());
        sb.append(String.format("<%s>", rootElement));
        for (Object aJson : json) {
            String tagName = this.defaultTagName;
            try {
                JSONObject obj = (JSONObject)aJson;
                Object entityClass = obj.get("_entityName");
                if (entityClass != null){
                    String[] name = entityClass.toString().split("\\$");
                    tagName = name[name.length-1];
                }
            } catch (JSONException e) {
                //OK, we don't get entity name so we will use default
            }
            sb.append(XML.toString(aJson, tagName));
        }
        return sb.append(String.format("</%s>", rootElement)).toString();
    }

    protected String getDefaultTagName() {
        return defaultTagName;
    }

    protected void setDefaultTagName(String defaultTagName) {
        this.defaultTagName = defaultTagName;
    }

}