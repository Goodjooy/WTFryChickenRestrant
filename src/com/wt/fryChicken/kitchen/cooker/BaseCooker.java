package com.wt.fryChicken.kitchen.cooker;

import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.util.LinkedList;

//厨具抽象类型
public abstract class BaseCooker {
    public enum Energy {
        ELECT, GAS
    }



    //能源使用
    Energy energy;
    boolean status;
    //标准容积
    int containSize;
    //容器
    LinkedList<BaseRaw> OperatingList;
    LinkedList<BaseRaw> DoneList;

    /**
     * 会对加入的原料进行处理，对该厨具操作可行就加入
     *
     * @param baseRawLinkedList 加入待处理的原料
     * @return  成功加入的原料个数
     */
    public abstract int SetRaw(LinkedList<BaseRaw> baseRawLinkedList);

    //状态跟新
    public abstract void update();

    /**
     * 取出已经完成的产物
     *
     * @param baseRawLinkedList 需要取出的产品
     * @return 成功取出个数
     */
    public abstract int getProduce(LinkedList<BaseRaw> baseRawLinkedList);

    /**
     * 获取已经完成的食物
     * @return 返回已经完成队列
     */
    public abstract LinkedList<BaseRaw> getDone();

}
