drop database noe;
create database noe;
use noe;

create table user
(
    afm         varchar(10) unique not null,
    id_number   varchar(10) unique not null,
    password    varchar(30)        not null,
    amka        varchar(15) unique not null,
    name        varchar(15)        not null,
    surname     varchar(20)        not null,
    father_name varchar(20)        not null,
    phone       varchar(10)        not null,
    email       varchar(30)        not null,
    primary key (amka)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table patient
(
    p_amka         varchar(15),
    ticket         mediumblob,
    dischargeNote  mediumblob,
    medical_record text,
    primary key (p_amka),
    constraint patient_amka foreign key (p_amka) references user (amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table hospital
(
    name           varchar(30),
    address        varchar(50) not null,
    manager        varchar(15),
    on_duty        boolean     not null,
    availableRooms int,
    availableBeds  int,
    primary key (name),
    constraint hospital_manager_amka foreign key (manager) references user (amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table deaths
(
    id          int         not null auto_increment,
    dateOfDeath datetime    not null,
    hospital    varchar(30) not null,
    primary key (id),
    constraint death_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table expenses
(
    id       int         not null auto_increment,
    reason   varchar(50) not null,
    cost     float       not null,
    hospital varchar(30) not null,
    primary key (id),
    constraint expenses_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table employee
(
    e_amka   varchar(15),
    dept     varchar(30),
    hospital varchar(30) not null,
    salary   int         not null,
    primary key (e_amka),
    constraint employee_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade,
    constraint employee_amka foreign key (e_amka) references user (amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table roles
(
    u_amka varchar(15),
    roleId int not null,
    primary key (u_amka, roleId),
    constraint roles_amka foreign key (u_amka) references user (amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table hospitalization
(
    aa             int auto_increment,
    hospital       varchar(30),
    dept           varchar(30),
    patient        varchar(15),
    doc            varchar(15),
    admission_date datetime not null,
    reason         text     not null,
    disease        varchar(50),
    dischargeNote  mediumblob,
    release_date   datetime,
    cost           float    not null,
    paid           boolean  not null,
    payment_date   datetime,
    primary key (aa),
    constraint hospitalization_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade,
    constraint hospitalization_doctor foreign key (doc) references employee (e_amka) on delete cascade on update cascade,
    constraint hospitalization_patient foreign key (patient) references patient (p_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table treatment_cost
(
    aa              int auto_increment,
    hospitalization int,
    reason          varchar(50) not null,
    cost            float       not null,
    primary key (aa),
    constraint treatment_cost_hospitalization foreign key (hospitalization) references hospitalization (aa) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table surgery
(
    aa       int auto_increment,
    hospital varchar(30),
    patient  varchar(15),
    date     datetime,
    primary key (aa),
    constraint surgery_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade,
    constraint surgery_patient foreign key (patient) references patient (p_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table surgery_doctors
(
    surgery int,
    doctor  varchar(15),
    primary key (surgery, doctor),
    constraint surgery_docs_surgery foreign key (surgery) references surgery (aa) on delete cascade on update cascade,
    constraint surgery_docs_doctor foreign key (doctor) references employee (e_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table appointment
(
    aa       int auto_increment,
    patient  varchar(15),
    doctor   varchar(15),
    datetime datetime,
    duration int,
    hospital varchar(30),
    primary key (aa),
    constraint app_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade,
    constraint app_doctor foreign key (doctor) references employee (e_amka) on delete cascade on update cascade,
    constraint app_patient foreign key (patient) references patient (p_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table supply
(
    name  varchar(30),
    price int,
    primary key (name)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table supp_order
(
    aa           int auto_increment,
    supp_manager varchar(15),
    date         datetime,
    delivered    boolean,
    sent         boolean,
    primary key (aa),
    constraint supp_order_supp_manager foreign key (supp_manager) references employee (e_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table supp_order_item
(
    supp_order int,
    supply     varchar(30),
    quantity   int not null,
    primary key (supp_order, supply),
    constraint supp_order_item_supp_order foreign key (supp_order) references supp_order (aa) on delete cascade on update cascade,
    constraint supp_order_item_supply foreign key (supply) references supply (name) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table bod
(
    name    varchar(15) not null,
    surname varchar(20) not null,
    email   varchar(30) not null,
    primary key (email)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table order_settings
(
    setting varchar(20),
    value   varchar(20) not null,
    primary key (setting)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table hospital_supplies
(
    hospital varchar(30),
    supply   varchar(30),
    quantity int,
    primary key (hospital, supply),
    constraint hospital_supplies_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade,
    constraint hospital_supplies_supply foreign key (supply) references supply (name) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table schedule
(
    aa          int auto_increment,
    doctor      varchar(15),
    start       datetime                                                not null,
    end         datetime                                                not null,
    description varchar(40),
    type        enum ('appointment', 'surgery', 'unavailable', 'other') not null,
    primary key (aa),
    constraint schedule_doctor foreign key (doctor) references employee (e_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table evaluation
(
    aa       int auto_increment,
    doctor   varchar(15) not null,
    patient  varchar(15) not null,
    rating   int         not null,
    comments text,
    primary key (aa),
    constraint evaluation_doctor foreign key (doctor) references employee (e_amka) on delete cascade on update cascade,
    constraint evaluation_patient foreign key (patient) references patient (p_amka) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table crypto_key
(
    aa         int auto_increment,
    crypto_key varchar(100) not null,
    primary key (aa)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table hospital_expenses
(
    aa               int auto_increment,
    hospital         varchar(30) not null,
    payroll          float       not null,
    supply_costs     float       not null,
    functional_costs float       not null,
    equipment_costs  float       not null,
    primary key (aa),
    constraint hospital_expenses_hospital foreign key (hospital) references hospital (name) on delete cascade on update cascade
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table application
(
    aa          int auto_increment,
    name        varchar(15) not null,
    surname     varchar(20) not null,
    email       varchar(30) not null,
    application mediumblob  not null,
    evaluated   boolean     not null,
    primary key (aa)
)
    ENGINE = InnoDB
    CHARACTER SET greek
    COLLATE greek_general_ci;

create table login_history
(
    aa                int auto_increment,
    username          varchar(15),
    password          varchar(30),
    one_time_password varchar(10),
    datetime          datetime,
    primary key (aa)
)