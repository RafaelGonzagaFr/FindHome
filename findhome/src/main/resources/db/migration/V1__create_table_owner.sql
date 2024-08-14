-- Tabela para Proprietários
CREATE TABLE owner (
    id_owner TEXT PRIMARY KEY UNIQUE NOT NULL,
    owner_name VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);