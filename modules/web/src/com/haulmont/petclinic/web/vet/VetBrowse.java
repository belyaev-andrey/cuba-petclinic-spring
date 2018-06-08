package com.haulmont.petclinic.web.vet;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.petclinic.entity.Vet;
import com.haulmont.petclinic.service.EntityJsonXmlExportService;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

public class VetBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<Vet, Integer> vetsDs;

    @Inject
    ComponentsFactory componentsFactory;

    @Inject
    ExportDisplay exportDisplay;

    @Inject
    private EntityJsonXmlExportService importExportService;


    public Component generateSpecialitiesCell(Vet entity) {
        Label label =  componentsFactory.createComponent(Label.class);
        label.setValue(entity.getSpecialitiesNames());
        return label;
    }

    public void onXmlDownloadClick() {
        byte[] vetsBytes = importExportService.exportEntitiesToXML(vetsDs.getItems(), "vets").getBytes(StandardCharsets.UTF_8);
        exportDisplay.show(new ByteArrayDataProvider(vetsBytes), "vets.xml", ExportFormat.XML);

    }

    public void onJsonDownloadClick() {
        byte[] vetsBytes = importExportService.exportEntitiesToJSON(vetsDs.getItems()).getBytes(StandardCharsets.UTF_8);
        exportDisplay.show(new ByteArrayDataProvider(vetsBytes), "vets.json", ExportFormat.JSON);
    }
}