package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.Composition;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Index;

@Table(name = "CUBAPETCLINIC_PET", indexes = {
    @Index(name = "IDX_CUBAPETCLINIC_PET", columnList = "NAME")
})
@Entity(name = "cubapetclinic$Pet")
public class Pet extends NamedEntity {
    private static final long serialVersionUID = -6580371108882844267L;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    protected Date birthDate;

    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    protected PetType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OWNER_ID")
    protected Owner owner;

    @OneToMany(mappedBy = "pet")
    protected List<Visit> visits;

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Visit> getVisits() {
        return visits;
    }


    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public PetType getType() {
        return type;
    }


}