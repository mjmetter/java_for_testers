package general;

public abstract class Fighter {
    private double health;
    private double maxHealth;
    private double attack;
    private double hunger;
    protected double sleepHealthFactor = 1.5;

    public Fighter() {
        this(10, 1.5);
    }

    public Fighter(final double maxHealth, final double attack) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
    }

    public final double attack() {
        health *= 0.9;
        return attack;
    }

    public void block() {
        // do nothing
    }

    public abstract Action getAction(Fighter opponent);

    public abstract void performAction(final Action ownAction);

    public void updateState(final Action ownAction, final Action opponentAction, final Fighter opponent) {
        switch(opponentAction) {
            case ATTACK:
                // your own action gets negated since you're under attack, except defence
                if(ownAction != Action.BLOCK) {
                    health -= opponent.attack();
                }
                break;
            case BLOCK:
                if(ownAction != Action.ATTACK && ownAction != Action.BLOCK) {
                    health *= 1.2;
                }
            default:
                performAction(ownAction);
        }
    }

    public final void sleep() {
        health = health * sleepHealthFactor > maxHealth ? maxHealth : health * sleepHealthFactor;
        hunger += 0.2;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() { return maxHealth; }

}
