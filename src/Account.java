public abstract class Account implements BaseIntRate {

    static final String numbersDictionary = "0123456789";

    private String name;
    private String ssn;
    private double balance;
    private String accountNumber;
    private String routingNumber;
    private double interestRate;

    Account(String name, String ssn, double balance){
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = generateAccountNumber(ssn);
        this.routingNumber = generateRoutingNumber();
        this.interestRate = getBaseInterestRate();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getRoutingNumber() {
        return routingNumber;
    }
    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public static String generateAccountNumber(String ssn){
        return ssn.substring(ssn.length() - 4) + generateRandNumberWithLength(7);
    }

    public static String generateRoutingNumber(){
        return "00" + generateRandNumberWithLength(7);
    }

    public void deposit(double amount){
        this.setBalance(this.getBalance() + amount);
        System.out.println(this.getBalance());
    }

    public void withdraw(double amount){
        if(amount > this.getBalance()){
            System.out.println("You do not have the funds to withdraw this amount from your account.");
            return;
        }

        this.setBalance(this.getBalance() - amount);
        System.out.println(this.getBalance());
    }

    public String showInfo() {
        return  "NAME: " + name + "\n" +
                "SSN: " + ssn + "\n" +
                "ACCOUNT NUMBER: " + accountNumber + "\n" +
                "ROUTING NUMBER: " + routingNumber + "\n" +
                "BALANCE: " + balance;
    }

    public static int randNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String generateRandNumberWithLength(int length){
        String number = "";

        for(int i = 0; i < length; i++){
            number += numbersDictionary.charAt(randNumber(0, numbersDictionary.length() - 1));
        }

        return number;
    }
}
