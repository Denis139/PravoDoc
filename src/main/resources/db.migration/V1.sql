CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE family_enum AS ENUM ('Dissolution of marriage', 'Recognition of marriage as invalid', 'Division of jointly acquired property',
    'Cancellation of the marriage contract', 'Collection of alimony', 'Establishment of paternity',
    'Deprivation of parental rights', 'Restoration of parental rights');

CREATE TYPE land_enum AS ENUM ('Recognition of the right to a land plot', 'Relinquishment of rights to a land plot',
    'Change or termination of land legal relations', 'Compensation for losses and harm',
    'Termination or change of land relations', 'Determination of the boundaries of the site', 'Restoration of the boundaries of the site',
    'Challenge of survey results', 'Correction of cadastral error');

CREATE TYPE estate_enum AS ENUM ('Challenge of transactions', 'Recognition of a transaction not concluded', 'Recognition of a transaction as illegal'
    'Compulsory registration of the transfer of ownership', 'Real estate arbitration dispute', 'Dispute under the contract of sale_purchase');

CREATE TYPE property_enum AS ENUM ('Recognition of ownership of property', 'Division of property', 'Allocation of a share in property',
    'Claiming property from other persons', 'Determining the procedure for using property',
    'Removal of obstacles in the use of property', 'Ease', 'Recognition of the transaction as invalid');

CREATE TYPE legacy_enum AS ENUM ('Restoration of the term for accepting the inheritance', 'Recognition by those who accepted the inheritance',
    'Establishment of the fact of acceptance of the inheritance', 'Establishment of the right of ownership of the inherited property', 'Challenge of the will',
    'Inclusion of property in the estate', 'Allocation of the mandatory share', 'Recognition as an unworthy heir');

CREATE TYPE debt_enum AS ENUM ('Collection of funds from the debtor', 'Declaration of the debtor bankrupt', 'Collection of a penalty',
    'Collection of interest');

CREATE TYPE insurance_enum AS ENUM('Intentional delay in payment', 'Legal action by the Insurer against the client',
    'Bankruptcy of an insurance company', 'Deliberate underestimation of compensation payments', 'Illegal termination of an insurance contract',
    'Rejection of insurance payments', 'Refusal to accept documents');


CREATE TABLE IF NOT EXISTS family_disputes
(
    id          uuid    default uuid_generate_v4()   not null
          constraint family_disputes_pkey
                primary key,
    name        varchar                              not null,
    variety     family_enum                          not null,
    price       decimal                              not null,
    created_at  timestamp default now()              not null,
    updated_at  timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS land_disputes
(
   id           uuid     default uuid_generate_v4()  not null
          constraint land_disputes_pkey
                primary key,
   name         varchar                              not null,
   variety      land_enum                            not null,
   price        decimal                              not null,
   created_at   timestamp default now()              not null,
   updated_at   timestamp default  now()             not null
);

CREATE TABLE IF NOT EXISTS estate_disputes
(
  id            uuid    default  uuid_generate_v4()  not null
         constraint estate_disputes_pkey
                primary key,
  name          varchar                              not null,
  variety       estate_enum                          not null,
  price         decimal                              not null,
  created_at    timestamp default now()              not null,
  updated_at    timestamp default  now()             not null
);

CREATE TABLE IF NOT EXISTS property_disputes
(
  id            uuid    default  uuid_generate_v4()  not null
            constraint movable_disputes_pkey
                primary key,
  name          varchar                              not null,
  variety       property_enum                        not null,
  price         decimal                              not null,
  created_at    timestamp default now()              not null,
  updated_at    timestamp default  now()             not null
);

CREATE TABLE IF NOT EXISTS legacy_disputes
(
  id            uuid    default  uuid_generate_v4()  not null
           constraint land_disputes_pkey
                primary key,
  name          varchar                              not null,
  variety       land_enum                            not null,
  price         decimal                              not null,
  created_at    timestamp default now()              not null,
  updated_at    timestamp default  now()             not null
);

CREATE TABLE IF NOT EXISTS debt_disputes
(
  id            uuid  default uuid_generate_v4()     not null
            constraint debt_disputes_pkey
                primary key,
  name          varchar                              not null,
  variety       debt_enum                            not null,
  price         decimal                              not null,
  created_at    timestamp default now()              not null,
  updated_at    timestamp default  now()             not null
);

CREATE TABLE IF NOT EXISTS insurance_disputes
(
 id             uuid   default  uuid_generate_v4()   not null
           constraint insurance_disputes_pkey
                primary key,
 name           varchar                              not null,
 variety        insurance_enum                       not null,
 price          decimal                              not null,
 created_at     timestamp default now()              not null,
 updated_at     timestamp default  now()             not null
);