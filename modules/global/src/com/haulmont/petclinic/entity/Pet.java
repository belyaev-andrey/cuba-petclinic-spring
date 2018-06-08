package com.haulmont.petclinic.entity;

import com.haulmont.chile.core.annotations.Composition;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

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

    @Nullable
    public Date getBirthDate() {
        return birthDate;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    @Nullable
    public PetType getType() {
        return type;
    }


}