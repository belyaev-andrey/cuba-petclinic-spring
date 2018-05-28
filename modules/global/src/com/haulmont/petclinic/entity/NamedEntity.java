package com.haulmont.petclinic.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;

@MappedSuperclass
public class NamedEntity extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 3471875190195059470L;

    @Lob
    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}