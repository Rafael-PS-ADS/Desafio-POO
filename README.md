✨ Este projeto demonstra os conceitos de Programação Orientada a Objetos (POO) em Java, simulando um sistema de bootcamp onde desenvolvedores podem se inscrever em cursos e mentorias, progredir em seu aprendizado e calcular seu XP total. 🚀

### Conceitos de POO Aplicados 💡

Este projeto utiliza diversos conceitos fundamentais da Programação Orientada a Objetos para estruturar a aplicação de forma modular, reutilizável e extensível:

* **Abstração:** 🎭
    * A classe `Conteudo` é uma classe abstrata, definindo um modelo genérico para qualquer tipo de conteúdo educacional (curso ou mentoria). Ela possui atributos comuns (`titulo`, `descricao`) e um método abstrato `calcularXP()` que deve ser implementado pelas subclasses. Isso abstrai a noção de "conteúdo" sem se preocupar com os detalhes específicos de um curso ou mentoria.

* **Herança:** 🌳
    * As classes `Curso` e `Mentoria` estendem a classe abstrata `Conteudo`. Isso significa que `Curso` e `Mentoria` herdam os atributos e métodos de `Conteudo`, e também implementam o método `calcularXP()` de forma específica para cada tipo de conteúdo. Esta é uma demonstração clara de **hierarquia de classes**, onde `Conteudo` é a superclasse (ou classe pai) e `Curso` e `Mentoria` são subclasses (ou classes filhas).

* **Polimorfismo:** 🔄
    * O método `calcularXP()` é um exemplo de polimorfismo. Embora definido na classe abstrata `Conteudo`, sua implementação varia em `Curso` (baseado na carga horária) e `Mentoria` (valor fixo). Isso permite que o sistema trate objetos `Curso` e `Mentoria` de forma genérica como `Conteudo` ao calcular o XP total de um desenvolvedor, chamando o `calcularXP()` apropriado em tempo de execução.

* **Encapsulamento:** 🔒
    * Todos os atributos das classes (`titulo`, `descricao`, `cargaHoraria`, `data`, `nome`, `devsInscritos`, `conteudosInscritos`, `conteudosConcluidos`, etc.) são declarados como `private` ou `protected`. O acesso a esses atributos é feito exclusivamente através de métodos `public` (getters e setters). Isso garante que a representação interna dos objetos esteja protegida e que as modificações sejam controladas, promovendo a integridade dos dados.

* **Reutilização de Código:** ♻️
    * A herança é o principal mecanismo para reutilização de código neste projeto. Atributos e comportamentos comuns (como `titulo` e `descricao` em `Conteudo`) são definidos uma única vez na superclasse e reutilizados pelas subclasses, evitando duplicação de código.

### Classes 📚

#### `Conteudo.java` (Classe Abstrata)
Representa um conteúdo genérico que pode ser um curso ou uma mentoria.
* **Atributos:**
    * `XP_PADRAO`: Constante `double` para o XP padrão (10.0).
    * `titulo`: `String` para o título do conteúdo.
    * `descricao`: `String` para a descrição do conteúdo.
* **Métodos:**
    * `calcularXP()`: Método abstrato que calcula o XP do conteúdo.
    * Getters e Setters para `titulo` e `descricao`.

#### `Curso.java` ✏️
Estende `Conteudo`, representando um curso específico.
* **Atributos:**
    * `cargaHoraria`: `int` para a carga horária do curso.
* **Métodos:**
    * `calcularXP()`: Implementa o cálculo de XP, somando `XP_PADRAO` com a `cargaHoraria`.
    * Getters e Setters para `cargaHoraria`.
    * `toString()`: Sobrescrito para exibir informações do curso.

#### `Mentoria.java` 🧑‍🏫
Estende `Conteudo`, representando uma mentoria.
* **Atributos:**
    * `data`: `LocalDate` para a data da mentoria.
* **Métodos:**
    * `calcularXP()`: Implementa o cálculo de XP, somando `XP_PADRAO` com um valor fixo de 20.0d.
    * Getters e Setters para `data`.
    * `toString()`: Sobrescrito para exibir informações da mentoria.

#### `Bootcamp.java` 🚀
Representa um bootcamp que agrupa conteúdos e desenvolvedores inscritos.
* **Atributos:**
    * `nome`: `String` para o nome do bootcamp.
    * `descricao`: `String` para a descrição do bootcamp.
    * `dataInicial`: `LocalDate` constante, inicializada com a data atual.
    * `dataFinal`: `LocalDate` constante, inicializada 45 dias após a `dataInicial`.
    * `devsInscritos`: `Set` de `Dev` para armazenar os desenvolvedores inscritos (usa `HashSet`).
    * `conteudos`: `Set` de `Conteudo` para armazenar os conteúdos do bootcamp (usa `LinkedHashSet` para manter a ordem de inserção).
* **Métodos:**
    * Getters e Setters para todos os atributos mutáveis.
    * `equals()` e `hashCode()`: Sobrescritos para comparação de objetos `Bootcamp`.

#### `Dev.java` 🧑‍💻
Representa um desenvolvedor que pode se inscrever em bootcamps e progredir nos conteúdos.
* **Atributos:**
    * `nome`: `String` para o nome do desenvolvedor.
    * `conteudosInscritos`: `Set` de `Conteudo` para os conteúdos em que o dev está inscrito (usa `LinkedHashSet`).
    * `conteudosConcluidos`: `Set` de `Conteudo` para os conteúdos que o dev concluiu (usa `LinkedHashSet`).
* **Métodos:**
    * `inscreverBootcamp(Bootcamp bootcamp)`: Adiciona todos os conteúdos do bootcamp aos `conteudosInscritos` do dev e adiciona o dev à lista de `devsInscritos` do bootcamp.
    * `progredir()`: Remove o primeiro conteúdo dos `conteudosInscritos` e o adiciona aos `conteudosConcluidos`. Se não houver conteúdos inscritos, imprime uma mensagem de erro.
    * `calcularTotalXP()`: Calcula a soma do XP de todos os `conteudosConcluidos` do dev.
    * Getters e Setters para todos os atributos.
    * `equals()` e `hashCode()`: Sobrescritos para comparação de objetos `Dev`.

#### `Main.java` 🏁
Classe principal para testar as funcionalidades do sistema.
* **`main` método:**
    * Cria instâncias de `Curso` e `Mentoria`.
    * Cria uma instância de `Bootcamp` e adiciona os cursos e a mentoria a ele.
    * Cria instâncias de `Dev`.
    * Demonstra a inscrição de desenvolvedores no bootcamp.
    * Simula a progressão dos desenvolvedores nos conteúdos.
    * Imprime os conteúdos inscritos, conteúdos concluídos e o XP total de cada desenvolvedor.

### Como Compilar e Rodar ⚙️

````bash
# Salve todos os arquivos .java no mesmo diretório.
# Abra um terminal ou prompt de comando e navegue até o diretório onde os arquivos estão salvos.

# Compile os arquivos Java
javac *.java

# Execute a classe Main
java Main
