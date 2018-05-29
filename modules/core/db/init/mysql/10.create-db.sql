-- begin CUBAPETCLINIC_SPECIALITY
create table CUBAPETCLINIC_SPECIALITY (
    ID int auto_increment,
    NAME varchar(255) not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_SPECIALITY
-- begin CUBAPETCLINIC_PET_TYPE
create table CUBAPETCLINIC_PET_TYPE (
    ID int auto_increment,
    NAME varchar(255) not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_PET_TYPE
-- begin CUBAPETCLINIC_PET
create table CUBAPETCLINIC_PET (
    ID int auto_increment,
    NAME varchar(255) not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
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
    ID int auto_increment,
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_VET
-- begin CUBAPETCLINIC_OWNER
create table CUBAPETCLINIC_OWNER (
    ID int auto_increment,
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    ADDRESS longtext not null,
    CITY longtext not null,
    TELEPHONE longtext not null,
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_OWNER
-- begin CUBAPETCLINIC_VISIT
create table CUBAPETCLINIC_VISIT (
    ID int auto_increment,
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    VERSION integer not null default 1,
    --
    VISIT_DATE datetime(3),
    DESCRIPTION longtext,
    PET_ID integer not null,
    --
    primary key (ID)
)^
-- end CUBAPETCLINIC_VISIT
-- begin CUBAPETCLINIC_VET_SPECIALITY
create table CUBAPETCLINIC_VET_SPECIALITY (
    VET_ID integer,
    SPECIALITY_ID integer,
    primary key (VET_ID, SPECIALITY_ID)
)^
-- end CUBAPETCLINIC_VET_SPECIALITY
