import exeptions.RegularPassNotEnoughMoneyException;
import exeptions.SchoolPassOverdueException;
import exeptions.SchoolPassTripFinishedException;
import exeptions.StudentPassOverdueException;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.time.YearMonth;

public class PassTest {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile();
        var pass = KyivSmartCard.createPass(PassType.SCHOOL_PASS);
        SchoolPass schoolPass = (SchoolPass) pass;
        schoolPass.setMonth(YearMonth.of(2022, 1));
        try {
            for (int i = 0; i < 51; i++) {
                turnstile.validateEntryPermission(schoolPass);
            }
        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
        var pass1 = KyivSmartCard.createPass(PassType.STUDENT_PASS);
        StudentPass studentPass = (StudentPass) pass1;
        studentPass.setMonth(YearMonth.of(2022, 1));
        try {
            for (int i = 0; i < 51; i++) {
                turnstile.validateEntryPermission(studentPass);
            }
        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
        var pass2 = KyivSmartCard.createPass(PassType.SCHOOL_PASS);
        SchoolPass schoolPass2 = (SchoolPass) pass2;
        schoolPass2.setMonth(YearMonth.of(2024, 1));
        try {
            for (int i = 0; i < 51; i++) {
                turnstile.validateEntryPermission(schoolPass2);
            }
        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
        var pass3 = KyivSmartCard.createPass(PassType.REGULAR_PASS);
        RegularPass regularPass = (RegularPass) pass3;
        regularPass.setAmountOfMoney(0);
        try {
            for (int i = 0; i < 2; i++) {
                turnstile.validateEntryPermission(regularPass);
            }
        } catch (SchoolPassOverdueException | StudentPassOverdueException | SchoolPassTripFinishedException |
                 RegularPassNotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}