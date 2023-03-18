CREATE TABLE evento (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	descricao varchar NOT NULL,
	empresa varchar NOT NULL,
	dt_criacao date NOT NULL,
	CONSTRAINT evento_pk PRIMARY KEY (id)
);

CREATE TABLE tipo_campo (
	id serial NOT NULL,
	tipo varchar NOT NULL,
	CONSTRAINT tipo_campo_pk PRIMARY KEY (id)
);

CREATE TABLE formulario_comum (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	cpf_cnpj varchar NOT NULL,
	email varchar NOT NULL,
	endereco varchar NULL,
	valor numeric NOT NULL,
	id_evento bigint NOT NULL,
	CONSTRAINT formulario_comum_pk PRIMARY KEY (id),
	CONSTRAINT formulario_comum_fk FOREIGN KEY (id_evento) REFERENCES evento(id)
);

CREATE TABLE formulario_especifico (
	id bigserial NOT NULL,
	titulo varchar NOT NULL,
	id_tipo_campo int NOT NULL,
	id_form_comum bigint NOT NULL,
	valor varchar NULL,
	CONSTRAINT formulario_especifico_pk PRIMARY KEY (id),
	CONSTRAINT formulario_especifico_fk FOREIGN KEY (id_form_comum) REFERENCES formulario_comum(id),
	CONSTRAINT formulario_especifico_fk_1 FOREIGN KEY (id_tipo_campo) REFERENCES tipo_campo(id)
);