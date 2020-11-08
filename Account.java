
import java.util.Date;
import java.util.ArrayList;
public class Account {

// data fields
private static ArrayList<Account> list = new ArrayList<>();
private String accountName;
private Date dateCreated = new Date();
private String accountNumber;
private double balance;
private String branch;
private String type ="Savings";
private  static int numberOfAccounts = -1;
private int accountId;

// Constructors
Account(){
}

// methods
public String getAccountName(){
  return accountName;
}
public void setAccountName(String accountName){
  this.accountName = accountName;
}
public Date getDateCreated(){
  return dateCreated;
}
public String getAccountNumber(){
  return accountNumber;
}
public void setAccountNumber(String accountNumber){
  this.accountNumber = accountNumber;
}
public double getBalance(){
  return balance;
}
public void setBalance(double balance){
 this.balance = balance; 
}
public String getBranch(){
  return branch;
}
public void setBranch(String branch){
  this.branch = branch;
}
public String getType(){
  return type;
}
public void setType(String type){
  this.type = type;
}
public static int getNumberOfAccounts(){
  return numberOfAccounts;
}
public static void setNumberOfAccounts(){
 numberOfAccounts++; 
}
public void setAccountId(){
 accountId = numberOfAccounts;
}
public static void addToListOfAccounts(Account account){
  list.add(account);
}
public static void setListOfAccounts(int x, Account acc){
  list.set(x, acc);
}
public static Account getAccount(int x){
  return list.get(x);
}
public static int traceAccountNumber(String accN){
  Account acc;
  int intAccountNumber;
  int acN = Integer.parseInt(accN);
  for(int i = 0; i < list.size(); i++){
    acc = list.get(i);
    intAccountNumber = Integer.parseInt(acc.getAccountNumber());
    if(intAccountNumber == acN){
    return -1;
    }
    
  }
  return 1;
 }  
public int getAccountId(){
  return accountId;
}
public void withdrawStudentAccount(double amount, String accNo){
  Account account = traceAccount(accNo);
  if(balance-amount >= 200 && account != null){
     account.setBalance(balance-amount);   
    System.out.println("Withdrawal of " + amount + " was successful");
    }
    else{
      System.out.println("Failed to make a withdrawal: Insufficient funds");
    }
  
}
public void withdrawExecutiveAccount(double amount, String accNo){
  Account account = traceAccount(accNo);
  if(amount >= 0 && amount <= 50000 && account != null){
    account.setBalance(balance-amount);
    System.out.println("Withdraw of " + amount + " was successful");
  }
  else{
    System.out.println("Failed to make a withdraw");
  }
}
public void deposit(double amount, String accNo){
Account account = traceAccount(accNo);
  if(amount > 0 && account != null){
  account.setBalance(balance + amount);
  System.out.println("Depositing into accout " + account.getAccountNumber() + " was successful");
  }
  else
  System.out.println("Failed to deposit");
}
public static Account traceAccount(String accN){
  Account acc;
  int acN;
  int ac = Integer.parseInt(accN);
  for(int i = 0; i < list.size(); i++){
    acc = list.get(i);
    acN = Integer.parseInt(acc.getAccountNumber());
    if(acN == ac)
      return acc;
   
   }
  return null;
}

public static void printAllAccountDetails(){
  String a = "Account Number";
  String b = "Account Name";
  String c = "Type";
  String d = "Branch";
  String e = "Balance";
  System.out.printf("%-18s%-15s%-10s%-10s%-10s\n", a,b,c,d,e);
  System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
  for(int i = 0; i < list.size(); i++){
  Account x = list.get(i);
  String f = x.getAccountNumber();
  String g = x.getAccountName();
  String h = x.getType();
  String t = x.getBranch();
  double j = x.getBalance();
  System.out.printf("%-18s%-15s%-10s%-10s%10.2f\n", f,g,h,t,j);
  }
}
}
