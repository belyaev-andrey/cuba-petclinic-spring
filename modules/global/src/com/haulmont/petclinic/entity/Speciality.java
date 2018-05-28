package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CUBAPETCLINIC_SPECIALITY")
@Entity(name = "cubapetclinic$Speciality")
public class Speciality extends NamedEntity {
    private static final long serialVersionUID = 8874794848295540277L;

}