package ru.skillbench.tasks.basics.control;

import static java.lang.Math.sin;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {

    public ControlFlowStatements1Impl(){}

    @Override
    public float getFunctionValue(float x) {
        return (x > 0) ? (float) (2 * sin(x)) : 6 - x;
    }

    @Override
    public String decodeWeekday(int weekday) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return daysOfWeek[weekday - 1];
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 5; j++)
                array[i][j] = i * j;
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int minValue = array[0][0];
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 5; ++j)
                if (array[i][j] < minValue) {
                    minValue = array[i][j];
                }
        return minValue;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit deposit = new BankDeposit();
        deposit.amount = 1000;
        while (deposit.amount <= 5000) {
            deposit.amount += P / 100 * deposit.amount;
            deposit.years++;
        }
        return deposit;
    }
}
