package com.wt.fryChicken.backword;

import com.wt.fryChicken.except.IngredientSortOutException;
import com.wt.fryChicken.except.OverdraftBalanceException;
import com.wt.fryChicken.food.BaseSetMeal;
import com.wt.fryChicken.kitchen.KitchenAdmin;
import com.wt.fryChicken.storehouse.StoreAdmin;
import com.wt.fryChicken.storehouse.raw.BaseRaw;

import java.util.LinkedList;

public abstract class BackWordAdmin {
    protected Account account;
    
    protected LinkedList<BaseSetMeal> meals;
    
    protected KitchenAdmin kitchenAdmin;
    protected StoreAdmin storeAdmin;

    public BackWordAdmin() throws Account.UserIDExistException {
        account=new Account(0x00,"西二炸鸡店",114514,false);
        meals=new LinkedList<>();
        kitchenAdmin=new KitchenAdmin();
        storeAdmin=new StoreAdmin();
    }

    /**
     * 将会检查后厨容器，是否有已经完成的套餐，如果有，直接取出，没有安排后厨制作
     * 
     * @param meal 要出售的套餐
     */
    public abstract void saleMeal(BaseSetMeal meal) throws IngredientSortOutException;

    /**
     * 通过仓库管理进行进货，并且扣除费用
     *
     * @param raw 进货的对象（要判断是否能直接进货）
     * @param count 进货数量
     */
    public abstract void purchaseIn(BaseRaw raw ,int count) throws OverdraftBalanceException;

    public void update(){
        kitchenAdmin.update();
    }
    
    
}
