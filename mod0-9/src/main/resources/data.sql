-- Insert collaborators first
INSERT INTO collaborator (name) VALUES ('Cleber');
INSERT INTO collaborator (name) VALUES ('Renato');
INSERT INTO collaborator (name) VALUES ('Renata');

-- Insert animals with collaborator_id
INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('cachorrinho da ebac', 5, 'SRD', current_date, 'Bem pulguento', 1, 'Pequeno', 'cachorro');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('Outro cachorrinho da ebac', 10, 'Rottweiler', current_date, 'Bem velhinho', 1, 'grande', 'cachorro');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('Sleipneir', 10, 'Arabe', current_date, 'saudavel', 2, 'grande', 'cavalo');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('Perseu', 10, 'SRD', current_date, 'boas condicoes', 3, 'pequeno', 'gato');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('kratos', 10, 'SRD', current_date, 'pata quebrada', 3, 'pequeno', 'gato');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, collaborator_id, porte, especie)
VALUES ('aphelios', 10, 'SRD', current_date, 'sem penas', 1, 'pequeno', 'papagaio');
