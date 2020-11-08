

public class StudentAccount extends Account{

// datafields 
private String regNumber;
private boolean isStudentAccount = true;
private boolean isExecutiveAccount = false;

// constructors
StudentAccount(){
  Account.setNumberOfAccounts();
  setAccountId();
}

// methods
public void setRegNumber(String regNumber){
  this.regNumber = regNumber;
}
public String getRegNumber(){
  return regNumber;
}
public boolean getIsExecutiveAccount(){
  return isExecutiveAccount; 
}
public boolean getIsStudentAccount(){
  return isStudentAccount;
}
}

