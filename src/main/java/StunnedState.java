public class StunnedState implements State {

    @Override
    public String move() {
        return "Não consegue se mover.";
    }

    @Override
    public String attack() {
        return "Não consegue atacar.";
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
