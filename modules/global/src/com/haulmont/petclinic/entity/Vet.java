package com.haulmont.petclinic.entity;

import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamePattern("Vet %s %s |firstName,lastName")
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


    public String getFullName(){
        return String.format("%s %s", getFirstName(), getLastName());
    }
}