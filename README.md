
# Cypress Testes Automatizados

Este projeto utiliza Cypress para a automação de testes de front-end. Os relatórios de testes são gerados com o `cypress-mochawesome-reporter`.

## Pré-requisitos

- **Node.js**: Certifique-se de que o Node.js está instalado na versão `18.12.1`.
- **Habilitar Corepack**: Abra o Prompt de Comando em modo administrador e execute o seguinte comando para habilitar recursos adicionais do Node.js:
  
  ``` git bash
  corepack enable
  ```
- **Yarn**: O Yarn deve estar instalado na versão `1.22.22`. 
- **IDE**: É recomendável usar o Visual Studio Code (VS Code), mas você pode utilizar qualquer outra IDE de sua preferência.

## Instalação do Cypress

1. **Criação do Projeto**:
   - Crie um diretório para o seu projeto onde o Cypress será configurado.
   
   - Navegue até o diretório criado usando o terminal (Git Bash ou Prompt de Comando) e inicialize o projeto com o comando:
   
     ```bash
     yarn init
     ```

2. **Instalação do Cypress**:
   - Após inicializar o projeto, instale o Cypress como dependência de desenvolvimento:
   
     ```bash
     yarn add cypress -D
     ```

3. **Abrir o Cypress**:
   - Para abrir o Cypress, utilize o comando abaixo:
   
     ```bash
     yarn cypress open
     ```

## Instalação das Ferramentas de Relatório

Para gerar relatórios detalhados, é necessário instalar algumas bibliotecas adicionais:

- Execute o seguinte comando no Git Bash para instalar as dependências necessárias:

  ```bash
  yarn add -D cypress-multi-reporters mochawesome mochawesome-merge mochawesome-report-generator
  ```

## Executando os Testes com Cypress

Para executar os testes, siga os passos abaixo:

1. **Abra o Git Bash**.
2. **Execute o comando**:

   ```bash
   yarn cypress run
   ```

## Gerando Relatórios com Mochawesome

Após a execução dos testes, os relatórios são gerados automaticamente em formato HTML:

1. **Executando e Gerando Relatórios**:
   - Para executar os testes e gerar relatórios utilizando o `cypress-mochawesome-reporter`, utilize:

     ```bash
     yarn cypress run
     ```

   - Este comando executa os testes e gera o relatório na pasta `cypress/reports/report`.

## Abrindo o Relatório

Após gerar o relatório HTML, você pode abri-lo diretamente no navegador. Para isso, utilize o comando:

```bash
open cypress/reports/html/index.html
```

## Estrutura do Projeto

- **cypress/**: Contém os testes automatizados.
- **cypress/reports/**: Diretório onde os relatórios de teste são gerados.

## Dependências

- **Cypress**: `^13.13.2`
- **cypress-mochawesome-reporter**: `^3.8.2`
- **mochawesome**: `^7.1.3`
- **mochawesome-merge**: `^4.3.0`
- **mochawesome-report-generator**: `^6.2.0`


