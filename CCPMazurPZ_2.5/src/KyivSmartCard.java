import passes.MetroPass;
import passes.RegularPass;
import passes.SchoolPass;
import passes.StudentPass;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Class for creating passes for turnstile and counting access permissions and prohibitions.<br>
 * Constants — {@code COUNT_OF_SCHOOL_TRIP_PER_MONTH}, {@code FARE}.<br>
 * {@link ArrayList<MetroPass>} {@code internalCardStorage} used as storage for passes.<br>
 * Variables {@code countOfPermissions}, {@code countOfProhibitions} used to count numbers of access denies and access granting.<br>
 * Methods {@code addPermission}, {@code addProhibition} to increment {@code countOfPermissions}, {@code countOfProhibitions}.
 *
 * @author Sviatozar Mazur
 * @since 2023
 */
public class KyivSmartCard {
    /**
     * Amount of trips per month.
     */
    public static final int COUNT_OF_SCHOOL_TRIP_PER_MONTH = 50;
    /**
     * Ticket price.
     */
    public static final int FARE = 8;
    /**
     * {@link ArrayList<MetroPass>} storage for passes.
     */
    private static ArrayList<MetroPass> internalCardStorage = new ArrayList<>();
    /**
     * Counter of permissions.
     */
    private static int countOfPermissions;
    /**
     * Counter of prohibitions.
     */
    private static int countOfProhibitions;

    /**
     * Method create determined pass depending on type from {@link PassType} enum.
     *
     * @param passType types of passes.
     * @return {@link MetroPass}
     * @throws InputMismatchException if parameter is inappropriate to enum.
     */
    public static MetroPass createPass(PassType passType) {
        switch (passType) {
            case SCHOOL_PASS -> {
                SchoolPass schoolPass = new SchoolPass(COUNT_OF_SCHOOL_TRIP_PER_MONTH);
                internalCardStorage.add(schoolPass);
                return schoolPass;
            }
            case STUDENT_PASS -> {
                StudentPass studentPass = new StudentPass();
                internalCardStorage.add(studentPass);
                return studentPass;
            }
            case REGULAR_PASS -> {
                RegularPass regularPass = new RegularPass();
                internalCardStorage.add(regularPass);
                return regularPass;
            }
        }
        throw new InputMismatchException();
    }

    /**
     * Add one prohibition to counter
     */
    public static void addProhibition() {
        countOfProhibitions++;
    }

    /**
     * Add one permission to counter
     */
    public static void addPermission() {
        countOfPermissions++;
    }

    /**
     * @return int {@code countOfProhibition}
     */
    public static int getCountOfProhibitions() {
        return countOfProhibitions;
    }

    /**
     * @return int {@code countOfPermissions}
     */
    public static int getCountOfPermissions() {
        return countOfPermissions;
    }

    /**
     * Refill {@link RegularPass}.
     *
     * @param regularPass with we want to refill.
     * @param founds      amount of money.
     */
    public static void addFounds(RegularPass regularPass, int founds) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() + founds);
    }

    /**
     * @return int sum of prohibitions and permits.
     */
    public static int getTotalCountOfOverdueAndEmptyPass() {
        return countOfProhibitions + countOfPermissions;
    }

    /**
     * Pay the fare from {@link RegularPass}.
     *
     * @param regularPass pass we use to pay.
     */
    public static void substractFair(RegularPass regularPass) {
        regularPass.setAmountOfMoney(regularPass.getAmountOfMoney() - FARE);
    }
}
