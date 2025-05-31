public class Main {
    public static void main(String[] args) {
        Character hero = new Character();

        System.out.println("=== Personagem criado ===");
        System.out.println("Estado atual: " + hero.getStateName());
        System.out.println("Vida atual: " + hero.getHealth());
        System.out.println();

        // Normal
        System.out.println("[Normal]");
        System.out.println(hero.move());
        System.out.println(hero.attack());
        hero.takeDamage(10);
        System.out.println("Vida após dano: " + hero.getHealth());
        System.out.println();

        // Rage
        hero.setState(new RageState());
        System.out.println("[Enraivecido]");
        System.out.println(hero.move());
        System.out.println(hero.attack());
        hero.takeDamage(10);
        System.out.println("Vida após dano: " + hero.getHealth());
        System.out.println();

        // Poisoned
        hero.setState(new PoisonedState());
        System.out.println("[Envenenado]");
        hero.tick();
        System.out.println("Vida após tick de veneno: " + hero.getHealth());
        System.out.println();

        // Heavy
        hero.setState(new HeavyState());
        System.out.println("[Pesado]");
        System.out.println(hero.move());
        hero.takeDamage(10);
        System.out.println("Vida após dano: " + hero.getHealth());
        System.out.println();

        // Broken Armor
        hero.setState(new BrokenArmorState());
        System.out.println("[Armadura Quebrada]");
        hero.takeDamage(10);
        System.out.println("Vida após dano dobrado: " + hero.getHealth());
        System.out.println();

        // Stunned
        hero.setState(new StunnedState());
        System.out.println("[Atordoado]");
        System.out.println(hero.move());
        System.out.println(hero.attack());
        System.out.println("Vida final: " + hero.getHealth());
    }
}
