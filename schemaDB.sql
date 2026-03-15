DROP DATABASE IF EXISTS hrproject;
CREATE DATABASE hrproject;
USE hrproject;

CREATE TABLE cargos (
    codCargo INT auto_increment PRIMARY KEY,
    nomeCargo VARCHAR(100) NOT NULL,
    salario DOUBLE NOT NULL,
    isLideranca BOOLEAN NOT NULL
);

INSERT INTO cargos (nomeCargo, salario, isLideranca) VALUES 
('CEO', 40000.00, TRUE),
('Gerente', 16000.00, TRUE),
('Supervisor', 6000.00, TRUE),
('Coordenador', 4000.00, TRUE),
('Balconista', 2100.00, FALSE),
('Vendedor', 1900.00, FALSE),
('Auxiliar de Limpeza', 1400.00, FALSE);

CREATE TABLE accountEmployee (
	idAccount INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL, 
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE employee (
	idEmployee INT AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(255) NOT NULL,
    salario DOUBLE NOT NULL,
    horasTrab DOUBLE NOT NULL,
    valorHoraExtra DOUBLE NOT NULL,
    contract VARCHAR(20) NOT NULL,
    dataAdmissao DATE NOT NULL,
    isAtivo BOOLEAN NOT NULL, 
    idCargo INT NOT NULL,
    idAccount INT NOT NULL,
    
    FOREIGN KEY (idCargo) REFERENCES cargos(codCargo),
    FOREIGN KEY (idAccount) REFERENCES accountEmployee(idAccount)
);

-- -------------------------------------------------------------------------
-- INSERÇÃO DO USUÁRIO ADMINISTRADOR PADRÃO (SEEDING)
-- -------------------------------------------------------------------------


INSERT INTO accountEmployee (login, senha) 
VALUES ('admin', 'admin123');


INSERT INTO employee (nome, salario, horasTrab, valorHoraExtra, contract, dataAdmissao, isAtivo, idCargo, idAccount) 
VALUES (
    'Administrador Master', 
    40000.00,        -- Salário base do CEO
    0.0,             -- Horas Trabalhadas iniciais
    0.0,             -- Valor de Hora Extra inicial
    'CLT',           -- Regime de contratação (deve bater exatamente com o Enum no Java)
    CURDATE(),       -- Pega a data atual do banco de dados para a admissão
    TRUE,            -- isAtivo = 1
    1,               -- idCargo (1 = CEO, definido na tabela cargos)
    1                -- idAccount (1 = a conta 'admin' que acabamos de criar acima)
);


