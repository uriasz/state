public class HeavyState implements State {

    @Override
    public String move() {
        return "Anda devagar por causa do peso.";
    }

    @Override
    public String attack() {
        return "Ataque normal, mas mais lento.";
    }

    @Override
    public int takeDamage(int baseDamage) {
        return baseDamage;
    }

    @Override
    public int tickEffect(int health) {
        return health; // sem efeito extra
    }
}
