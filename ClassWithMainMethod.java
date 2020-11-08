

import java.util.Scanner;

public class ClassWithMainMethod {

  public static void main(String[] args) {
  
   // Create Scanner object
   Scanner input = new Scanner(System.in);
  
   for(int m = 0; m < 3; m--){
   
   // prompt user for input
   System.out.println("\n\n\t\t\t\t\tWelcome Bank Management System\n\n\t\t\t\t\t\t\tSelect Operation Below\n\n");
   System.out.print("1. List All Accounts And Their Balances\n2. Create A New Account\n3. Deposit Money Into An Account\n4. Withdraw Money From An Account\n5. Check    Account Balance\n6. Exit\n\n");
   System.out.print("Enter your choice:  ");
   int x = input.nextInt();
   
   // declaring variables
   String accountName;
   String branch;
   String type;
   double balance;
   String regNumber;
   double amount;
   String accountNumber;
  
  switch(x){
     case 1 :
        // print out the details of all accounts
        Account.printAllAccountDetails();
        break;
     
     case 2 :
        // prompt user for input
        System.out.print("\n\t\t\t\tSelect The Bank Account Type\n\n1. Student\n2. Executive:  \n\nEnter Your choice:   ");
        int y = input.nextInt();
     
       if(y == 1){
       System.out.print("\n\n\n\t\t\tCreating A New Student Bank Account\n\n");
    
       // prompt user for input
       System.out.print("Enter Account Number:  ");
       accountNumber = input.next();   
       System.out.print("Enter Account Name:  ");
       accountName = input.next();
       System.out.print("Enter Student Reg Number:   ");
       regNumber = input.next();
       System.out.print("Enter Branch:    ");
       branch = input.next();
       System.out.print("Enter Balance:    K");
       balance = input.nextDouble();
       
       // creating Student account
       if(balance >= 200 && (Account.traceAccountNumber(accountNumber) == 1) && (accountNumber.length() == 5)){
       StudentAccount account = new StudentAccount();
       
       account.setRegNumber(regNumber);
       
       account.setAccountName(accountName);
       
       account.setAccountNumber(accountNumber);
       
       account.setBranch(branch);
       
       account.setBalance(balance);
       
       System.out.print("\nAccount Successfully Created on " + account.getDateCreated());
       Account.addToListOfAccounts(account);
       }
       else{
         System.out.println("\n\nCouldn't create an account. The balance is less than K200, the account number already exists or the account number is not a 5-digit number." );   
       }
       
     
     }
     else if(y == 2){
       
        System.out.print("\n\n\n\t\t\tCreating A New Executive Bank Account\n\n");
       
        // prompt user for input
        System.out.print("Enter Account Number:  ");
        accountNumber = input.next();
        System.out.print("Enter Account Name:  ");
        accountName = input.next();
        System.out.print("Enter Branch:    ");
        branch = input.next();
        System.out.print("Enter Balance:    K");
        balance = input.nextDouble();
       
        // creating Executive account
        if(balance >= 0 && (Account.traceAccountNumber(accountNumber) == 1) && (accountNumber.length() == 5)){
        ExecutiveAccount account1 = new ExecutiveAccount();
       
        account1.setAccountName(accountName);
       
        account1.setAccountNumber(accountNumber);
       
        account1.setBranch(branch);
       
        account1.setBalance(balance);
       
        System.out.print("\nAccount Successfully Created on " + account1.getDateCreated());
        Account.addToListOfAccounts(account1);
        }
     
       else{
       System.out.print("\n\nCouldn''t create an account. The balance is invalid, account number already exists or the account number is not a 5-digit number\n\n");
       } 
       
     }
     else{
       System.out.println("Invalid input");
       System.exit(1); 
     }
     
     break;
      
     case 3 :
       System.out.print("Enter your account number:   ");
       String accN = input.next();
       System.out.println("Enter amount you want to deposit:  ");
       amount = input.nextDouble();
       Account ac = Account.traceAccount(accN); 
       ac.deposit(amount, accN);
       Account.setListOfAccounts(ac.getAccountId(), ac);
       break;
     
     case 4 : 
       System.out.println("Enter Your Account number:  ");
       String accNo = input.next();
       Account acc = Account.traceAccount(accNo);
       System.out.println("Enter Account Type\n1. Student \n2. Executive\n");
       int accountType = input.nextInt();
       System.out.print("Enter The Amount You Want To Withdraw:   ");
       amount = input.nextDouble();
       if(accountType == 1){
         
         acc.withdrawStudentAccount(amount, accNo);
         Account.setListOfAccounts(acc.getAccountId(), acc);
       }
       else if(accountType == 2){
         acc.withdrawExecutiveAccount(amount, accNo);
         Account.setListOfAccounts(acc.getAccountId(), acc);
       }
       break;
       
     case 5 : 
       System.out.println("Enter your account id:  ");
       int i = input.nextInt();
       Account acco = Account.getAccount(i);
       System.out.println(" Account : " + acco.getAccountName() + " balance is " + acco.getBalance());
       break;
       
     default :
       System.out.println("Invalid input");
       System.exit(1);
  }
  }
  
  }

}
