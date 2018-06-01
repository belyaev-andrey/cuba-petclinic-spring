package com.haulmont.petclinic.service;


import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.View;

import java.util.Collection;

public interface EntityJsonXmlExportService {
    String NAME = "cubapetclinic_EntityXmlExportService";

    String exportEntitiesToJSON(Collection<? extends Entity> entities);

    String exportEntitiesToJSON(Collection<? extends Entity> entities, View view);

    String exportEntitiesToXML(Collection<? extends Entity> entities, String root);

    String exportEntitiesToXML(Collection<? extends Entity> entities, String root, View view);


}