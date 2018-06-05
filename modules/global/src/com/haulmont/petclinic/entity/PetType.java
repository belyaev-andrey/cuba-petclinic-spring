package com.haulmont.petclinic.entity;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "CUBAPETCLINIC_PET_TYPE")
@Entity(name = "cubapetclinic$PetType")
public class PetType extends NamedEntity {
    private static final long serialVersionUID = -4999419471911103408L;

}