# delivery
Dianome Delivery

O software desenvolvido chamado de Dianome Delivery faz requisições para controlar entregadores. 

Os atributos da entidade são: 

cpf;
name;
vehicleCapacity;

Para subir o projeto, basta rodar o *DeliveryApplication.java*.

Localhost do projeto: localhost:8080/delivery/

Banco de dados utilizado: PostgreSQL
Para criação do banco de dados, é necessário criar uma database *delivery* com um usuário de login: admin e senha: admin . 

Caso deseje alterar, fazer alterações no arquivo application.properties

URL das requisições da API:

Post: localhost:8080/delivery/courier/include

GetAll: localhost:8080/delivery/courier/getAll

GetByCPF: localhost:8080/delivery/courier/getByCpf/{cpf}

Put: localhost:8080/delivery/courier/update/{cpf}

Delete: localhost:8080/delivery/courier/delete/{cpf}


