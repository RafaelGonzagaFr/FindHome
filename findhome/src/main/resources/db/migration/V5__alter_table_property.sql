-- Adicionando uma restrição de chave estrangeira na tabela `imoveis` para `inquilino`
ALTER TABLE property
ADD CONSTRAINT fk_tenant
FOREIGN KEY (id_tenant)
REFERENCES tenant(id_tenant)
ON DELETE SET NULL;