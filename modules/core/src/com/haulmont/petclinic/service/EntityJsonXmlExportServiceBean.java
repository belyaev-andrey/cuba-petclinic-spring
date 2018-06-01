package com.haulmont.petclinic.service;

import com.haulmont.cuba.core.app.importexport.EntityImportExportService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;

@Service(EntityJsonXmlExportService.NAME)
public class EntityJsonXmlExportServiceBean implements EntityJsonXmlExportService {

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

    protected String jsonToXml(String json, String rootElement) {
        StringBuilder sb = new StringBuilder(json.length());
        Reader is = new StringReader(json);
        JsonParser parser = Json.createParser(is);
        if (parser.hasNext()) {
            sb.append(parseValue(parser, parser.next()));
        }
        return sb.toString();
    }

    private String parseValue(JsonParser parser, Event e) {
        StringBuilder sb = new StringBuilder();
        if (e == Event.KEY_NAME) {
            String s = parser.getString();
            sb.append(String.format("<%s>%s</%s>", s, parseValue(parser, parser.next()), s));
        } else if (e == Event.START_ARRAY) {
            sb.append("<list>");
        } else if (e == Event.START_OBJECT) {
            sb.append("<entity>");
        } else if (e == Event.VALUE_FALSE
                || e == Event.VALUE_TRUE
                || e == Event.VALUE_NUMBER
                || e == Event.VALUE_STRING
                || e == Event.VALUE_NULL) {
            return parser.getString();
        } else if (e == Event.END_ARRAY) {
            sb.append("</list>");
        } else if (e == Event.END_OBJECT) {
            sb.append("</entity>");
        }
        if (parser.hasNext()) {
            return sb.append(parseValue(parser, parser.next())).toString();
        } else {
            return sb.toString();
        }
    }

}