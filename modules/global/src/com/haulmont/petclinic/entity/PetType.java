package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;
import javax.persistence.UniqueConstraint;

@Table(name = "CUBAPETCLINIC_PET_TYPE", uniqueConstraints = {
    @UniqueConstraint(name = "IDX_CUBAPETCLINIC_PET_TYPE_UNQ", columnNames = {"NAME"})
})
@Entity(name = "cubapetclinic$PetType")
public class PetType extends NamedEntity {
    private static final long serialVersionUID = -4999419471911103408L;

}