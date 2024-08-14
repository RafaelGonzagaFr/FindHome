-- Tabela para Imóveis
CREATE TABLE property (

    id_property TEXT PRIMARY KEY UNIQUE NOT NULL,
    address VARCHAR(255) NOT NULL,
    id_owner TEXT REFERENCES owner(id_owner) ON DELETE SET NULL,
    id_tenant TEXT REFERENCES tenant(id_tenant) ON DELETE SET NULL
);