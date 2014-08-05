package animal;

public abstract class Dog extends Animal{

    @Override
    public final void sleep() {
        final double sleepHealthFactor = 1.5;
        health = health * sleepHealthFactor > maxHealth ? maxHealth : health * sleepHealthFactor;
        hunger += 0.2;
    }

}
