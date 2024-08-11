# Trabalho Prático de Orientação por Objetos - FGA

## Universidade de Brasília (UnB) - Faculdade do Gama (FGA)

### Orientação por Objetos (OO)

**Prof. André Luiz Peron Martins Lanna**

## Alunos

**Arthur Luiz Silva Guedes - 23/1028675**

**Heyttor Augusto de Assis Silva - 23/2002996**

**Joselito Prado Marques da Silva - 14/0023704**

**Nathan Henrique Magalhães de Castro - 23/1011758**

---

## Objetivo

Aplicar conceitos fundamentais de Orientação por Objetos (OO) para desenvolver um sistema de gestão acadêmica, utilizando Herança e Polimorfismo. Implementar um sistema em Java que gerencie cadastros de alunos, professores, disciplinas, turmas e salas de aula.

## Cenário da Oficina Mecânica

O sistema deve:
- Cadastrar alunos, professores, disciplinas, turmas e salas de aula.
- Criar turmas associadas a disciplinas e professores, e matricular alunos.
- Imprimir a lista de presença com nome da disciplina, nome do professor, código da turma e lista de alunos matriculados.
- Impedir cadastro com campos em branco e lançar exceções apropriadas:
  - `CampoEmBrancoException`
  - `DisciplinaNaoAtribuidaException`
  - `ProfessorNaoAtribuidoException`

## Enunciado

- Implementar lançamento e tratamento de exceções para o cadastro de alunos.
- Implementar cadastros de disciplinas, turmas e professores, com operações de cadastro, pesquisa, alteração e remoção.
- Implementar a impressão da lista de presença para uma turma pesquisada.

## Instalação e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/joselitopradomarques/tp-fga0158.git

## Inserções para Testes e Resultados Esperados

Aqui estão alguns exemplos de inserções e os resultados esperados para testar todas as funcionalidades e operações do sistema:

### Teste de Cadastro de Aluno

- **Inserção**:
  - **Nome**: João Silva
  - **Matrícula**: 123456
  - **Data de Nascimento**: 01/01/2000

- **Resultado Esperado**:
  - O aluno deve ser cadastrado com sucesso.
  - A lista de alunos deve incluir "João Silva" com matrícula "123456".

### Teste de Pesquisa de Aluno

- **Inserção**:
  - **Matrícula**: 123456

- **Resultado Esperado**:
  - O sistema deve retornar as informações do aluno com matrícula "123456", incluindo nome e data de nascimento.

### Teste de Alteração de Aluno

- **Inserção**:
  - **Matrícula**: 123456
  - **Novo Nome**: João Pedro Silva

- **Resultado Esperado**:
  - O nome do aluno com matrícula "123456" deve ser alterado para "João Pedro Silva".
  - A lista de alunos deve refletir a alteração.

### Teste de Remoção de Aluno

- **Inserção**:
  - **Matrícula**: 123456

- **Resultado Esperado**:
  - O aluno com matrícula "123456" deve ser removido com sucesso.
  - A lista de alunos não deve incluir mais o aluno com matrícula "123456".

### Teste de Cadastro de Disciplina

- **Inserção**:
  - **Código**: FGA0158
  - **Nome**: Orientaçã a Objetos

- **Resultado Esperado**:
  - A disciplina deve ser cadastrada com sucesso.
  - O sistema mostrará "Disciplina criada com sucesso"

### Teste de Pesquisa de Disciplina

- **Inserção**:
  - **Código**: FGA0158

- **Resultado Esperado**:
  - O sistema deve retornar as informações da disciplina com código "FGA0158", incluindo nome "Orientação a objetos".

### Teste de Alteração de Disciplina

- **Inserção**:
  - **Código**: FGA0158
  - **Novo Nome**: OO

- **Resultado Esperado**:
  - O nome da disciplina com código "FGA0158" deve ser alterado para "OO".
  - O sistema deve retornar a mensagem "Disciplina atualizada com sucesso."

### Teste de Remoção de Disciplina

- **Inserção**:
  - **Código**: FGA0158

- **Resultado Esperado**:
  - A disciplina com código "FGA0158" deve ser removida com sucesso.
  - O sistema deve retornar a mensagem "Disciplina removida com sucesso."

### Teste de Cadastro de Turma

- **Inserção**:
  - **Código da Turma**: T1
  - **Disciplina**: MAT101
  - **Professor**: Prof. Ana

- **Resultado Esperado**:
  - A turma deve ser cadastrada com sucesso.
  - A lista de turmas deve incluir "T1 - MAT101 - Prof. Ana".

### Teste de Pesquisa de Turma

- **Inserção**:
  - **Código da Turma**: T1

- **Resultado Esperado**:
  - O sistema deve retornar as informações da turma com código "T1", incluindo disciplina e professor.

### Teste de Alteração de Turma

- **Inserção**:
  - **Código da Turma**: T1
  - **Nova Disciplina**: MAT102
  - **Novo Professor**: Prof. Bruno

- **Resultado Esperado**:
  - A disciplina e o professor da turma com código "T1" devem ser alterados para "MAT102" e "Prof. Bruno", respectivamente.
  - A lista de turmas deve refletir a alteração.

### Teste de Remoção de Turma

- **Inserção**:
  - **Código da Turma**: T1

- **Resultado Esperado**:
  - A turma com código "T1" deve ser removida com sucesso.
  - A lista de turmas não deve incluir mais a turma com código "T1".

### Teste de Exceção no Cadastro de Aluno

- **Inserção**:
  - **Nome**: (Deixe em branco)
  - **Matrícula**: 123456

- **Resultado Esperado**:
  - `CampoEmBrancoException` deve ser lançada com a mensagem "Nome não pode ser vazio".

### Teste de Exceção no Cadastro de Disciplina

- **Inserção**:
  - **Código**: (Deixe em branco)
  - **Nome**: Matemática I

- **Resultado Esperado**:
  - `CampoEmBrancoException` deve ser lançada com a mensagem "Código não pode ser vazio".

### Teste de Exceção no Cadastro de Turma

- **Inserção**:
  - **Código da Turma**: T2
  - **Disciplina**: (Deixe em branco)
  - **Professor**: Prof. Ana

- **Resultado Esperado**:
  - `DisciplinaNaoAtribuidaException` deve ser lançada com a mensagem "Disciplina não atribuída".

### Teste de Impressão da Lista de Presença

- **Inserção**:
  - **Código da Turma**: T1 (que já tem alunos matriculados)

- **Resultado Esperado**:
  - A lista de presença deve ser impressa, incluindo o nome da disciplina, o nome do professor, o código da turma e a lista de alunos matriculados.

