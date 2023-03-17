CREATE TABLE public.formulario_comum (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	cpf_cnpj varchar NOT NULL,
	email varchar NOT NULL,
	endereco varchar NOT NULL,
	id_evento bigserial NOT NULL
);