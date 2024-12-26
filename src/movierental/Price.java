package movierental;

abstract class Price {
    int BASE_FREQUENT_RENTAL_POINT = 1;

    public float getBorrowPeriod() {
        return 0;
    }
    public float getBaseFee() {
        return 0;
    }
    public float getLateFeePerDay() {
        return 0;
    }

    public double calculateRentalFee(int days) {
        double fee = getBaseFee();
		if (days > getBorrowPeriod()) fee += getLateFeePerDay() * (days - getBorrowPeriod());
        return fee;
    }

    public int calculateFrequentRenterPoint(int days) {
        return BASE_FREQUENT_RENTAL_POINT;
    }
}

class RegularPrice extends Price {

    int BORROW_PERIOD = 2;
    float BASE_FEE = 2;
    float LATE_FEE_PER_DAY = 1.5f;

    @Override
    public float getBaseFee() {
        return 2;
    }

    @Override
    public float getBorrowPeriod() {
        return 2;
    }

    @Override
    public float getLateFeePerDay() {
        return 1.5f;
    }
}

class ChildrenPrice extends Price {

    int BORROW_PERIOD = 3;
    float BASE_FEE = 1.5f;
    float LATE_FEE_PER_DAY = 1.5f;

    @Override
    public float getBaseFee() {
        return 1.5f;
    }

    @Override
    public float getBorrowPeriod() {
        return 3;
    }

    @Override
    public float getLateFeePerDay() {
        return 1.5f;
    }

}

class NewReleasePrice extends Price {

    float NEW_RELEASE_FEE_PER_DAY = 3;

    @Override
    public int calculateFrequentRenterPoint(int days) {
        return days;
    }
    
    @Override
    public double calculateRentalFee(int days) {
        return days * NEW_RELEASE_FEE_PER_DAY;
    }
}

