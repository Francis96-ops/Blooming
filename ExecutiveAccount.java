

public class ExecutiveAccount extends Account{

  // data fields 
  private  boolean isExecutiveAccount = true;
  private boolean isStudentAccount = false;

  // constructors 
  ExecutiveAccount(){
   
   Account.setNumberOfAccounts();
   setAccountId();
  }
  
  // methods 
  public boolean getIsExecutiveAccount(){
    return isExecutiveAccount;
  }
  public boolean getIsStudentAccount(){
    return isStudentAccount;
  }
}
