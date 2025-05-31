
![7a56e5658960ee62375b8d8c979a7b9e-ezgif com-resize](https://github.com/user-attachments/assets/d57eee9a-9a01-40b4-b135-5c525f49ada9)


# ❀ Sistema de Estados para Personagem RPG - Padrão State

## ❀ Visão geral

Este projeto implementa o padrão de projeto **State** aplicado a um personagem de RPG, que pode assumir diversos estados. Cada estado modifica o comportamento do personagem para se mover, atacar, receber dano e sofrer efeitos contínuos, como envenenamento.

## ❀ O que contém neste projeto?

- **Estados implementados:**  
  - Normal — comportamento padrão  
  - Enraivecido (Rage) — anda rápido e ataca com mais força  
  - Atordoado (Stunned) — não anda nem ataca  
  - Envenenado (Poisoned) — perde vida com o tempo  
  - Pesado (Heavy) — anda mais devagar por carregar peso  
  - Armadura Quebrada (BrokenArmor) — toma dano dobrado  

- **Personagem (Contexto):**  
  - Mantém o estado atual  
  - Delegar comportamento para o estado atual  
  - Controla vida, recebe dano e aplica efeitos periódicos  

- **Main:**  
  - Demonstra a troca entre estados e os efeitos no personagem, retornando resultados para testes ou exibição  

- **Testes:**  
  - Validação dos comportamentos de cada estado  
  - Verificação dos efeitos sobre vida, movimento, ataque e troca de estado  

## ❀ Como o padrão State foi aplicado?

O padrão State permite que o personagem altere seu comportamento em tempo de execução simplesmente trocando o objeto de estado que ele utiliza para executar suas ações.

- A interface `State` define os métodos que todos os estados devem implementar:  
  - `move()`, `attack()`, `takeDamage(int)`, e `tickEffect(int)`  

- Cada estado concreto (`NormalState`, `RageState`, etc) implementa a interface e define seu comportamento específico.

- O personagem (`Character`) mantém uma referência ao estado atual e delega suas ações para esse estado, sem precisar conhecer detalhes da implementação, o que deixa o código mais modular e fácil de estender.

Por exemplo, no estado `BrokenArmorState`, o personagem sofre dano dobrado. No estado `PoisonedState`, a cada tick ele perde vida.

## ❀ Funcionamento do personagem

- O personagem inicia no estado `NormalState` com 100 pontos de vida.  
- Pode trocar seu estado a qualquer momento, alterando seus comportamentos.  
- Recebe dano pelo método `takeDamage`, que é afetado pelo modificador do estado atual.  
- A cada "tick" do jogo, o método `tick()` é chamado para aplicar efeitos periódicos, como o veneno.  
- Os métodos `move()` e `attack()` retornam descrições em texto do comportamento naquele estado.

## ❀ Sobre os testes

- Os testes utilizam JUnit 5 para assegurar que:  
  - O estado inicial é `NormalState` e a vida começa em 100.  
  - Cada estado retorna as respostas corretas para os métodos `move()` e `attack()`.  
  - O dano é aplicado corretamente, incluindo multiplicadores no estado `BrokenArmorState`.  
  - O efeito de perda de vida no estado `PoisonedState` funciona no método `tick()`.  
  - A troca de estados não altera a vida do personagem imediatamente.

- Esses testes garantem a integridade do código, facilitando a adição de novos estados ou alterações nas regras.

## ❀ Como rodar o projeto

- Separe as classes em arquivos `.java` distintos conforme suas definições.  
- Compile o projeto utilizando o compilador Java (JDK 8 ou superior recomendado).  
- Execute a classe `Main` para rodar a demonstração, que retorna uma lista de strings com o comportamento do personagem para validação ou exibição.  
- Utilize JUnit 5 para executar os testes automaticamente e validar o comportamento esperado.

## ❀ Possíveis evoluções

- Implementar novos estados, como congelado, invisível, entre outros.  
- Integrar com uma interface gráfica utilizando as mensagens retornadas para exibição visual.  
- Criar um loop de jogo que atualize o personagem e aplique efeitos periodicamente.  
- Implementar interações entre personagens com estados variados.

## ❀ Conclusão 

O padrão State deixa o código modular, extensível e fácil de manter, especialmente em sistemas onde objetos mudam frequentemente de comportamento, como jogos. A estrutura permite adicionar novos estados de forma simples, criando uma nova classe e alterando o estado do personagem, sem modificar o código existente.
