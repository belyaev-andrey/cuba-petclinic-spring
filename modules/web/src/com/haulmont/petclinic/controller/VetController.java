package com.haulmont.petclinic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.haulmont.cuba.core.app.importexport.EntityImportExportService;
import com.haulmont.petclinic.entity.Vet;
import com.haulmont.petclinic.entity.Vets;
import com.haulmont.petclinic.service.EntityJsonXmlExportService;
import com.haulmont.petclinic.service.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;

@RestController
@RequestMapping("/feed")
public class VetController {

    @Inject
    private VetService vetService;

    @Inject
    private EntityJsonXmlExportService importExportService;

    @GetMapping(value = { "/vets.json" }, produces = "application/json")
    public String showJsonVetList() {
        return importExportService.exportEntitiesToJSON(vetService.findAll());
    }

    @GetMapping(value = { "/vets.xml" }, produces = "application/xml")
    public String showXmlVetList() {
        return importExportService.exportEntitiesToXML(vetService.findAll(), "vets");
    }


}
