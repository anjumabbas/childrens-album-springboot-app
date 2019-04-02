    create table CHILD (
        PK bigint identity not null,
        CLIENT_ID varchar(100) not null,
        LAST_UPDATED datetime2,
        NAME varchar(200) not null,
        GENDER varchar(20) not null,
        DOB datetime2 not null,
        primary key (PK)
    );

    create table PICTURE (
        PK bigint identity not null,
        LAST_UPDATED datetime2,
        FILENAME varchar(200) not null,
        GEO_COORDINATES varchar(MAX),
        CHILD_FK bigint;
        primary key (PK)
    );

    alter table PICTURE
        add constraint FK_nrguuorbw1jo5e22fibfsn02o
        foreign key (CHILD_FK)
        references CHILD;