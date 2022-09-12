public class Checking extends Account {

  private String debitCardNo;
  private String debitCardPIN;


  Checking(String name, String ssn, double balance){
    super(name, ssn, balance);
    setAccountNumber("1" + getAccountNumber());
    this.debitCardNo = generateDebitCardNo();
    this.debitCardPIN = generateDebitCardPIN();
    this.setInterestRate(getBaseInterestRate());

  }

  public String getDebitCardNo() {
    return debitCardNo;
  }

  public void setDebitCardNo(String debitCardNo) {
    this.debitCardNo = debitCardNo;
  }

  public String getDebitCardPIN() {
    return debitCardPIN;
  }

  public void setDebitCardPIN(String debitCardPIN) {
    this.debitCardPIN = debitCardPIN;
  }

  @Override
  public void setInterestRate(double baseInterestRate) {
    super.setInterestRate(this.getInterestRate() * 0.15);
  }


  public static String generateDebitCardNo(){
    return "9" + generateRandNumberWithLength(15);
  }

  public static String generateDebitCardPIN(){
    return generateRandNumberWithLength(4);
  }

  public String showInfo() {
    return super.showInfo() + "\n" +
           "ACCOUNT TYPE: Checking" + "\n" +
           "DEBIT CARD NUMBER: " + debitCardNo + "\n" +
           "DEBIT CARD PIN: " + debitCardPIN + "\n" +
           "INTEREST RATE: %" + getInterestRate() + "\n";

  }
}
