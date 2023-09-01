# API Restful em Spring com Kotlin - payease

Esta é uma API Restful desenvolvida em Spring com Kotlin que oferece funcionalidades de gerenciamento de usuários e transferências de dinheiro. A API suporta dois tipos de usuários: comuns e lojistas, com a capacidade de realizar transferências entre eles.

Tecnologias Utilizadas
- Spring Boot
- Kotlin
- Gradle

Temos dois tipos de usuários: os usuários comuns e os lojistas. Ambos possuem uma carteira com fundos e têm a capacidade de realizar transferências entre si. Ambos os tipos de usuários possuem: Nome Completo, CPF, endereço de e-mail e senha. Tanto o CPF/CNPJ como os endereços de e-mail são únicos no sistema, ou seja, o sistema deve permitir apenas um registo com o mesmo CPF ou endereço de e-mail.
Os usuários comuns têm a capacidade de enviar dinheiro, ou seja, efetuar transferências, tanto para lojistas como entre outros usuários comuns. Por outro lado, os lojistas só recebem transferências e não têm a capacidade de enviar dinheiro a outros usuários.
Antes de efetuar qualquer transferência, é importante que o sistema valide se o usuários possui fundos suficientes na sua carteira para realizar a transação desejada.
A operação de transferência deve ser tratada como uma transação, o que significa que, em caso de qualquer inconsistência ou erro, a transação deve ser revertida, e o dinheiro deve ser devolvido à carteira do utilizador que iniciou a transferência.
