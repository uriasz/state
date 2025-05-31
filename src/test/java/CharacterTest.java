import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Character hero;

    @BeforeEach
    public void setup() {
        hero = new Character();
    }

    @Test
    public void testInitialStateIsNormal() {
        assertEquals("NormalState", hero.getStateName());
        assertEquals(100, hero.getHealth());
    }

    @Test
    public void testNormalStateBehavior() {
        assertEquals("Anda normalmente.", hero.move());
        assertEquals("Ataque normal.", hero.attack());

        hero.takeDamage(10);
        assertEquals(90, hero.getHealth());
    }

    @Test
    public void testRageStateBehavior() {
        hero.setState(new RageState());

        assertEquals("Anda rapidamente.", hero.move());
        assertEquals("Ataque FURIOSO!", hero.attack());

        hero.takeDamage(10);
        assertEquals(90, hero.getHealth());
    }

    @Test
    public void testStunnedStateBehavior() {
        hero.setState(new StunnedState());

        assertEquals("Não consegue se mover.", hero.move());
        assertEquals("Não consegue atacar.", hero.attack());

        hero.takeDamage(10);
        assertEquals(90, hero.getHealth());
    }

    @Test
    public void testPoisonedStateTickEffect() {
        hero.setState(new PoisonedState());

        int initialHealth = hero.getHealth();
        hero.tick();
        assertEquals(initialHealth - 5, hero.getHealth());

        // Verifica que movimento e ataque continuam com mensagem correta
        assertTrue(hero.move().contains("envenenado"));
        assertTrue(hero.attack().contains("veneno"));
    }

    @Test
    public void testHeavyStateBehavior() {
        hero.setState(new HeavyState());

        assertEquals("Anda devagar por causa do peso.", hero.move());
        assertEquals("Ataque normal, mas mais lento.", hero.attack());

        hero.takeDamage(10);
        assertEquals(90, hero.getHealth());
    }

    @Test
    public void testBrokenArmorStateDamageMultiplier() {
        hero.setState(new BrokenArmorState());

        // Dano dobrado
        hero.takeDamage(10);
        assertEquals(80, hero.getHealth());
    }

    @Test
    public void testStateSwitchingKeepsHealth() {
        hero.takeDamage(20);
        int healthAfterDamage = hero.getHealth();

        hero.setState(new PoisonedState());
        assertEquals(healthAfterDamage, hero.getHealth());

        hero.setState(new RageState());
        assertEquals(healthAfterDamage, hero.getHealth());
    }
}
