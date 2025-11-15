# SchoolSystem

Sistema em Java para controle de notas e frequência de alunos, desenvolvido para auxiliar professores na organização de turmas. O programa permite inserir as notas de cinco disciplinas e a frequência de cada aluno, calculando automaticamente médias individuais e médias da turma, além de identificar alunos que precisam de atenção especial.

---

## Instruções para Executar o Sistema

1. Abra o terminal e navegue até a pasta `src/` do projeto:

```bash
cd SchoolSystem/src
Compile o programa:

```

```bash
javac SchoolSystem.java
Execute o programa:

```

```bash
java SchoolSystem
````
Insira os dados dos alunos seguindo o formato:
````
<Nome> <Nota1> <Nota2> <Nota3> <Nota4> <Nota5> <Frequência%>
Exemplo:
João 7 8 6 9 10 80%
Maria 7 8 6 9 10 70%
fim
````
Digite fim para encerrar a entrada de dados.

O programa exibirá:

Lista de alunos com média e frequência

Média da turma por disciplina

Alunos com média acima da turma

Alunos com frequência abaixo de 75%

Premissas Assumidas
Cada aluno possui exatamente cinco notas, uma para cada disciplina.

A frequência é informada em percentual (0 a 100%).

Não há limite de alunos; o usuário pode inserir quantos desejar.

O programa considera “média acima da turma” comparando a média do aluno com a média geral de todas as disciplinas.

Entrada incorreta é rejeitada e o usuário deve recomeçar a digitação do aluno.

Decisões de Projeto
Utilização de uma classe Student para representar cada aluno, com atributos name, grades, attendance e averageGrade.

A média do aluno é calculada automaticamente no construtor da classe.

A média da turma por disciplina é calculada somando as notas de todos os alunos e dividindo pelo número de alunos.

O programa é baseado em console (terminal) para simplicidade e portabilidade.

Formatação das saídas com duas casas decimais para facilitar leitura.

Validações de entrada: notas entre 0 e 10, frequência entre 0 e 100%.

Listas de destaque para alunos acima da média e com frequência baixa, mesmo que vazias, para clareza.

Informações Adicionais
O projeto pode ser facilmente estendido para ler dados de um arquivo CSV ou de um banco de dados.

Possível integração futura com interface gráfica (Java Swing ou Web) para uma experiência mais interativa.

O código é modular e pode ser reutilizado em outros projetos escolares ou acadêmicos.

Estrutura do Projeto
```
SchoolSystem/
├── src/
│   └── SchoolSystem.java
├── bin/                # Opcional, para arquivos compilados
├── README.md
```
Autor
José Vieira
