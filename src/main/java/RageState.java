public class RageState implements State {

    @Override
    public String move() {
        return "Anda rapidamente.";
    }

    @Override
    public String attack() {
        return "Ataque FURIOSO!";
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
