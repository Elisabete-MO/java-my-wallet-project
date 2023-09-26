# :bank: Boas-vindas ao repositório do projeto My-Wallet! :moneybag:

Essa aplicação é uma carteira de controle de gastos e, por meio de 
requisições e consumo de dados provenientes de [API de Cotações](https://docs.awesomeapi.com.br/api-de-moedas), é capaz de converter e consolidar os valores de gastos para o Real Brasileiro (BRL).

#### :credit_card: O usuário será capaz de:

- [ ] Fazer login; <br>
- [ ] Adicionar, remover e editar um gasto; <br>
- [ ] Visualizar uma tabela com seus gastos; <br>
- [ ] Visualizar o total de gastos convertidos para Real Brasileiro. <br>

### Objetivo
O principal objetivo desse projeto é aplicar os padrões de projeto MVC e 
boas práticas em desenvolvimento de software para atender seguintes aos 
requisitos: 
<details>
    <summary>
        <strong> :coin: Requisitos </strong>
    </summary>

- [x] Desenhar diagrama de classes da aplicação com Mermaid; <br>

  <details>

  ```mermaid
  classDiagram
   class Currency {
     +code: string
     +name: string
     +ask: string
     +timestamp: string
     +create_date: string
   }

  	class User {
  		+id: number
  		+username: string
  		+email: string
  		-password: string
  		-image_url: string
  	}
  	
  	class Expense {
  		+create_date: string
  		+description: string
  		+category: string[]
  		+value: number 
  		+payment_type: string[]
  		+currency: string
  		+user_id: number
  	}
  	
  	class Category {
  		<<enumeration>>
  		food
  		lazer
  		work
  		transport
  		health
  	}

  	class PaymentType {
  		<<enumeration>>
  		money
  		credit
  		debit
  		PIX
  	}

  User "1" *-- "n" Expense
  Expense "1" *-- "1" Currency
  Expense "1" *-- "1" PaymentType
  Expense "1" *-- "1" Category
  ```

- [x] Desenvolver a API em Java, Spring e Feign; <br>
- [x] Documentar a API com o Swagger; <br>
- [ ] Estruturar as classes no banco de dados*; <br>
  - [x] Classe User; <br>
  - [x] Classe User; <br>
  - [ ] Classe Expense; <br>
  - [ ] Criar as relações entre as tabelas; <br>
  - [ ] Criar as queries para inserir os dados; <br>
  - [ ] Criar as queries para consultar os dados; <br>
  - [ ] Criar as queries para deletar os dados; <br>
  - [ ] Criar as queries para atualizar os dados; <br>
- [ ] Introduzir processo de autenticação de usuários com o Spring Security; 
  <br>
- [ ] Desenvolver o front-end em Angular; <br>
- [ ] Fazer o deploy da aplicação no Railway.

* H2 para desenvolvimento e Postgres para produção. 
<!-- java -jar your-application.jar --SPRING_PROFILES_ACTIVE=prod
@Column(precision = 10, scale = 2) -->
</details>
</details>

Todos esses conhecimentos foram adquiridos e/ou aprimorados durante o Santander 
Bootcamp 2023 - Fullstack Java + Angular

<details>
    <summary>
        <strong> :money_with_wings: História </strong>
    </summary>

Esse projeto foi desenvolvido primeiramente em REACT e javascript para
atender aos requisitos de avaliação do módulo de front-end do curso de
desenvolvimento web da Trybe. Agora, é o segundo que venho aplicar os
conhecimentos adquiridos em Java e Spring Boot para desenvolver uma API e,
posteriormente, irei utilizar o Angular para remodelar o front-end.
</details>
