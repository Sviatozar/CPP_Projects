package exeptions;

import passes.SchoolPass;

public class SchoolPassTripFinishedException extends Exception {
    private SchoolPass pass;

    public SchoolPassTripFinishedException(SchoolPass pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "SchoolPassTripFinishedException: Pass " + pass.getUid() + " have no more trip";
    }
}
