package general;

public abstract class Fighter {
    private double health;
    private double maxHealth;
    private double attack;
    private double hunger;
    protected double sleepHealthFactor = 1.5;
    private Action actionOpponent;

    public Fighter() {
        this(10, 1.5);
    }

    public Fighter(final double maxHealth, final double attack) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
    }

    public abstract Action getAction();

    private void performAction(final Action ownAction) {
        switch (ownAction) {
            case ATTACK:
                attack();
                break;
            case BLOCK:
                block();
                break;
            case EAT:
                eat();
                break;
            case SLEEP:
                sleep();
                break;
            default:
                throw new IllegalArgumentException("Did you forget to put a break statement in your switch block?");
        }
    }

    public void updateState(final Action ownAction, final Action opponentAction, final Fighter opponent) {
        switch(opponentAction) {
            case ATTACK:
                // your own action gets negated since you're under attack, except defence
                if(ownAction != Action.BLOCK) {
                    health -= opponent.getAttackStrength();
                }
                break;
            case BLOCK:
                if(ownAction != Action.ATTACK && ownAction != Action.BLOCK) {
                    health *= 1.2;
                }
            default:
                performAction(ownAction);
        }
        setActionOpponent(opponentAction);
    }

    private void setActionOpponent(final Action actionOpponent) {
        this.actionOpponent = actionOpponent;
    }

    public Action getLastActionOpponent() {
        return actionOpponent;
    }

    private final void attack() {
        health *= 0.97;
    }

    private final double getAttackStrength() {
        return attack;
    }

    private void block() {
        // do nothing
    }

    private final void eat() {
        hunger = hunger - 0.2;
    }

    private final void sleep() {
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
