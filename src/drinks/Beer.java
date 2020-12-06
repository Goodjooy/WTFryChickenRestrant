package drinks;

import java.time.LocalDate;

public class Beer extends Drink {
    private float acholicLevel;

    public Beer(String name, double rawPices, LocalDate produceDate, float acholicLevel) {
        super(name, rawPices, produceDate, 30);
        this.setAcholicLevel(acholicLevel);
    }

    public Beer(String name) {
        super(name);
    }

    public Beer(String name, double rawPices,float acholicLevel) {
        super(name);
        this.rawPices = rawPices;
        this.acholicLevel=acholicLevel;
        status = statuses.NAME_AND_PICES;
    }

    public float getAcholicLevel() {
        return acholicLevel;
    }

    private void setAcholicLevel(float acholicLevel) {
        this.acholicLevel = acholicLevel;
    }

}
