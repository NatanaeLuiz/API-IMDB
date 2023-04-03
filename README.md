# API-IMDB 
[![NPM](https://img.shields.io/npm/l/react)](https://raw.githubusercontent.com/lumedeirosn/imersao-2-spring/main/LICENSE) 

<h1>Imersão Java - Alura</h1>

- Consumo de API pública do site IMDB
##

Desafio:

<ol>
  <li>Criar um programa que consome API do IMDB, ler os dados de um JSON, selecionar apenas Título, imagem, Ano e Classificação.</li>
</ol>

Resultado:
<div>
<img src="https://user-images.githubusercontent.com/17768272/228108356-36f50266-8d2f-457b-86a9-c193e32fe852.png">
</div>

##
Gerador de Figurinhas para WhatsApp
##

Utilizando dados do JSON retornado da requisição da API para gerar uma imagem personalizada para compartilhar no WhatsApp como figurinhas.

Ex:
<div>
<img width="250px" heigth="250px" src="https://github.com/NatanaeLuiz/API-IMDB/blob/main/saida/The%20Shawshank%20Redemption.png">
</div>

## Tecnologias utilizadas

-   Java 17
-   HttpClient
-   JSON
-   Maven

## Pré-requisitos

-   [Java 11](https://www.oracle.com/br/java/technologies/downloads/#jdk17-windows) ou superior instalado
-   Conexão com a internet
-   [VsCode](https://code.visualstudio.com) 

##  Como usar

 1.  Clone ou baixe este repositório em seu computador.
 2.  Importe o projeto baixado no VSCode.
 3.  Starte o projeto
 
## API Endpoint's

Foi implementado uma busca de 3 endpoints.
 1.  10 Principais filmes na API do IMDB.
```shell
API_ENDPOINT="https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"
```
 2.  Imagens da NASA
```shell
API_ENDPOINT="https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-02-01&end_date=2023-02-02"
```
 3.  Linguagens Preferida 
```shell
API_ENDPOINT="http://localhost:8080/languages"
```

