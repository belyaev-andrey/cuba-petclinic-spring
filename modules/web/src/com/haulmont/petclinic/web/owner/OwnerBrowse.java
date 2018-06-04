package com.haulmont.petclinic.web.owner;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction;
import com.haulmont.petclinic.entity.Owner;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import com.haulmont.cuba.gui.components.Component;
import org.slf4j.Logger;

public class OwnerBrowse extends AbstractLookup {

    @Inject
    private Logger log;

    @Inject
    private DataGrid<Owner> ownersTable;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        ownersTable.addAction(new DetailsAction(ownersTable, "details"));

        setUpFullNameColumn();

        setUpPetNamesColumn();

    }

    private void setUpPetNamesColumn() {
        ownersTable.addGeneratedColumn("petNames", new DataGrid.ColumnGenerator<Owner, String>() {

            @Override
            public String getValue(DataGrid.ColumnGeneratorEvent<Owner> event) {
                return event.getItem().getPetNames();
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });
    }

    private void setUpFullNameColumn() {
        DataGrid.Column fullName = ownersTable.addGeneratedColumn("fullName", new DataGrid.ColumnGenerator<Owner, String>() {

            @Override
            public String getValue(DataGrid.ColumnGeneratorEvent<Owner> event) {
                return event.getItem().getFirstName()+" "+event.getItem().getLastName();
            }

            @Override
            public Class<String> getType() {
                return String.class;
            }
        });

        DataGrid.ClickableTextRenderer renderer = ownersTable.createRenderer(DataGrid.ClickableTextRenderer.class);
        renderer.setRendererClickListener(new DataGrid.RendererClickListener() {
            @Override
            public void onClick(DataGrid.RendererClickEvent event) {
                Action action = ownersTable.getAction("details");
                if (action != null) {
                    action.actionPerform(event.getSource());
                }
            }
        });
        fullName.setRenderer(renderer);
    }

    protected class DetailsAction extends ItemTrackingAction {
        public DetailsAction(ListComponent target, String id) {
            super(target, id);
        }

        @Override
        public void actionPerform(Component component) {
            Entity selected = target.getSingleSelected();
            if (selected != null) {
                openEditor(target.getDatasource().getMetaClass().toString()+".view", selected, WindowManager.OpenType.THIS_TAB);
            }
        }
    }
}