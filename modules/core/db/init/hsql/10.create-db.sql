-- begin CUBAPETCLINIC_SPECIALITY
create table CUBAPETCLINIC_SPECIALITY (
    ID integer not null,
    NAME varchar(255) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_SPECIALITY
-- begin CUBAPETCLINIC_PET_TYPE
create table CUBAPETCLINIC_PET_TYPE (
    ID integer not null,
    NAME varchar(255) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_PET_TYPE
-- begin CUBAPETCLINIC_PET
create table CUBAPETCLINIC_PET (
    ID integer not null,
    NAME varchar(255) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BIRTH_DATE date,
    TYPE_ID integer,
    OWNER_ID integer not null,
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_PET
-- begin CUBAPETCLINIC_VET
create table CUBAPETCLINIC_VET (
    ID integer not null,
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_VET
-- begin CUBAPETCLINIC_OWNER
create table CUBAPETCLINIC_OWNER (
    ID integer not null,
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ADDRESS longvarchar not null,
    CITY longvarchar not null,
    TELEPHONE longvarchar not null,
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_OWNER
-- begin CUBAPETCLINIC_VISIT
create table CUBAPETCLINIC_VISIT (
    ID integer not null,
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    --
    VISIT_DATE timestamp,
    DESCRIPTION longvarchar,
    PET_ID integer not null,
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_VISIT
-- begin CUBAPETCLINIC_VET_SPECIALITY
create table CUBAPETCLINIC_VET_SPECIALITY (
    VET_ID integer not null,
    SPECIALITY_ID integer not null,
    primary key (VET_ID, SPECIALITY_ID)
)^
-- end CUBAPETCLINIC_VET_SPECIALITY
