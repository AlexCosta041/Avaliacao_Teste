# Desafio Sicredi

Projeto de testes automatizados em Java 8 usando JUnit 5 e RestAssured, contendo testes para **Products** e **Smoke API**.

---

## Download e Instalação

1. **Baixar o projeto**: Baixar o projeto do github

2. **Abrir em IDE (opcional)**: 
   - Eclipse: `File -> Import -> Existing Maven Projects` e selecione a pasta extraída.
   - IntelliJ: `File -> Open` e selecione a pasta do projeto.

4. **Instalar dependências Maven**:
   Abra o terminal na pasta do projeto e execute:

   mvn clean install
   
   Isso irá baixar todas as bibliotecas necessárias, como JUnit5 e RestAssured.

---

## Executando os testes

### Pelo Maven (linha de comando)

mvn test


- Todos os testes em `src/test/java` serão executados.
- Resultados serão exibidos no console.

### Pela IDE (Eclipse ou IntelliJ)

1. Clique com o botão direito na classe de teste ou pacote `br.com.sicredi.tests`.
2. Selecione: **Run As → JUnit Test**
3. A janela de execução exibirá quais testes passaram ou falharam.

---

## Observações

1. Os testes usam **DummyJSON** (`https://dummyjson.com`) como API de exemplo.  


