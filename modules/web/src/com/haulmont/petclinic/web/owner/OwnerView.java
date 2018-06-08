package com.haulmont.petclinic.web.owner;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.petclinic.entity.Owner;
import com.haulmont.petclinic.entity.Pet;
import com.haulmont.petclinic.entity.PetType;
import com.haulmont.petclinic.entity.Visit;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class OwnerView extends AbstractEditor<Owner> {

    @Inject
    private Metadata metadata;

    @Inject
    private Datasource<Owner> ownerDs;

    @Inject
    private CollectionDatasource<Pet, Integer> petsDs;

    @Inject
    private CollectionDatasource<Visit, Integer> visitsDs;

    @Inject
    private DataGrid<Pet> petGrid;

    @Inject
    private Label ownerValue;

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
                Pet pet = event.getItem();
                PetType petType = pet.getType();
                Date bd = pet.getBirthDate();

                return "<table>" +
                        "<tr><td>Name</td><td>" + pet.getName() + "</td></tr>" +
                        "<tr><td>Birth Date</td><td>" + (bd == null? "N/A" : DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(pet.getBirthDate())) + "</td></tr>" +
                        "<tr><td>Type</td><td>" + (petType != null ? petType.getName() : "") + "</td></tr>" +
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
        openEditor(pet, WindowManager.OpenType.DIALOG, Collections.emptyMap(), petsDs).addCloseWithCommitListener(() -> {
            petsDs.commit();
        });
    }

    public void onEditPetLinkClick() {
        openEditor(petsDs.getItem(), WindowManager.OpenType.DIALOG, Collections.emptyMap(), petsDs).addCloseWithCommitListener(() -> {
            petsDs.commit();
        });
    }

    public void onAddVisitLinkClick() {
        Visit visit = metadata.create(Visit.class);
        visit.setPet(petsDs.getItem());
        openEditor(visit, WindowManager.OpenType.DIALOG, Collections.emptyMap(), visitsDs).addCloseWithCommitListener(() -> {
            visitsDs.commit();
        });
    }
}