drop table RECETTE if exists cascade;
drop table INGREDIENT if exists cascade;
drop table RECETTE_INGREDIENT if exists cascade;
drop sequence RECETTE_SEQ if exists;
drop sequence INGREDIENT_SEQ if exists;

SET DATABASE TEXT TABLE DEFAULTS 'all_quoted=true;encoding=UTF-8;cache_rows=10000;cache_size=2000'

create table RECETTE
(
	RECETTE_ID bigint not null primary key,
	NOM varchar(30) unique,
	IMAGE blob(1M),
	CATEGORIE varchar(30),
	DESCRIPTION longvarchar,
	DIFFICULTE int,
	AVIS int,
	IS_VEGETARIEN boolean
);
create sequence RECETTE_SEQ start with 1 increment by 1;

create table INGREDIENT(
	INGREDIENT_ID bigint not null primary key,
	NOM varchar(30) unique
);
create sequence INGREDIENT_SEQ start with 1 increment by 1;

create table RECETTE_INGREDIENT(
	RECETTE_ID bigint not null references RECETTE(RECETTE_ID),
	INGREDIENT_ID bigint not null references INGREDIENT(INGREDIENT_ID),
	QUANTITE numeric not null,
	primary key (RECETTE_ID, INGREDIENT_ID)
);