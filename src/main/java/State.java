public interface State {
    String move();
    String attack();
    int takeDamage(int baseDamage);
    int tickEffect(int health);
}
