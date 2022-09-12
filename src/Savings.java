public class Savings extends Account{

  private String safetyDepositBoxID;
  private String safetyDepositBoxPIN;




  Savings(String name, String ssn, double balance){
    super(name, ssn, balance);
    setAccountNumber("2" + getAccountNumber());
    this.safetyDepositBoxID = generateSafetyDepositBoxID();
    this.safetyDepositBoxPIN = generateSafetyDepositBoxPIN();
    this.setInterestRate(getBaseInterestRate());
  }

  public String getSafetyDepositBoxID() {
    return safetyDepositBoxID;
  }

  public void setSafetyDepositBoxID(String safetyDepositBoxID) {
    this.safetyDepositBoxID = safetyDepositBoxID;
  }

  public String getSafetyDepositBoxPin() {
    return safetyDepositBoxPIN;
  }

  public void setSafetyDepositBoxPin(String safetyDepositBoxPIN) {
    this.safetyDepositBoxPIN = safetyDepositBoxPIN;
  }

  @Override
  public void setInterestRate(double baseInterestRate) {
    super.setInterestRate(this.getInterestRate() - 0.25);
  }

  public static String generateSafetyDepositBoxID(){
    return generateRandNumberWithLength(3);
  }

  public static String generateSafetyDepositBoxPIN(){
    return generateRandNumberWithLength(4);
  }

  public String showInfo() {
    return super.showInfo() + "\n" +
           "ACCOUNT TYPE: Savings" + "\n" +
           "SAFETY DEPOSIT BOX ID: " + safetyDepositBoxID + "\n" +
           "SAFETY DEPOSIT BOX PIN: " + safetyDepositBoxPIN + "\n" +
           "INTEREST RATE: %" + getInterestRate() + "\n";
  }
}
