package com.wt.fryChicken.storehouse.raw;

import com.wt.fryChicken.kitchen.cooker.BaseCooker;
import com.wt.fryChicken.kitchen.cooker.Operate;

import java.time.LocalDate;

//食物原料抽象类
public abstract class BaseRaw {
    //保质期:天 保质期为-1表示为无保质期
    protected int QGP=-1;
    //生产日期
    protected LocalDate productData;
    //价格
    protected double prices;
    //产品名称
    protected String name;

    protected BaseRaw(String name,int QGP, LocalDate productData, double prices){
        this.name = name;
        this.QGP = QGP;
        this.productData = productData;
        this.prices = prices;
    }
    public boolean isCanBeUse(LocalDate today){
        if(QGP==-1)return true;
        return productData.plusDays(QGP).isAfter(today);
    }

    public double getPrices() {
        return prices;
    }

    public int getQGP() {
        return QGP;
    }

    public LocalDate getProductData() {
        return productData;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isCanBeOperate(Operate operate);

    /**
     * 对自生进行一个标准时常的某种操作
     *
     * @param operate 进行操作
     * @return 操作是否成功,返回操作后对象，失败时返回null
     */
    public abstract BaseRaw setOperate(Operate operate);
}
