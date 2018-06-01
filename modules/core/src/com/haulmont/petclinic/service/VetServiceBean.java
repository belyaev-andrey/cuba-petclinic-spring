package com.haulmont.petclinic.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.sys.CubaXStream;
import com.haulmont.petclinic.entity.Vet;
import com.haulmont.petclinic.entity.Vets;
import com.thoughtworks.xstream.XStream;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Collection;

@Service(VetService.NAME)
public class VetServiceBean implements VetService {

    @Inject
    private DataManager dataManager;

    @Override
    @Cacheable("vets")
    public Collection<Vet> findAll() {
        LoadContext<Vet> vets = LoadContext.create(Vet.class)
                .setQuery(LoadContext.createQuery("select v from cubapetclinic$Vet v"))
                .setView("vet-specialities-view");
        return dataManager.loadList(vets);
    }

    @Override
    public String vetsToXml(Collection<Vet> vets){
        String str = "";
        XmlMapper mapper = new XmlMapper();
        try {
            str = mapper.writeValueAsString(vets);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        XStream stream = new CubaXStream();
//        String str = stream.toXML(vets);
        return str;
    }
}