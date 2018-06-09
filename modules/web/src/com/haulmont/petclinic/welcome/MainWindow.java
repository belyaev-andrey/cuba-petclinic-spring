package com.haulmont.petclinic.welcome;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import java.util.Map;

public class MainWindow extends AppMainWindow {


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initPoweredByLink();
    }

    private void initPoweredByLink() {
        Component poweredByLink = getComponent("poweredByLink");
        if (poweredByLink != null) {
            poweredByLink.setVisible(webConfig.getLoginDialogPoweredByLinkVisible());
        }
    }

}