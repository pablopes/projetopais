insert into "USUARIO"(id,login,senha,nome,administrador) values (SEQ_USUARIO.NEXTVAL,'convidado', 'manager', 'Usuário convidado', 0);
insert into "USUARIO"(id,login,senha,nome,administrador) values (SEQ_USUARIO.NEXTVAL,'admin', 'suporte', 'Gestor', 1);
insert into "PAIS"(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL, 'Brasil', 'BR','Brasileiro');
insert into "PAIS"(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL, 'Argentina','AR', 'Argentino');
insert into "PAIS"(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL, 'Alemanha','AL', 'Alemão');