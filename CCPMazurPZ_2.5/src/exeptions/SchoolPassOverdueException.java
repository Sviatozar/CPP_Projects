package exeptions;

import passes.SchoolPass;

import java.time.YearMonth;

public class SchoolPassOverdueException extends PassWithTermException {
    private SchoolPass pass;

    public SchoolPassOverdueException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public int calculateTermOfOverdue() {
        return (YearMonth.now().getMonth().minus(pass.getMonth().getMonthValue())).getValue();
    }

    @Override
    public String toString() {
        return "SchoolPassOverdueException: Pass expiration date ended " +
                (calculateTermOfOverdue() > 1 ? calculateTermOfOverdue() + " month ago"
                        : calculateTermOfOverdue() + " month ago");
    }
}
