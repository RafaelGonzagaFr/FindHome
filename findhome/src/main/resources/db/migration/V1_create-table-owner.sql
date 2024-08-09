-- Tabela para Proprietários
CREATE TABLE owner (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);