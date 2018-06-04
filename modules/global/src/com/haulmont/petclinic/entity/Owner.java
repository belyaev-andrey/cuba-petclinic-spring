package com.haulmont.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.OneToMany;
import javax.persistence.Index;

import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "CUBAPETCLINIC_OWNER", indexes = {
    @Index(name = "IDX_CUBAPETCLINIC_OWNER", columnList = "LAST_NAME")
})
@Entity(name = "cubapetclinic$Owner")
public class Owner extends Person {
    private static final long serialVersionUID = 5083686200770406509L;

    @NotNull
    @Lob
    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @NotNull
    @Lob
    @Column(name = "CITY", nullable = false)
    protected String city;

    @Pattern(regexp = "\\d{10}")
    @NotNull
    @Lob
    @Column(name = "TELEPHONE", nullable = false)
    protected String telephone;

    @OneToMany(mappedBy = "owner")
    protected List<Pet> pets;

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public String getPetNames() {
        return pets.stream().map(Pet::getName).collect(Collectors.joining(", "));
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }


}