-- Tabela para Imóveis
CREATE TABLE property (

    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    address VARCHAR(255) NOT NULL,
    id_owner INT REFERENCES owner(id) ON DELETE SET NULL,
    id_tenant INT REFERENCES tenant(id) ON DELETE SET NULL
);