create database blog;

use blog;

create table grupo(
	idGrupo int not null auto_increment primary key,
    nombre varchar(50)
);

create table usuario(
	idUsuario int not null auto_increment primary key,
    nombre varchar(50) not null,
    apellido varchar(50) ,
    contrasenia varchar(50)not null,
    correo varchar(50) not null unique,
    idGrupo int not null,
    foreign key (idGrupo) references grupo(idGrupo)
);

create table permiso(
	idPermiso int not null auto_increment primary key,
    nombre varchar(50)
);

create table grupo_permiso(
	idGrupo int not null,
    idPermiso int not null,
    foreign key (idGrupo) references grupo(idGrupo),
    foreign key (idPermiso) references  permiso(idPermiso)
);

create table if not exists categoria(
	idCategoria int not null auto_increment primary key,
    nombre varchar(50) not null,
    descripcion varchar(100) not null,
    fecha datetime default now(),
    categoriaSuperior int,
    foreign key (categoriaSuperior) references categoria(idCategoria)
);

create table if not exists post(
	idPost int not null auto_increment  primary key,
    titulo varchar(100) not null,
    slug varchar(75) not null,
    extracto varchar (50),
    imagenDestacada varchar(255) not null,
    tipo varchar(50) not null,
    idCategoria int not null,
    idUsuario int not null,
    foreign key (idCategoria) references categoria(idCategoria),
    foreign key (idUsuario) references usuario(idUsuario)
);

create table if not exists contenido(
	idContenido int not null auto_increment primary key,
    tipo varchar(50) not null,
    contenido varchar(50) not null,
    idPost int not null,
    foreign key (idPost) references post(idPost)
);

create table if not exists post_metadata(
	idPostMetadata int not null auto_increment primary key,
    clave varchar(500),
    valor varchar(500),
    tipo varchar(50),
    idPost int not null,
    foreign key (idPost) references post(idPost)
);

create table if not exists comentario(
	idComentario int not null auto_increment primary key,
    comentario varchar(500) not null,
    idPost int not null,
    idUsuario int not null,
    respuesta int not null,
    fecha datetime default now(),
    foreign key (idPost) references post(idPost),
    foreign key (idUsuario) references usuario(idUsuario),
    foreign key (respuesta) references comentario(idComentario)
);

create table if not exists usuario_metadata(
	idUsuarioMetadata int not null auto_increment primary key,
    clave varchar(500),
    valor varchar(500),
    tipo varchar(50),
    idUsuario int not null,
    foreign key (idUsuario) references usuario(idUsuario)
);