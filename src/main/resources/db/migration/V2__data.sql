INSERT INTO public.usr(login, first_name, last_name)
VALUES ('usr1', 'John', 'Deep'),
       ('usr2', 'Alice', 'Def');

INSERT INTO public.item(name, price)
VALUES ('Макароны', 150),
       ('Котлеты', 104),
       ('Помидоры', 54);

INSERT INTO public.cart(id_usr, id_item)
VALUES (1, 1),
       (1, 2),
       (2, 3);