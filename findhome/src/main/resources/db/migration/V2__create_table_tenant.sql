-- Tabela para Inquilinos
CREATE TABLE tenant (
    id_tenant TEXT PRIMARY KEY UNIQUE NOT NULL,
    tenant_name VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
