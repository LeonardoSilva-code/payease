# API Restful em Spring com Kotlin - payease

Esta é uma API Restful desenvolvida em Spring com Kotlin que oferece funcionalidades de gerenciamento de usuários e transferências de dinheiro. A API suporta dois tipos de usuários: comuns e lojistas, com a capacidade de realizar transferências entre eles.

Tecnologias Utilizadas
- Spring Boot
- Kotlin
- Gradle

Temos dois tipos de utilizadores: os utilizadores comuns e os lojistas. Ambos possuem uma carteira com fundos e têm a capacidade de realizar transferências entre si. Nesta descrição, vamos focar especificamente no processo de transferência de dinheiro entre dois utilizadores.
Para ambos os tipos de utilizadores, é necessário fornecer as seguintes informações: Nome Completo, CPF, endereço de e-mail e senha. É fundamental que tanto o CPF/CNPJ como os endereços de e-mail sejam únicos no sistema, ou seja, o sistema deve permitir apenas um registo com o mesmo CPF ou endereço de e-mail.
Os utilizadores têm a capacidade de enviar dinheiro, ou seja, efetuar transferências, tanto para lojistas como entre outros utilizadores. Por outro lado, os lojistas só recebem transferências e não têm a capacidade de enviar dinheiro a outros utilizadores.
Antes de efetuar qualquer transferência, é importante que o sistema valide se o utilizador possui fundos suficientes na sua carteira para realizar a transação desejada. Essa validação é necessária para evitar transações que não podem ser concluídas devido a fundos insuficientes.
A operação de transferência deve ser tratada como uma transação, o que significa que, em caso de qualquer inconsistência ou erro, a transação deve ser revertida, e o dinheiro deve ser devolvido à carteira do utilizador que iniciou a transferência. Isso garante a integridade e segurança das transações no sistema.
Resumindo, o sistema possui dois tipos de utilizadores, com funcionalidades distintas, e garante a unicidade de CPFs e endereços de e-mail no sistema. Além disso, as transferências são cuidadosamente validadas quanto à disponibilidade de fundos e tratadas como transações reversíveis para assegurar a confiabilidade das operações financeiras.
