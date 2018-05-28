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

@Table(name = "CUBAPETCLINIC_PET")
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