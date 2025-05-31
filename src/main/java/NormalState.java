public class NormalState implements State {

    @Override
    public String move() {
        return "Anda normalmente.";
    }

    @Override
    public String attack() {
        return "Ataque normal.";
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
