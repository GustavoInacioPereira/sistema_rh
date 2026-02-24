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

<details open>
  <summary><b>v3.0 - Arquitetura Modular e Gestão de Estado (Versão Atual)</b></summary>
  <ul>
    <li><b>Single Responsibility:</b> Divisão em classes especialistas (Cadastro, Aumento, Validação).</li>
    <li><b>Soft Delete:</b> Implementação de exclusão lógica para preservar a integridade dos índices da lista.</li>
    <li><b>Gestão de Acumuladores:</b> Lógica complexa para cálculo automático de horas extras e bônus.</li>
    <li><b>Coleções Dinâmicas:</b> Substituição de Arrays por <code>ArrayList</code> para escalabilidade.</li>
    <li><b>Conceitos:</b> Modularização, Listas Dinâmicas, SRP (Responsabilidade Única) e Lógica de Negócio Encapsulada.</li>
  </ul>
</details>

<hr>
<p><b>Conceitos Dominados:</b> Modularização, Coleções Dinâmicas, Validação de Fluxo, Encapsulamento Avançado e Tratamento de Estados de Objeto.</p>