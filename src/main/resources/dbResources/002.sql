INSERT INTO USUARIO ("rut", "dv", "nombre_completo","apellidos","email", "password",
                     "username", "telefono")
values (11111111, 1, 'Milka', 'Forrich', 'milka.forrich@gmail.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'admin', 11222333);

INSERT INTO USUARIO_ROL ("rut", id_rol) VALUES (11111111, 1);