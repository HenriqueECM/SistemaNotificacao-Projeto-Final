# Sistema de Notificações de Presença

Este projeto é um sistema de registro e notificação de presença para alunos e professores, desenvolvido em Java, utilizando JDBC para acesso a banco de dados MySQL. O sistema aplica diversos padrões de projeto e segue uma arquitetura em camadas para garantir organização, escalabilidade e manutenção.

---

## 🏗️ 1️⃣ Diagrama de Componentes

Representa os grandes blocos do sistema e suas responsabilidades.

```
+-----------------------------------------------------+
| Sistema de Notificações de Presença (Java + JDBC)   |
|-----------------------------------------------------|
| + Interface (View)                                  |
|     - TelaLogin                                     |
|     - TelaCadastro                                  |
|     - TelaRegistroPresenca                          |
| + Controller                                        |
|     - LoginController                               |
|     - CadastroController                            |
|     - RegistroPresencaController                    |
| + Service                                           |
|     - AuthService                                   |
|     - AlunoService                                  |
|     - ProfessorService                              |
| + Repository (DAO)                                  |
|     - UserDAO                                       |
|     - AlunoDAO                                      |
|     - ProfessorDAO                                  |
|     - PresencaDAO                                   |
| + Model                                             |
|     - User                                          |
|     - Aluno                                         |
|     - Professor                                     |
|     - Presenca                                      |
|     - UnidadeCurricular                             |
| + Patterns                                          |
|     - Factory (NotificadorFactory)                  |
|     - Facade (NotificacaoFacade)                    |
|     - Observer (AlunoObservador, RegistroPresenca)  |
| + Infraestrutura                                    |
|     - Conexao (DriverManager + JDBC)                |
|-----------------------------------------------------|
| Banco de Dados MySQL                                |
+-----------------------------------------------------+
```

---

## 🧩 2️⃣ Diagrama de Pacotes

Estrutura dos diretórios e classes Java:

```
org.example
│
├── controller
│   ├── LoginController
│   ├── CadastroController
│   └── RegistroPresencaController
│
├── service
│   ├── AuthService
│   ├── AlunoService
│   └── ProfessorService
│
├── repository
│   ├── UserDAO
│   ├── AlunoDAO
│   ├── ProfessorDAO
│   └── PresencaDAO
│
├── model
│   ├── User
│   ├── Aluno
│   ├── Professor
│   ├── Presenca
│   └── UnidadeCurricular
│
├── pattern
│   ├── facade
│   │   └── NotificacaoFacade
│   ├── factory
│   │   ├── NotificadorFactory
│   │   ├── EmailFactory
│   │   └── SmsFactory
│   └── observer
│       ├── Observador
│       ├── AlunoObservador
│       └── RegistroPresenca
│
└── infra
    └── Conexao
```

---

## 🧱 3️⃣ Diagrama de Camadas (Layered Architecture)

Mostra as dependências e responsabilidades de cada camada.

```
+-----------------------+
|      VIEW (UI)        |
| (Console / Futuro Web)|
+----------+------------+
           |
           v
+-----------------------+
|    CONTROLLER         |
| Lógica de interação   |
+----------+------------+
           |
           v
+-----------------------+
|     SERVICE           |
| Regras de negócio     |
+----------+------------+
           |
           v
+-----------------------+
|   REPOSITORY (DAO)    |
| Persistência via JDBC |
+----------+------------+
           |
           v
+-----------------------+
|     DATABASE (MySQL)  |
+-----------------------+
```

### Padrões aplicados:

- **Factory Method**: Criação de notificadores (`EmailFactory`, `SmsFactory`)
- **Facade**: Simplifica envio de notificações (`NotificacaoFacade`)
- **Observer**: Alunos observam mudanças de presença (`AlunoObservador`, `RegistroPresenca`)

---

## 📦 4️⃣ Diagrama de Classes (Simplificado)

Representação simplificada das principais classes.

```
+---------------------+
|       User          |
|---------------------|
| id : int            |
| email : String      |
| senha : String      |
| tipo : Enum         |
+---------------------+
          ^
          |
+---------+---------+
|                   |
|    Aluno          |    Professor
|----------|        |-----------|
| matricula|        | cpf       |
| status   |        | telefone  |
| turma    |        +-----------+
+----------+

+------------------+
| UnidadeCurricular|
|------------------|
| id               |
| nome             |
| dataInicio       |
| id_professor     |
+------------------+

+------------------+
| Presenca         |
|------------------|
| id               |
| aluno_id         |
| unidade_id       |
| data_avaliacao   |
| status           |
| professor_id     |
+------------------+
```

---

## 🔄 5️⃣ Diagrama de Conectores (Integrações)

Fluxo de dados entre os módulos.

```
[View] 
   ↓ (requisição de login/cadastro)
[Controller]
   ↓ (validação e lógica)
[Service]
   ↓ (acesso ao banco)
[Repository/DAO] ⇄ [MySQL]
   ↑
[Patterns (Facade/Factory/Observer)] → Comunicação assíncrona (Notificações)
```

---

## 🎬 6️⃣ Diagrama de Caso de Uso (alto nível)

### Atores:
- **Aluno**
- **Professor**
- **Sistema**

```
+-------------------+
| Sistema de Presença|
+-------------------+
       ^     ^
       |     |
 +-----+     +------+
 | Professor| Aluno |
 +----------+-------+
       |        |
[Registrar Presença]     [Receber Notificação]
       |
[Visualizar Turmas/Alunos]
```

---

## 📜 7️⃣ Diagrama de Sequência — “Marcar Falta”

Fluxo de marcação de falta pelo professor:

```
Professor -> Controller: marcarFalta(aluno, data)
Controller -> DAO: registrar(aluno_id, data, status)
DAO -> MySQL: INSERT INTO Presenca ...
Controller -> Facade: notificarAluno(...)
Facade -> Factory: criarNotificador()
Factory -> Notificador: enviar(mensagem)
Notificador -> Aluno: "Você foi marcado ausente!"
```

---

## 🚀 Tecnologias e Padrões

- **Java**
- **JDBC**
- **MySQL**
- **MVC**
- **Factory, Facade, Observer Patterns**

---

## 📄 Licença

Este projeto está sob a licença MIT.

---

## 📫 Contato

Dúvidas ou sugestões? Fale com o autor via [GitHub](https://github.com/HenriqueECM).
