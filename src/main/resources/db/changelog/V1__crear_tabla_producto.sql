create table IF NOT EXISTS direcciones
(
    id_direccion int primary key auto_increment,
    calle        varchar(30),
    carrera      varchar(30),
    numero       varchar(30)
);

create table IF NOT EXISTS clientes
(
    cedula_cliente  bigint  primary key,
    nombre           varchar(60),
    primer_apellido  varchar(60),
    segundo_apellido varchar(60),
    id_direccion     int,
    foreign key (id_direccion) references
        direcciones (id_direccion)
);

create table IF NOT EXISTS tipo_telefono
(
    id_tipo_telefono bigint primary key auto_increment,
    nombre           varchar(30)
);

create table IF NOT EXISTS telefono_clientes (
    numero           varchar(30),
    cedula_cliente   bigint,
    id_tipo_telefono bigint,
    primary key (cedula_cliente, id_tipo_telefono),  -- Clave primaria compuesta
    foreign key (cedula_cliente) references clientes (cedula_cliente),
    foreign key (id_tipo_telefono) references tipo_telefono (id_tipo_telefono)
);

create table   IF NOT EXISTS ventas
(
    id_ventas         int primary key auto_increment,
    descripcion       varchar(200),
    fecha             date,
    total             float(5, 2),
    cantidad_producto int,
    impuesto          float(5, 2),
    cedula_cliente    bigint,
    foreign key (cedula_cliente) references clientes (cedula_cliente)
);


create table IF NOT EXISTS tipo_producto
(
    id_tipo_producto int primary key auto_increment,
    descripcion         varchar(120)
);


create table IF NOT EXISTS areas
(
    id_area int primary key auto_increment,
    nombre  varchar(40),
    descripcion varchar(120)
);


create table IF NOT EXISTS productos
(
    id_producto      int primary key auto_increment,
    nombre           varchar(40),
    cantidad         int,
    precio           float,
    id_area          int,
    id_tipo_producto int,
    foreign key (id_area) references areas (id_area),
    foreign key (id_tipo_producto) references tipo_producto (id_tipo_producto)
);


create table IF NOT EXISTS ventas_productos
(
    cantidad    int,
    valor       float(5, 2),
    id_ventas   int,
    id_producto int,
    PRIMARY KEY (id_ventas, id_producto),
    foreign key (id_ventas) references ventas (id_ventas),
    foreign key (id_producto) references productos (id_producto)
);


create table  IF NOT EXISTS proveedores
(
    cedula    varchar(30) primary key,
    nombre    varchar(40),
    rut       varchar(40),
    descuento float(4, 2)
);


create table IF NOT EXISTS estados
(
    id_estado int primary key auto_increment,
    nombre    varchar(30)
);


create table  IF NOT EXISTS operadores
(
    cedula                varchar(40) primary key,
    nombre                varchar(60),
    apellido              varchar(60),
    fecha_nacimiento      date,
    indicador_aislamiento varchar(30)
);


create table IF NOT EXISTS pyps

(
    id_pyp                 int primary key auto_increment,
    cedula                 varchar(30),
    nombre                 varchar(60),
    cantida_recuperaciones int,
    pypcol                 varchar(30)
);


create table  IF NOT EXISTS rotura
(
    id_rotura   int primary key auto_increment,
    descripcion varchar(40),
    fecha       date,
    id_producto int,
    foreign key (id_producto) references productos (id_producto)
);



create table IF NOT EXISTS notas_pedidos
(
    consecutivo    int primary key auto_increment,
    fecha_entrega  date,
    hora_entrega   time,
    novedad        varchar(100),
    cedula_cliente bigint,
    id_estado      int,
    id_pyp         int,
    cedula         varchar(40),
    foreign key (cedula_cliente) references clientes (cedula_cliente),
    foreign key (id_estado) references estados (id_estado),
    foreign key (id_pyp) references pyps (id_pyp),
    foreign key (cedula) references operadores (cedula)
);


create table IF NOT EXISTS notas_productos_pedidos
(
    cantidad    int,
    consecutivo int,
    id_producto int,
    primary key (consecutivo,id_producto),
    foreign key (consecutivo) references notas_pedidos (consecutivo),
    foreign key (id_producto) references productos (id_producto)
);


create table IF NOT EXISTS producto_proveedores
(
    cedula      varchar(30),
    id_producto int,
    cantidad    int,
    costo       decimal(5, 2),
    primary key (cedula, id_producto),
    foreign key (cedula) references proveedores (cedula),
    foreign key (id_producto) references productos (id_producto)
);



