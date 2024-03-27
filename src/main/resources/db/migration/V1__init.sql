CREATE TABLE IF NOT EXISTS public.cart
(
    id_usr bigint NOT NULL,
    id_item bigint NOT NULL,
    CONSTRAINT cart_pkey PRIMARY KEY (id_usr, id_item)
);

CREATE TABLE IF NOT EXISTS public.item
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    price integer,
    CONSTRAINT item_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.usr
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    login character varying(100) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usr_pkey PRIMARY KEY (id),
    CONSTRAINT login_check UNIQUE (login)
);

ALTER TABLE IF EXISTS public.cart
    ADD CONSTRAINT item_fk FOREIGN KEY (id_item)
        REFERENCES public.item (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.cart
    ADD CONSTRAINT usr_fk FOREIGN KEY (id_usr)
        REFERENCES public.usr (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;