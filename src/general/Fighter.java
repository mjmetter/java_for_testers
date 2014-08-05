package general;

public abstract class Fighter {
    protected double health;
    protected double maxHealth;
    protected double attack;
    protected double defence;

    public Fighter() {
        this(10);
    }

    public Fighter(final int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public final double attack() {
        health -= 0.05;
        return attack;
    }

    public double block() {
        return defence;
    }

    public abstract Action getAction(Fighter opponent);

    public abstract void performAction(final Action ownAction);

    public void updateState(final Action ownAction, final Action opponentAction, final Fighter opponent) {
        switch(opponentAction) {
            case BLOCK:
                performAction(ownAction);
                break;
            case EAT:
                performAction(ownAction);
                break;
            case SLEEP:
                performAction(ownAction);
                break;
            case ATTACK:
                if(ownAction == Action.ATTACK) {
                    health -= opponent.attack();
                }
                break;
            default:
                throw new IllegalArgumentException("Did you forget to put a break statement in your switch block?");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHealth() {
        return health;
    }
}
