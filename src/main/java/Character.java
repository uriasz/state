public class Character {
    private State state;
    private int health;

    public Character() {
        this.state = new NormalState();
        this.health = 100;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String move() {
        return state.move();
    }

    public String attack() {
        return state.attack();
    }

    public void takeDamage(int baseDamage) {
        int actualDamage = state.takeDamage(baseDamage);
        this.health -= actualDamage;
    }

    public void tick() {
        this.health = state.tickEffect(this.health);
    }

    public int getHealth() {
        return health;
    }

    public String getStateName() {
        return state.getClass().getSimpleName();
    }
}
