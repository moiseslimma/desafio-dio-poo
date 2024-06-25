# Desafio Dio: Bootcamp Management System

Este projeto é uma aplicação Java para gerenciamento de Bootcamps, contendo funcionalidades para inscrição de desenvolvedores, acompanhamento de progresso, cálculo de XP (pontos de experiência) e gerenciamento de conteúdos (cursos e mentorias).

## Estrutura do Projeto
O projeto está dividido em várias classes e interfaces que representam diferentes entidades e funcionalidades do sistema de gerenciamento de Bootcamps.

## Classes Principais

- **Bootcamp**: Representa um bootcamp, contendo uma lista de desenvolvedores inscritos e conteúdos.
- **Dev**: Representa um desenvolvedor, contendo listas de conteúdos inscritos e concluídos, além de métodos para inscrição, progresso e cálculo de XP.
- **Conteudo**: Classe abstrata representando um conteúdo genérico (curso ou mentoria) com métodos para cálculo de XP.
- **Curso**: Subclasse de Conteudo representando um curso, incluindo carga horária.
- **Mentoria**: Subclasse de Conteudo representando uma mentoria, incluindo data.
- **Main**: Classe principal que executa a aplicação, criando instâncias de Bootcamp, Dev, Curso e Mentoria e demonstrando suas funcionalidades.
### Interfaces e Enums
- **IConteudo**: Interface que define operações básicas de um conteúdo.
- **TipoConteudo**: Enumeração que define os tipos de conteúdos (CURSO, MENTORIA).

## Funcionalidades

- **Criar Bootcamps**: Definir nome, descrição, data inicial e final, além de adicionar conteúdos.
- **Inscrever Desenvolvedores**: Desenvolvedores podem se inscrever em bootcamps, adicionando todos os conteúdos do bootcamp à sua lista de inscritos.
- **Progredir nos Conteúdos**: Desenvolvedores podem marcar conteúdos como concluídos, movendo-os da lista de inscritos para a lista de concluídos.
- **Calcular XP**: O XP total de um desenvolvedor é calculado com base nos conteúdos concluídos.
- **Verificar Progresso**: Desenvolvedores podem verificar o percentual de conclusão de um bootcamp.
- **Listar Conteúdos Pendentes**: Desenvolvedores podem listar os conteúdos pendentes para concluir o bootcamp.
