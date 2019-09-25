# Projeto Sistema de Vendas
- [Requisitos](#requisitos)
- [Dependências do Projeto](#dependencias-do-Projeto)
- [Configurações](#configurações)
    - [Git](#git)
    - [Backend (API)](#backend)
        - [Estrutura](#estrutura)
            - [Docker](#docker)
            - [Properties Yml](#properties-yml)
            - [Database](#database)
            - [Url Acesso](#url-acesso)
- [Pendências](#pendencias)


## Requisitos

Para desenvolvimento e utilização do projeto são necessárias as seguintes dependências: 

- [Git](https://git-scm.com/): Disponibiliza o Git na máquina, incluindo o utilitário Git Bash, usado para executar os scrips do projeto  
- [Spring BOOT](https://spring.io/): Utilitário Java, com ferramentas necessárias para execução, build do *backend*
- [Maven](https://maven.apache.org/): Controle de dependências para projetos em Java.

## Dependências do Projeto

Dependências necessárias para levantar o projeto:

 ```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.10</version>
			<scope>provided</scope>
		</dependency>
			<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>5.4.4.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.4.Final</version>
		</dependency>
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>2.3.0</version>
		</dependency>
		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>1.3.0.Final</version>
		</dependency>
 ```
## Configurações

Essa seção detalha as configurações necessárias para criar um ambiente de desenvolvimento local.

### Git

Para clonar o projeto acesse a url **https://github.com/georgesuporte/spring-vendas**. Após **autenticação**, utilizando as credenciais de acesso utilize o comando abaixo:

Usando http:

```sh
   git clone  https://github.com/georgesuporte/spring-vendas.git
```

Utilizando ssh:

```sh
   git clone git@github.com:georgesuporte/spring-vendas.git
```

*Obs*: Para gerar a chave de ssh, abra o console git bash e execute o seguinte comando:

```sh
    ssh-keygen -o -t rsa -b 4096 -C "informeseuemail@example.com"    
```
É possível no momento de gerar a chave, apresente algumas opções de configuração. Tecle **Enter** em todas.

```sh
  Enter file in which to save the key (/c/Users/SEU-USUARIO-WINDOWS/.ssh/id_rsa ou c:\Users\SEU-USUARIO-WINDOWS\.ssh\id_rsa):
  Enter passphrase (empty for no passphrase):
  Enter same passphrase again:
```
Após gerar a chave, acesse a pasta .ssh em seu perfil de usuário (/c/Users/SEU-USUARIO-WINDOWS/.ssh ou c:\Users\SEU-USUARIO-WINDOWS\.ssh) através do proprio console do git bash e execute o comando **cat id_rsa.pub**. selecione toda a chave iniciando de ssh-rsa efetuando em seguida faça a cópia. Retorne ao gitlab da Odontoprev e após autenticação, selecione seu perfil e clique em settings. Na opção do menu clique em **SSH Keys**, cole sua chave no textbox **key** e adicione.

```sh
**Exemplo** de chave gerada:

ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQCmGZd9GeR4ZKciKN/kOS32zefv8gH1XsSokAkOG+iw7Q2d9zt6w9n0McRrCT3tvwmA6upvz20sXRaamQB8P0nNX7YG1XS4BzoiO66sgssEQJCQym+HnTry3oC0xdeB/zckVyDB4CfFZb0QFKfEVVoR308qofc9nrL6XogkpChrPOrNGRq0T69c3i9YGCkYYcH+r4AGXx9WPKfDHQgay+M25kFtBUDZxaJlp4xn1qDnS4+nEE/1KX8+x3Sr/1/kG+X+fMXSQZo6vzVkCqJT0P5QBzUArwGWyA4iF70cCM1O80fAZlFCZtIiGwr3pZcDqX9Ig6QBYHdlJnubXJJM4PEesu/+phf/XHgfmxDlAXLJAdCe0ibjz7a5KL/L4oORkIVGUDqvxJsrd2kLz/iPVtUlcMUvlmJL1Qy91xNTOoVViteG8wxLpAEJqe7fKP5GY2gm7qtU9LxGwn+8tha9zGoambvGZvGZYkSINSXO1reaVZRmeDvepbEc6C2IFCiNyVSgDLDphVhBAqHLQKFnZSqQ3oOItL+WZe2bMWh3TT4VQJYA8uUwh+TL8HqLXnVMFtq3SCn/olY+viCEJoXT4mCaeIttifAR2Ej647Z8fCzHkB6L5tXTtqb5XBGeqnQojYqcWPW22nmzgkdUtynwBapY9bx5uBRSMpCtbd+nuKVxMQ== informeseuemail@example.com
```


Após clonar o repositório, acesse a pasta do projeto e configure o usuário git com os seguintes comandos: 

```sh
$ git config --local user.name "<nome>"
$ git config --local user.email "<email gitlab>"
```

*Obs*.: Se o usuário git já foi configurado, desconsiderar esse passo.

### Backend (API)

Se estiver usando a IDE do Eclipse, simplesmente importe o projeto através do menu | File | Import | Maven | Existing Maven Projects e crie uma configuração para executar a aplicação. 

Após isso, instale as demais dependências locais do projeto usando: 

`$ mvn install` 

Para executar a instalação através de Shell Script acesse a pasta scripts do projeto e execute o seguite arquivo:
```sh
$ sh mvn-clean-install.sh
```
*Obs*.:  Caso necessário, aplica as permissoes de execução chmod a+x NOME_DO_ARQUIVO_SHELL_SCRIPT.

Para levantar o projeto execute o comando abaixo:

`$ mvn spring-boot:run` 

*Obs*.:  É possível executar o projeto através da IDE usando a opção RUN AS | Java Application.

### Estrutura

#### Docker
Para criar  a rede_vendas no docker, execute o script abaixo:

```sh
$ sh create-network.sh
```
*Obs*.:  Criar dentro a pasta jdk em .docker/. Realizar download do jdk(jdk-11.0.4_linux-x64_bin.tar.gz) através do site oracle.

#### Properties Yml
```sh
application-dev.yml
    |------application-dev.yml (Desenvolvimento)
    |------application-stage.yml (Homologação)
    |------application-prod.yml (Produção)
```

#### Database

Todas as informações de acesso aos bancos de dado utilizados no projeto encontram-se no arquivo .env. 

| **Login**  |  **Senha**   |   **Schema**  |
|:----------:|:------------:|:-------------:|
|     root   |     root     |     vendas

#### Url Acesso
A API estará em execução no endereço [http://localhost:8090/vendas/](http://localhost:8090/vendas/).


## Pendências 

- Implementar FlayWay;
- Implementar Deploy Docker;
- Implementar Controller's (Endereco, Pedidos, Produtos);
- Implementar Dto's (Endereco, Pedidos, Produtos);
- Implementar Mapper's (Endereco, Pedidos, Produtos);
- Implementar Validacões (constraint);
