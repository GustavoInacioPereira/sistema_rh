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

<details>
  <summary><b>v4.0 - Arquitetura em Camadas e Gestão de Acesso Dinâmico</b></summary>
  <ul>
    <li><b>Arquitetura Modular (Separação de Conceitos):</b> Reestruturação completa do projeto em pacotes especialistas para garantir escalabilidade e manutenção clara:
      <ul>
        <li><code>entities</code>: Modelos de domínio e regras puras do negócio (DNA do sistema).</li>
        <li><code>services</code>: Motores de processos operacionais isolados (Cadastros, Promoções, Aumentos).</li>
        <li><code>views</code>: Interface de interação e exibição para o usuário final.</li>
        <li><code>utilities</code>: Ferramentas genéricas e reaproveitáveis de validação de dados.</li>
      </ul>
    </li>
    <li><b>Segurança por Composição Dinâmica (Has-A):</b>
      <ul>
        <li>Desenvolvimento do módulo independente <code>Account</code>, que é injetado no objeto <code>Funcionario</code> estritamente quando o cargo exige nível de liderança.</li>
        <li><b>Promoção em Tempo Real:</b> Capacidade do sistema de promover funcionários operacionais a líderes, injetando as credenciais de acesso durante a execução, sem a necessidade de destruir ou recriar o objeto base.</li>
      </ul>
    </li>
    <li><b>Blindagem de Execução (Null Safety):</b> Implementação de travas lógicas rigorosas (<code>!= null</code>) no motor de autenticação, blindando a aplicação contra falhas críticas (<i>NullPointerException</i>) durante a varredura do banco de funcionários mistos.</li>
  </ul>
  <p><b>Conceitos Dominados:</b> Design de Sistemas (Arquitetura de Pacotes), Composição Dinâmica de Objetos, Separação de Responsabilidades (SoC), Prevenção de Exceções (Null Safety) e Transição de Estado.</p>
</details>
<details>
  <summary><b>v4.1 - Blindagem e Tratamento de Erros  </b></summary>
  <ul>
    <li><b>Tratamento de Exceções (<code>try/catch</code>):</b> Captura cirúrgica de erros de tipagem para evitar travamentos quando o usuário insere textos em campos estritamente numéricos.</li>
    <li><b>Gerenciamento de Buffer:</b> Uso estratégico do <code>sc.nextLine()</code> dentro dos blocos <code>catch</code> para limpar a memória do <code>Scanner</code> e evitar os temidos loops infinitos letais.</li>
    <li><b>Sobrecarga de Métodos (<i>Overloading</i>):</b> Criação da classe utilitária de blindagem com métodos de mesmo propósito, mas assinaturas diferentes (<code>lerInt</code>, <code>lerDouble</code>), centralizando a lógica de leitura segura.</li>
    <li><b>Micro-Loops de Retenção:</b> Implementação de laços <code>while(true)</code> dentro dos validadores, prendendo o fluxo na mesma etapa até que um dado válido seja fornecido, preservando a navegação do usuário (UX).</li>
    <li><b>Refatoração Defensiva:</b> Aplicação do novo motor de validação em módulos críticos do sistema, como <code>EmployeeRegistration</code> e <code>SalaryIncrease</code>.</li>
  </ul>
  <p><b>Conceitos Dominados:</b> Try/Catch, Limpeza de Buffer, Sobrecarga de Métodos, Programação Defensiva e Micro-loops Arquiteturais.</p>
</details>

<details>
<summary><b>v4.2 - Padrões de Projeto (Strategy) e Princípios SOLID</b></summary>
<ul>
<li><b>Strategy Pattern (Padrão Estratégia):</b> Extração da lógica matemática (como descontos tributários e bônus de horas extras) de dentro da entidade <code>Funcionario</code> para classes especialistas (ex: <code>DiscountCLT</code>, <code>OvertimePJ</code>) através do uso de <b>Interfaces</b> (<code>RulesDiscount</code>, <code>RulesPayOvertime</code>).</li>
<li><b>Injeção de Dependência via Enum:</b> As calculadoras com as regras de negócio passaram a ser instanciadas e injetadas diretamente dentro do Enum <code>Contracts</code>, associando comportamentos matemáticos complexos a cada regime de trabalho de forma elegante e nativa (Polimorfismo).</li>
<li><b>Open/Closed Principle (OCP - SOLID):</b> A arquitetura agora permite que o sistema seja escalado com segurança. Para adicionar uma nova regra do governo (ex: Jovem Aprendiz), basta criar a classe correspondente e plugar no Enum, sem alterar o motor principal do sistema ou criar cascatas de <code>if/else</code>.</li>
<li><b>Eliminação da Recursão Infinita:</b> Remoção de chamadas recursivas inadequadas do método de menu (<code>mostraOpcao</code> chamando a si mesmo), que causavam empilhamento de memória e travamento do console.</li>
</ul>
<p><b>Conceitos Dominados:</b> Padrão Strategy, Interfaces, Injeção de Dependência, Polimorfismo, Princípios SOLID (SRP e OCP) e Clean Architecture.</p>
</details>

