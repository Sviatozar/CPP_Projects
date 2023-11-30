package exeptions;

import passes.RegularPass;

public class RegularPassNotEnoughMoneyException extends Exception {
    private RegularPass pass;

    public RegularPassNotEnoughMoneyException(RegularPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "RegularPassNotEnoughMoneyException: Pass " + pass.getUid() + " don't have enough money. " +
                pass.getAmountOfMoney() + "UAH left";
    }
}
