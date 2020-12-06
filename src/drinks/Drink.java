package drinks;

import java.time.LocalDate;

public abstract class Drink {
    // 变量
    // 公开的变量（所有对象可见）
    public static enum statuses {
        NAME_ONLY, NAME_AND_PICES, FULL
    }

    // 保护的变量（继承子类可见，其他不可见）
    protected String name;
    protected double rawPices;
    protected LocalDate produceDate;
    // 保质期
    protected int QPD;

    protected statuses status;
    // 私有变量

    // 构造函数
    public Drink(String name, double rawPices, LocalDate produceDate, int qPD) {
        this.name = name;
        this.rawPices = rawPices;
        this.produceDate = produceDate;
        QPD = qPD;

        status = statuses.FULL;
    }

    public Drink(String name) {
        this.name = name;

        status = statuses.NAME_ONLY;

    }

    // 公开接口

    public String getName() {
        return name;
    }

    public double getRawPices() {
        return rawPices;
    }

    /*
     * 判断是否超过保质期
     * 
     * @return 超过保质期，返回true,否则返回false
     */
    public final boolean isOverQPD(LocalDate now) {
        if (status != statuses.FULL)
            return false;
        return produceDate.plusDays(QPD).isBefore(now);
    }

    @Override
    public String toString() {
        return name;
    }

    public statuses getStatus() {
        return status;
    }

    public boolean equals(Drink drink) {
        if (status != statuses.FULL || drink.getStatus() != statuses.FULL)
            return (drink.getName().equals(name));
        else {
            return (drink.getName().equals(name) && drink.produceDate.equals(produceDate));
        }
    }
    // 保护接口
    // 私有接口

}
