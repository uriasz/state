public class PoisonedState implements State {

    @Override
    public String move() {
        return "Anda normalmente, mas está envenenado.";
    }

    @Override
    public String attack() {
        return "Ataque normal, mas tossindo veneno.";
    }

    @Override
    public int takeDamage(int baseDamage) {
        return baseDamage;
    }

    @Override
    public int tickEffect(int health) {
        return health - 5; // perde 5 de vida por tick
    }
}
