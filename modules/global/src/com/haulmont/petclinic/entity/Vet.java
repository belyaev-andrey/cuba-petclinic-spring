package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.HasUuid;
import javax.persistence.Column;
import java.util.UUID;
import java.util.Date;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import javax.persistence.Index;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamePattern("Vet  |")
@Table(name = "CUBAPETCLINIC_VET", indexes = {
    @Index(name = "IDX_CUBAPETCLINIC_VET", columnList = "LAST_NAME")
})
@Entity(name = "cubapetclinic$Vet")
public class Vet extends Person {
    private static final long serialVersionUID = -7775264081971359062L;

    @JoinTable(name = "CUBAPETCLINIC_VET_SPECIALITY",
        joinColumns = @JoinColumn(name = "VET_ID"),
        inverseJoinColumns = @JoinColumn(name = "SPECIALITY_ID"))
    @ManyToMany
    protected Set<Speciality> specialities;


    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }


}