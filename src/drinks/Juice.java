package drinks;

import java.time.LocalDate;

public class Juice extends Drink {

	public Juice(String name, double rawPices, LocalDate produceDate) {
        super(name, rawPices, produceDate,2);
    }    
    public Juice(String name){
        super(name);
    }
    public Juice(String name,double rawPices){
        super(name);
        this.rawPices = rawPices;
        status=statuses.NAME_AND_PICES;
    }
}
