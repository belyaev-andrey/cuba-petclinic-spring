package com.haulmont.petclinic.web.owner;

import com.haulmont.cuba.core.entity.IdProxy;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.petclinic.entity.Owner;
import com.haulmont.petclinic.entity.Pet;
import com.haulmont.petclinic.entity.Visit;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class OwnerView extends AbstractEditor<Owner> {

    @Inject
    private Metadata metadata;

    @Inject
    private Datasource<Owner> ownerDs;

    @Inject
    private CollectionDatasource<Pet, IdProxy<Integer>> petsDs;

    @Inject
    private CollectionDatasource<Visit, IdProxy<Integer>> visitsDs;

    @Inject
    private DataGrid<Pet> petGrid;

    @Inject
    private Label ownerValue;

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private Logger log;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        ownerDs.addItemChangeListener(e -> {
            Owner item = e.getItem();
            ownerValue.setValue(item != null ? item.getFullName() : null);
        });

        DataGrid.Column petData = petGrid.addGeneratedColumn("petData", new DataGrid.ColumnGenerator<Pet, String>() {
            @Override
            public String getValue(DataGrid.ColumnGeneratorEvent<Pet> event) {
                return "<table>" +
                        "<tr><td>Name</td><td>" + event.getItem().getName() + "</td></tr>" +
                        "<tr><td>Birth Date</td><td>" + event.getItem().getBirthDate() + "</td></tr>" +
                        "<tr><td>Type</td><td>" + event.getItem().getType().getName() + "</td></tr>" +
                        "</table>";
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });
        petData.setRenderer(petGrid.createRenderer(DataGrid.HtmlRenderer.class));
    }

    public void onEditOwnerBtnClick() {
        openEditor(ownerDs.getItem(), WindowManager.OpenType.DIALOG);
    }

    public void onAddPetCaptionClick() {
        Pet pet = metadata.create(Pet.class);
        pet.setOwner(ownerDs.getItem());
        openEditor(pet, WindowManager.OpenType.DIALOG, new HashMap<>(), petsDs);
    }

    public void onEditPetLinkClick() {
        openEditor(petsDs.getItem(), WindowManager.OpenType.DIALOG, new HashMap<>(), petsDs);
    }

    public void onAddVisitLinkClick() {
        Visit visit = metadata.create(Visit.class);
        visit.setPet(petsDs.getItem());
        openEditor(visit, WindowManager.OpenType.DIALOG, new HashMap<>(), visitsDs);
    }
}