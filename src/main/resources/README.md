README

1. ## MONGODB INSTALL
a. # *INSTALL MONGODB* 
b. Introducir mongos como path(Windows 11): configuraci�n->informaci�n ->Sistema->Configuraci�n avanzada del sistema->variables de entorno->PATH->editar: a�adir ruta acceso a mongos (C:\Program Files\MongoDB)
c. OPEN MONGODB SHELL
d. Write in console: �use skins�
e. CREATE USER:  
db.createUser({
    user: "admin_challenge",
    pwd: "BYBcMJEEWw5egRUo",
    roles: [
      { role: "dbOwner", db: "skins" }
    ]
  });

