import exeptions.RegularPassNotEnoughMoneyException;
import exeptions.SchoolPassOverdueException;
import exeptions.SchoolPassTripFinishedException;
import exeptions.StudentPassOverdueException;
import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

/**
 * Class simulates metro turnstile.<br>
 * Method {@code validateEntryPermission()} prohibits or permits passage through the turnstile.
 *
 * @author Sviatozar Mazur
 * @since 2023
 */
public class Turnstile {
    /**
     * Check conditions for passage through the turnstile.<br>
     *
     * @param pass check type to choose way of validation.
     * @throws SchoolPassOverdueException         if school pass outdated.
     * @throws SchoolPassTripFinishedException    if school pass has run out of trips per month
     * @throws RegularPassNotEnoughMoneyException if the regular pass has run out of money in the account
     * @throws StudentPassOverdueException        if student pass expired
     */
    public void validateEntryPermission(MetroPass pass) throws RegularPassNotEnoughMoneyException,
            SchoolPassOverdueException, SchoolPassTripFinishedException, StudentPassOverdueException {
        if (pass instanceof SchoolPass schoolPass) {
            if (schoolPass.getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassOverdueException((SchoolPass) pass);
            } else if (((SchoolPass) pass).getCountOfTrip() == 0) {
                KyivSmartCard.addProhibition();
                throw new SchoolPassTripFinishedException((SchoolPass) pass);
            } else {
                ((SchoolPass) pass).setCountOfTrip(((SchoolPass) pass).getCountOfTrip() - 1);
                KyivSmartCard.addPermission();
            }
        } else if (pass instanceof StudentPass) {
            if (((StudentPass) pass).getMonth().isBefore(YearMonth.now())) {
                KyivSmartCard.addProhibition();
                throw new StudentPassOverdueException((StudentPass) pass);
            } else {
                KyivSmartCard.addPermission();
            }
        } else if (pass instanceof RegularPass) {
            if (((RegularPass) pass).getAmountOfMoney() < KyivSmartCard.FARE) {
                KyivSmartCard.addProhibition();
                throw new RegularPassNotEnoughMoneyException((RegularPass) pass);
            } else {
                KyivSmartCard.addPermission();
                KyivSmartCard.substractFair((RegularPass) pass);
            }
        }
    }
}
