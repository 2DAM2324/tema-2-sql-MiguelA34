DROP TABLE IF EXISTS animales;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS ver;
DROP TABLE IF EXISTS zonas;
DROP TABLE IF EXISTS trabajadores;

CREATE TABLE clientes(
    dni VARCHAR2(9) PRIMARY KEY,
    nombre VARCHAR2(45),
    anio_nac INTEGER
);

CREATE TABLE trabajadores(
    codigo VARCHAR2(5) PRIMARY KEY,
    nombre VARCHAR2(45),
    numero_telefono VARCHAR2(9),
    gerente VARCHAR2(2)
);

CREATE TABLE zonas(
    id VARCHAR2(5) PRIMARY KEY,
    bioma VARCHAR2(45),
    capacidad INTEGER,
    superficie FLOAT,
    trabajador VARCHAR2(5)
);

CREATE TABLE animales(
    codigo VARCHAR2(5) PRIMARY KEY,
    nombre VARCHAR2(45),
    clase VARCHAR2(45),
    nombre_cientifico VARCHAR2(45),
    anio_nac INTEGER,
    id_zona VARCHAR2(5),
    FOREIGN KEY (id_zona) REFERENCES zonas(id)
);

CREATE TABLE ver(
    cliente VARCHAR2(9),
    cod_animal VARCHAR2(5),
    FOREIGN KEY (cod_animal) REFERENCES animales(codigo),
    FOREIGN KEY (cliente) REFERENCES clientes(dni),
    PRIMARY KEY(cliente, cod_animal)
);

INSERT INTO clientes VALUES ('77994245A', 'Mike', 2001);
INSERT INTO clientes VALUES ('12345678W', 'John', 1989);
INSERT INTO clientes VALUES ('88992244K', 'Ana', 1999);
INSERT INTO clientes VALUES ('11336699L', 'Laura', 2000);
INSERT INTO clientes VALUES ('55695569S', 'Simba', 2010);

INSERT INTO trabajadores VALUES ('Tr001', 'Pepe', '999999999', 'no');
INSERT INTO trabajadores VALUES ('Tr002', 'Juan', '958958958', 'no');
INSERT INTO trabajadores VALUES ('Tr003', 'Francisco', '778811223', 'si');
INSERT INTO trabajadores VALUES ('Tr004', 'Raul', '634578991', 'no');
INSERT INTO trabajadores VALUES ('Tr005', 'Adolfo', '666666666', 'si');
INSERT INTO trabajadores VALUES ('Tr006', 'Felipe', '666333999', 'no');
INSERT INTO trabajadores VALUES ('Tr007', 'Adrian', '111222333', 'si');

INSERT INTO zonas VALUES ('Zn001', 'Jungla', 100, 200, 'Tr001');
INSERT INTO zonas VALUES ('Zn002', 'Selva', 50, 40, 'Tr002');
INSERT INTO zonas VALUES ('Zn003', 'Tundra', 150, 150, 'Tr003');
INSERT INTO zonas VALUES ('Zn004', 'Desierto', 20, 40, 'Tr004');
INSERT INTO zonas VALUES ('Zn005', 'Sabana', 75, 75, 'Tr005');
INSERT INTO zonas VALUES ('Zn006', 'Bosque', 130, 100, 'Tr006');
INSERT INTO zonas VALUES ('Zn007', 'Pantano', 80, 120, 'Tr007');

INSERT INTO animales VALUES ('An001', 'Tigre', 'Mamífero', 'Gatito Grande', 1990, 'Zn001');
INSERT INTO animales VALUES ('An002', 'Panda', 'Mamífero', 'Oso amoroso', 2013, 'Zn002');
INSERT INTO animales VALUES ('An003', 'Pinguino', 'Ave', 'Kowalsky opciones', 2020, 'Zn003');
INSERT INTO animales VALUES ('An004', 'Camello', 'Mamífero', 'Pero no el de mi pueblo', 1972, 'Zn004');
INSERT INTO animales VALUES ('An005', 'Zorro', 'Mamífero', 'Pero no el de la esquina', 2005, 'Zn005');
INSERT INTO animales VALUES ('An006', 'Cocodrilo', 'Reptil', 'Sacamuelas', 2010, 'Zn006');
INSERT INTO animales VALUES ('An007', 'Sapo', 'Anfibio', 'Príncipe', 2020, 'Zn007');

INSERT INTO ver VALUES ('77994245A', 'An001');
INSERT INTO ver VALUES ('12345678W', 'An004');
INSERT INTO ver VALUES ('12345678W', 'An001');
INSERT INTO ver VALUES ('88992244K', 'An002');
INSERT INTO ver VALUES ('11336699L', 'An002');
INSERT INTO ver VALUES ('55695569S', 'An003');
INSERT INTO ver VALUES ('55695569S', 'An007');