package vendingmachine;

public class ChangesModule {
    private int changes;

    public ChangesModule(int change){
        this.changes = change;
    }

    public void put(final int changes){
        this.changes += changes;
    }

    public void withdraw(final int changes){
        final int coin = this.changes -= changes;
        if (coin < 0){
            throw new IllegalStateException();
        }
        this.changes -= changes;
    }

    public int getChanges(){
        return changes;
    }

}
