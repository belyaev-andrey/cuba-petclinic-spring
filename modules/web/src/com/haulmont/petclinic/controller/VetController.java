package com.haulmont.petclinic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.haulmont.cuba.core.app.importexport.EntityImportExportService;
import com.haulmont.petclinic.entity.Vets;
import com.haulmont.petclinic.service.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@RestController
@RequestMapping("/feed")
public class VetController {

    @Inject
    private VetService vetService;

    @Inject
    private EntityImportExportService importExportService;

    @GetMapping(value = { "/vets.json" }, produces = "application/json")
    public String showJsonVetList() {
        return importExportService.exportEntitiesToJSON(vetService.findAll());
    }

    @GetMapping(value = { "/vets.xml" }, produces = "application/xml")
    public String showXmlVetList() {
        Vets vets = new Vets();
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        try {
            vets.getVetList().addAll(vetService.findAll());
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Vets.class);
            Marshaller m = context.createMarshaller();
            m.marshal(vets, writer);
            result = result.concat(writer.getBuffer().toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }


}
