# PetStore API Test Suite

## Descrição

Este projeto contém uma suíte de testes automatizados para a API PetStore, utilizando a biblioteca RestAssured para facilitar as interações com a API e a biblioteca JUnit para gerenciar os testes. O objetivo é validar as funcionalidades principais da API, como a criação de pedidos, atualização de dados de pets e a verificação do status de pets.

## Autor

Danilo Sousa

## Tecnologias Utilizadas

- **Java**
- **RestAssured**: Para testes de APIs RESTful.
- **JUnit**: Para a estruturação e execução dos testes.

## Estrutura do Projeto

- **PetStoreTests.java**: Classe principal contendo os testes automatizados.
- **gerarDadosNovoPedido**: Método auxiliar para gerar dados de um novo pedido.
- **gerarDadosAtualizacaoPet**: Método auxiliar para gerar dados de atualização de um pet.

## Testes Implementados

1. **Cadastro de Novo Pedido de Pet**
    - Verifica se é possível cadastrar um novo pedido de pet com sucesso.

2. **Erro ao Pesquisar Pet Inexistente**
    - Verifica se a API retorna um erro ao tentar buscar um pet que não existe.

3. **Atualização de Dados de Pet Existente**
    - Verifica se é possível atualizar os dados de um pet existente.

4. **Retorno de Pets com Status Pending**
    - Verifica se a API retorna os pets com status "pending".

## Como Executar os Testes

1. **Clonar o repositório:**
   ```bash
   git clone <https://github.com/dansousa19/PetStore_API.git>
