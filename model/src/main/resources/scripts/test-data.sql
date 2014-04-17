insert into RECETTE values (next value for RECETTE_SEQ, 'crepe', null, 'DESSERT', 'Mettre la farine dans une terrine et former un puits. Mettre les œufs entiers, le sucre, l''huile et le beurre.Mélanger délicatement avec un fouet en ajoutant au fur et à mesure le lait. La pâte ainsi obtenue doit avoir une consistance d''un liquide légèrement épais. Faire chauffer une poêle anti-adhésive et y déposer quelques gouttes d''huile. Faire cuire les crêpes à feu doux.', 1, 5, true);

insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'farine');
insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'lait');
insert into INGREDIENT values (next value for INGREDIENT_SEQ, 'oeuf');

insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='farine'), 1);
insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='lait'), 1);
insert into RECETTE_INGREDIENT values ((select RECETTE_ID from RECETTE where NOM='crepe'), (select INGREDIENT_ID from INGREDIENT where NOM='oeuf'), 0.5);