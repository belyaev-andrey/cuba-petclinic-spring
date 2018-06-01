package com.haulmont.petclinic.controller;

import com.haulmont.petclinic.service.EntityJsonXmlExportService;
import com.haulmont.petclinic.service.VetService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping("/feed")
public class VetController {

    @Inject
    private VetService vetService;

    @Inject
    private EntityJsonXmlExportService importExportService;

    @GetMapping(value = { "/vets.json" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String showJsonVetList() {
        return importExportService.exportEntitiesToJSON(vetService.findAll());
    }

    @GetMapping(value = { "/vets.xml" }, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody String showXmlVetList() {
        return importExportService.exportEntitiesToXML(vetService.findAll(), "vets");
    }


}
