package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;
import javax.persistence.UniqueConstraint;

@NamePattern("%s|name")
@Table(name = "CUBAPETCLINIC_SPECIALITY", uniqueConstraints = {
    @UniqueConstraint(name = "IDX_CUBAPETCLINIC_SPECIALITY_UNQ", columnNames = {"NAME"})
})
@Entity(name = "cubapetclinic$Speciality")
public class Speciality extends NamedEntity {
    private static final long serialVersionUID = 8874794848295540277L;



}