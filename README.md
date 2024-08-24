
# Cypress Testes Automatizados

Este projeto utiliza Cypress para a automação de testes e gera relatórios detalhados usando o `cypress-mochawesome-reporter`.

## Pré-requisitos

- **Node.js**: Certifique-se de que o Node.js está instalado na versão `18.12.1`.
- **Yarn**: O Yarn deve estar instalado na versão `1.22.22`. Execute o comando abaixo para garantir que o Corepack, que facilita o uso do Yarn, esteja habilitado:

  ```bash
  corepack enable
  ```
- **IDE**: É recomendável usar o Visual Studio Code (VS Code), mas você pode utilizar qualquer outra IDE de sua preferência.

## Configuração do Projeto

1. Navegue até o diretório que deseja baixar o projeto.

2. Clone o repositório:

   ```bash
   git clone https://github.com/AlexCosta041/Avaliacao_Teste.git
   ```

``
3. Instale as dependências do projeto:

   ```bash
   yarn install
   ```

## Instalação das Ferramentas de Relatório

Para gerar relatórios detalhados, instale as bibliotecas adicionais necessárias:

```bash
yarn add -D cypress-multi-reporters mochawesome mochawesome-merge mochawesome-report-generator
```

## Executando os Testes com Cypress

Para executar os testes, siga os passos abaixo:

1. **Execute os testes**:

   ```bash
   yarn cypress run
   ```

   Este comando executará os testes e gerará relatórios automaticamente.

## Gerando e Visualizando Relatórios com Mochawesome

Após a execução dos testes, os relatórios serão gerados automaticamente no formato HTML:

1. **Gerando Relatórios**: 

   Os relatórios serão gerados na pasta `cypress/reports/report/index.html`. O comando para gerar os relatórios é o mesmo utilizado para executar os testes:

   ```bash
   yarn cypress run
   ```

2. **Visualizando o Relatório**:

   Após a execução dos testes, você pode abrir o relatório gerado diretamente no navegador:

- **Diretório**: cypress/reports/report/index.html
   
## Estrutura do Projeto

- **cypress/**: Contém os testes automatizados.
- **cypress/reports/**: Diretório onde os relatórios de teste são gerados.

## Dependências

- **Cypress**: `^13.13.2`
- **cypress-mochawesome-reporter**: `^3.8.2`
- **mochawesome**: `^7.1.3`
- **mochawesome-merge**: `^4.3.0`
- **mochawesome-report-generator**: `^6.2.0`
