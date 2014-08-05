package animal;

public abstract class Bird extends Animal {

    @Override
    public double block() {
        return 0;
    }

    @Override
    public final void sleep() {
        final int sleepHealthFactor = 3;
        health = health * sleepHealthFactor > maxHealth ? maxHealth : health * sleepHealthFactor;
        hunger += 0.2;
    }
}
