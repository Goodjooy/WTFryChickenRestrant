/*
 * @Author: FrozenString
 * @Date:   2020-10-30 12:25:13
 * @Last Modified by:   FrozenString
 * @Last Modified time: 2020-10-30 19:14:12
 */
package com.wt.fryChicken.backword;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Account {
    // 私有变量
    private static List<Integer> usedIDsList = new LinkedList<>();
    private int id;
    private String name;
    private double balance;
    private boolean isForzen;

    public enum Operator {
        Admin, User
    }

    // 构造函数区
    /*
     * 账号构造函数，要求为账号信息
     */
    public Account(int id, String name, double balance, boolean isForzen) throws UserIDExistException {
        Operator operator = Operator.User;

        if (setID(id)) {
            this.name = name;
            setBalance(balance);
            setIsForzen(isForzen, operator);

        } else {
            throw new UserIDExistException();
        }
    }

    public Account(int id, String name, double balance, boolean isForzen, Operator operator)
            throws UserIDExistException {
        if (setID(id)) {
            this.name = name;
            setBalance(balance);
            setIsForzen(isForzen, operator);

        } else {
            throw new UserIDExistException();
        }

    }

    // 公有接口区
    /**
     * 账号收入相关
     * 
     * @param money 收入金额
     * @return 是否收入成功
     */
    public boolean income(double money) {
        if (isForzen || money > balance || money < 0) {
            return false;
        } else {
            balance += money;
            return true;
        }
    }

    /**
     * 账号支出
     * 
     * @param money 支出金额
     * @return 是否支出成功
     */
    public boolean payout(double money) {
        if (isForzen || money < 0) {
            return false;
        } else {
            balance -= money;
            return true;
        }
    }

    /**
     * 转出函数，向 @target 转账 @money 元
     * 
     * @param target 接受钻入的账号
     * @param money  转出的钱
     * @return 是否转账成功
     */
    public boolean transfer(Account target, double money) {
        return payout(money) && target.income(money);
    }

    /**
     * 修改账号状态，只有管理员有权限修改
     * 
     * @param operator 操作者，用户所有人和其他用户不可修改
     * @return 是否修改成功
     */
    public boolean changeStatus(Operator operator) {
        if (operator == Operator.Admin) {
            isForzen = !isForzen;
            return true;
        } else {
            return false;
        }
    }

    // 静态公有接口区
    /**
     * 对数组中每个账户分发工资
     * 
     * @param accounts 要分发工资的账户
     * @param money   分发工资金额
     */
    public static void payoff(Account[] accounts, double money) {
        for (Account account : accounts) {
            boolean staus = account.income(money);
            if (!staus) {
                System.out.println(account);
            }
        }
    }

    /**
     * 通过用户输入来新建账户，将会自动分配id，不冻结账号 需要通过管理员操作冻结或解冻账号
     * 
     * @return 新建的账号
     * @throws UserIDExistException 当出现ID重复时报错
     */
    public static Account userNewAccount() throws UserIDExistException {
        System.out.println("正在初始化新建账户功能");
        int id = Account.autoID();
        Scanner scanner = new Scanner(System.in);
        // 提示输入

        System.out.println("请输入您的用户名：");
        String name = scanner.next();

        System.out.println("请输入您的账户余额：");
        double balance;
        do {
            balance = scanner.nextDouble();
            if (balance < 0) {
                System.out.println("账户余额不为负数\n请重新输入：");
            }
        } while (balance < 0);
        scanner.close();
        Account t = new Account(id, name, balance, false);
        System.out.printf("\n账户创建成功！信息如下：\n%s", t.toString());
        return t;
    }

    // getter、setter 和 toString
    @Override
    public String toString() {

        return "用户ID->" + id + '\n' + "用户名->" + name + "\n" + "用户账户余额->" + balance + "\n" + "是否被冻结->"
                + (isForzen ? "是" : "否");
    }

    private boolean setID(int id) {
        if (usedIDsList.contains(id)) {
            return false;
        } else {
            this.id = id;
            usedIDsList.add(id);
            return true;
        }
    }

    private void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    private void setIsForzen(boolean isForzen, Operator operator) {
        if (operator == Operator.Admin) {
            this.isForzen = isForzen;
        } else {
            isForzen = false;
        }

    }

    /**
     * 只有用户本人有权修改账户用户名
     * 
     * @param name
     * @param operator
     */
    public boolean CHangeName(String name, Operator operator) {
        if (operator == Operator.User) {
            this.name = name;
            return true;
        } else {
            return false;
        }

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getbalance() {
        return balance;
    }

    public boolean getStatus() {
        return isForzen;
    }

    // 私有接口区
    static private int autoID() {
        return ((LinkedList<Integer>) usedIDsList).getLast() + 1;

    }

    private void updateUnusedID() {
        // TODO: 在销毁账号时时使id能复用
    }

    class UserIDExistException extends Exception {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
    };

}
