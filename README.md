<h1>Sistema de Folha de Pagamento (RH)</h1>
<h2>📝 Resumo </h2>
<p>Este projeto foi criado para resolver um desafio de lógica de programação em Java. O sistema recebe os dados de um funcionário, valida o seu cargo através de um identificador e calcula o salário final com base em regras de bónus para cargos de confiança.</p>

<h2>🚩 Desafio Proposto</h2>
<p>Criar um programa que processe o pagamento de funcionários, diferenciando cargos de liderança (que recebem 40% de bónus sobre a hora base) de cargos operacionais.</p>

<h2>📌 Versões e Evolução</h2>
<h3>v1.0 - Lógica Estruturada:</h3>

<ul>
    <li>
        Uso de Scanner para entrada de dados.
    </li>
    <li>
        Armazenamento de cargos num Array de Strings.
    </li>
    <li>
        Cálculo de bónus utilizando estruturas condicionais (if/else).
    </li>
    <li>
        Formatação de saída com printf (2 casas decimais).
    </li>
</ul>
<p>Conceitos aplicados: Variáveis, Arrays, Condicionais e Sintaxe Java 25.</p>

<h3>v1.1 - Tratamento de Erros</h3>

<ul>
    <li>
        Adicionada camada de segurança que impede códigos inexistentes ou negativos, garantindo a integridade dos índices do Array.
    </li>
    <li>
        O sistema agora solicita a reentrada de dados de forma interativa até que um ID válido seja inserido.
    </li>   
</ul>
 <p>Conceitos aplicados: Estruturas de Repetição</p>

<h3>v2.0 - Refatoração para Orientação a Objetos (POO) </h3>

<ul>
    <li>
        Organização do código em pacotes (`entities` e `main`), separando a lógica de negócio da interface com o usuário.
    </li>
    <li>
      Implementação da classe `Funcionario`, permitindo que o sistema trate dados de forma dinâmica e escalável através de instâncias (`new`).
    </li>
    <li>
        Otimização da lógica de cálculo de bônus, removendo redundâncias e tornando o código mais limpo.
    </li>
</ul>
<p>Conceitos aplicados: Classes, Atributos, Métodos, Pacotes e Instanciação de Objetos.</p>

<h3>v2.1 - Encapsulamento e Construtores </h3>

<ul>
    <li>
        Atributos transformados em `private` com acesso via métodos `Getters` e `Setters`, garantindo a proteção e integridade dos dados.
    </li>
    <li>
      Implementação de uma tabela de cargos (`tab_cod`) como membro de classe. Isso otimiza o uso de memória, pois a lista de cargos é compartilhada entre todas as instâncias, em vez de ser replicada.
    </li>
    <li>
        Uso de construtores para garantir que o objeto nasça com um estado válido.
    </li>
    <li>
        A lógica de cálculo e tradução de cargos foi movida para a entidade `Funcionario`, deixando a classe `App` responsável apenas pela interface com o usuário.
    </li>
    <li>
        Uso da referência de classe (`Funcionario.tab_cod`) para acessar membros estáticos, diferenciando claramente o que pertence à instância (`this`) do que pertence à classe.
    </li>
    <li>
        Retirado um README.md desnecessário na pasta SRC
    </li>
</ul>
<p>Pacotes, Classes, Atributos (Privados e Estáticos), Construtores, Métodos , Encapsulamento e Instanciação de Objetos.</p>


