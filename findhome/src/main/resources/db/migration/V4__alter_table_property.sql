-- Adicionando uma restrição de chave estrangeira na tabela `imoveis` para `proprietario`
ALTER TABLE property
ADD CONSTRAINT fk_owner
FOREIGN KEY (id_owner)
REFERENCES owner(id_owner)
ON DELETE SET NULL;