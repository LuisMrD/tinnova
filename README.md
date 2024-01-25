# tinnova

O projeto foi feito usando SpringBoot.

Dentro da pasta principal do projeto estão todos os exercicios, separados por pasta.

Os exercicios de 1 a 4 possuem em seu diretório dois arquivos, um com a classe responsável pela resolução, outro com o executável já configurado para aferição das saídas.

O exercício 5 pode ser executado através da classe principal da aplicação Spring, não contendo em sua estrutura um executável privado como os exercícios anteriores.

A aplicação Spring foi desenvolvida usando o jdk 17.0.1, portanto é recomendável ter essa versão instalada na máquinda onde for rodar o projeto.

Escrevi alguns testes, porém, para executálos é preciso alterar o arquivo application.properties da seguinte maneira:

#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect  -> descomentar essa linha
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect -> comentar essa linha

Não escrevi o front end da aplicação, mas adicionei na raiz desse projeto uma coleção do Postman para bater em cada endpoint.

COMO CONFIGURAR O PROJETO

É preciso ajustar o arquivo application.properties para refletir nome e senha, do banco local em MySql na máquina onde for rodar o projeto.

É preciso executar o seguinte comando no banco de dados local (MysSql) antes de iniciar a aplicação: CREATE DATABASE teste_tinnova;


*Lista com as marcas de carros que são aceitas, pode ser encontrada em: exercicio5/utils/CarBrands (ENUM)


