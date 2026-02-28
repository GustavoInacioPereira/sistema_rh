**Aviso de Ramificação (Branch de Estudos):** Esta branch (`feature/estudos-heranca`) é uma Prova de Conceito (PoC) técnica para fins de estudo, focada na aplicação estrita de **Herança e Polimorfismo**. A arquitetura principal e otimizada para o mundo real (utilizando o padrão de **Composição**) encontra-se na branch `main`.
<h1>Sistema de Folha de Pagamento (RH)</h1>
<h2>📝 Resumo </h2>
<p>Este projeto foi criado para resolver um desafio de lógica de programação em Java. O sistema recebe os dados de um funcionário, valida o seu cargo através de um identificador e calcula o salário final com base em regras de bónus para cargos de confiança.</p>

<h2>🚩 Desafio Proposto</h2>
<p>Criar um programa que processe o pagamento de funcionários, diferenciando cargos de liderança (que recebem 40% de bónus sobre a hora base) de cargos operacionais.</p>

<h3>🚀 Evolução do Projeto: Sistema de RH</h3>

<p>Este projeto documenta minha trajetória de aprendizado em Java, evoluindo de uma lógica estruturada básica para uma arquitetura orientada a objetos robusta e modular.</p>

<details>
  <summary><b>v1.0 & v1.1 - Lógica Estruturada e Controle de Fluxo</b></summary>
  <ul>
    <li>Implementação de entrada de dados via <code>Scanner</code> e armazenamento em Arrays fixos.</li>
    <li>Introdução de tratamento de erros com estruturas de repetição para validar IDs e evitar índices negativos.</li>
    <li><b>Conceitos:</b> Variáveis, Condicionais, Laços de Repetição e Sintaxe Java.</li>
  </ul>
</details>

<details>
  <summary><b>v2.0 & v2.1 - Refatoração POO e Encapsulamento</b></summary>
  <ul>
    <li>Organização em pacotes (<code>entities</code> / <code>application</code>) e criação da classe <code>Funcionario</code>.</li>
    <li>Aplicação de <b>Encapsulamento</b> (Getters/Setters) e Construtores para garantir integridade dos dados.</li>
    <li>Uso de membros estáticos (<code>static</code>) para otimização de memória na tabela de cargos.</li>
    <li><b>Conceitos:</b> Classes, Métodos, Encapsulamento, Construtores e Membros de Classe.</li>
  </ul>
</details>

<details>
  <summary><b>v3.0 - Arquitetura Modular e Gestão de Estado</b></summary>
  <ul>
    <li><b>Single Responsibility:</b> Divisão em classes especialistas (Cadastro, Aumento, Validação).</li>
    <li><b>Soft Delete:</b> Implementação de exclusão lógica para preservar a integridade dos índices da lista.</li>
    <li><b>Gestão de Acumuladores:</b> Lógica complexa para cálculo automático de horas extras e bônus.</li>
    <li><b>Coleções Dinâmicas:</b> Substituição de Arrays por <code>ArrayList</code> para escalabilidade.</li>
    <li><b>Conceitos:</b> Modularização, Listas Dinâmicas, SRP (Responsabilidade Única) e Lógica de Negócio Encapsulada.</li>
  </ul>
</details>

<details>
<summary><b>v3.1 - Enums Complexos e Java Time API</b></summary>
<ul>
<li><b>Tipagem Segura com Enums:</b> Substituição da classe de cargos por um <code>enum</code> robusto que centraliza regras de negócio (salário base e bônus de liderança de 40% calculado internamente).</li>
<li><b>Iteração Nativa:</b> Uso do método <code>.values()</code> do Enum para geração dinâmica de menus de seleção, eliminando arrays manuais.</li>
<li><b>Manipulação de Datas (ISO 8601):</b> Integração com <code>LocalDate</code> e <code>DateTimeFormatter</code> para parsing de datas brasileiras e registro automático de admissão (<code>now()</code>).</li>
<li><b>Polimorfismo de Construtores:</b> Sobrecarga de construtores na classe <code>Funcionario</code> para suportar diferentes fluxos de entrada de dados.</li>
<li><b>Conceitos:</b> Enums (objetos constantes), Java Time API, ISO 8601, Sobrecarga e Formatação de Dados.</li>
</ul>
</details>

<details>
<summary><b>v3.2 - Composição de Domínio e Motor Financeiro</b></summary>
<ul>
<li><b>Arquitetura por Composição:</b> A classe <code>Funcionario</code> agrega múltiplos comportamentos de <code>Cargos</code> e <code>Contracts</code>.</li>
<li><b>Motor Financeiro Dinâmico:</b>
<ul>
<li>Cálculo de <b>Divisor Salarial</b> baseado na carga horária do contrato (CLT, PJ, Estágio, etc).</li>
<li>Cálculo de <b>Horas Extras</b> automático (Salário Base / (Carga Semanal × 4.5)).</li>
<li>Gestão de <b>Descontos Contratuais</b> via taxa parametrizada em Enum.</li>
</ul>
</li>
</ul>
<p><b>Conceitos Dominados:</b> Encapsulamento Avançado, Composição de Objetos, Lógica Financeira em Enums, Tratamento de Datas e Responsabilidade Única (SRP).</p>
</details>
<details open>
  <summary><b>v3.3 - Herança, Polimorfismo e Decisão de Arquitetura (Branch Atual)</b></summary>
  <ul>
    <li><b>Herança (Is-A):</b> Criação da entidade <code>FuncionarioLideranca</code> estendendo a classe base <code>Funcionario</code> para injetar credenciais de acesso (Login/Senha).</li>
    <li><b>Polimorfismo e Downcasting:</b> Inserção de objetos especializados em uma <code>List&lt;Funcionario&gt;</code> genérica e uso do operador <code>instanceof</code> para identificar e autenticar administradores em tempo de execução.</li>
    <li><b>Decisão de Arquitetura (Trade-off):</b> Esta ramificação serve como Prova de Conceito (PoC) técnica dos pilares da OOP. Em um cenário de escalabilidade real (ex: promoção de um funcionário base para gerente), a <b>Composição</b> (injetar credenciais no objeto) seria a escolha arquitetural ideal sobre a Herança para evitar um acoplamento rígido.</li>
  </ul>
  <p><b>Conceitos Dominados:</b> Herança (extends), Polimorfismo de Coleções, Downcasting (instanceof) e Análise Crítica de Design de Software.</p>
</details>
<hr>
<p><b>Conceitos Dominados:</b> Modularização, Coleções Dinâmicas, Validação de Fluxo, Encapsulamento Avançado e Tratamento de Estados de Objeto.</p>