<details>
    <summary><b>Versão 4.2.1 - Tratamento de Erro com datas</b></summary>
    <ul>
        <li><b>Verificador de Datas:</b> Implementação de um verificador <code>VerifyDate</code> como método da <code>VerifyType</code>, Adicionando mais uma camada de proteção ao codigo</li>
    </ul>
</details>

<details open>
  <summary><b>v5.0 - Persistência em Banco de Dados (JDBC), Segurança e Refatoração Estrutural Geral (Atual) </b></summary>
  <ul>
    <li><b>Integração com Banco de Dados Relacional (JDBC) e Segurança de Credenciais:</b> Transição do armazenamento volátil em memória (RAM) para persistência real utilizando MySQL e a API JDBC. As credenciais de acesso foram isoladas em arquivos <code>.properties</code> e protegidas via <code>.gitignore</code>. Um template (<code>db.example.properties</code>) foi disponibilizado para configuração segura do ambiente.</li>
    <li><b>Database Seeding e Estruturação (Schema):</b> Criação de um script SQL de inicialização contendo a estrutura completa das tabelas do banco de dados e a injeção (<i>seed</i>) de um usuário padrão de Liderança. Isso garante que o sistema possua um administrador pronto para o primeiro login assim que o projeto for clonado.</li>
    <li><b>Refatoração Estrutural Geral (Cross-Layer):</b> Reescrita profunda da arquitetura do sistema para suportar operações CRUD. As <code>Entities</code> foram ajustadas para mapeamento de banco (IDs), o fluxo de inicialização (<code>App</code>) foi alterado para carregar o estado via <code>ReadDB</code>, e a camada de <code>services</code> abandonou a manipulação de listas locais para executar transações diretas no banco de dados via <code>PreparedStatement</code>.</li>
    <li><b>Autenticação Segura e Escalável (Data Fetching Otimizado):</b> Criação do <code>AuthService</code>. A validação de login da liderança passou a ser feita diretamente no motor do banco de dados via query SQL (<code>SELECT INNER JOIN</code>), resolvendo gargalos críticos de performance ao impedir o carregamento desnecessário de objetos na memória RAM.</li>
    <li><b>Prevenção de Passivos Trabalhistas (Blindagem de Domínio):</b> Inserção da propriedade lógica <code>permiteHoraExtra</code> no Enum <code>Contracts</code>. O sistema agora bloqueia automaticamente o registro de horas extras para regimes incompatíveis (como PJ), blindando a aplicação contra geração de provas de vínculo empregatício indevidas.</li>
    <li><b>Matemática Defensiva e Sobrecarga de Enums:</b> Implementação de sobrecarga de construtores no Enum de Contratos para suportar regimes sem jornada fixa (Carga Semanal = 0). O cálculo de hora-base foi blindado para evitar falhas críticas de sistema geradas por divisão por zero (<i>ArithmeticException</i>).</li>
    <li><b>UI Dinâmica e Ocultação Condicional:</b> Refatoração da visualização de dados (<code>ViewFunRegister</code>) utilizando condicionais atreladas às regras do contrato. O sistema agora oculta automaticamente variáveis irrelevantes da tela (como total de horas extras) dependendo do regime de trabalho do funcionário.</li>
  </ul>
  <p><b>Conceitos Dominados:</b> JDBC (Java Database Connectivity), Operações CRUD, Refatoração Sistêmica, Consultas SQL (Queries e Joins), Autenticação no Back-End, Proteção de Domínio (DDD), Segurança de Credenciais (.gitignore) e Database Seeding.</p>
</details>

<hr>
<p><b>Conceitos Dominados ao Longo do Projeto:</b> Arquitetura em Camadas (MVC-Like), Composição Dinâmica de Objetos (Has-A), Princípios SOLID (SRP, OCP), Design Patterns (Strategy), Injeção de Dependência, Coleções Dinâmicas, Null Safety e Lógica Financeira Orientada a Objetos.</p>

