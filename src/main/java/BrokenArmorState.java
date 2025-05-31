public class BrokenArmorState implements State {

    @Override
    public String move() {
        return "Anda normalmente, mas vulnerável.";
    }

    @Override
    public String attack() {
        return "Ataque normal.";
    }

    @Override
    public int takeDamage(int baseDamage) {
        return baseDamage * 2; // dano dobrado
    }

    @Override
    public int tickEffect(int health) {
        return health; // sem efeito extra
    }
}
