insert into RECETTE values (next value for RECETTE_SEQ, 'crepe');

insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'farine');
insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'lait');
insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'oeuf');

insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='farine'), 1);
insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='lait'), 1);
insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='oeuf'), 0.5);