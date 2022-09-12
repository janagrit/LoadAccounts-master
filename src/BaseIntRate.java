public interface BaseIntRate {

    final double BASE_INTEREST_RATE = 2.5;

    default double getBaseInterestRate(){
        return BASE_INTEREST_RATE;
    }

    void setInterestRate(double baseInterestRate);
}