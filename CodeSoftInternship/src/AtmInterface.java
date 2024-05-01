import java.util.Scanner;

class BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=10000f;
	int transactions=0;
	String transactionHistory="";
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter your Name:");
		this.name=sc.nextLine();
		System.out.println("\nEnter your UserName:");
		this.userName=sc.nextLine();
		System.out.println("\nEnter your Password:");
		this.password=sc.nextLine();
		System.out.println("\nEnter your Account Number:");
		this.accountNo=sc.nextLine();
		System.out.println("\nRegistration Successful. please Login to your Bank Account");
	}
	public boolean login() {
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin) {
			System.out.println("\nEnter your username");
			String userName=sc.nextLine();
			if(userName.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter Your password");
					String password=sc.nextLine();
					if(password.equals(password)) {
						System.out.println("/nLogin Successful");
						isLogin=true;
					}
					else {
						System.out.println("\nIncorrect password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	public void withDraw() {
		System.out.println("\nEnter Amount to withdraw: ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(balance>=amount) {
				transactions++;
				balance-=amount;
				System.out.println("\nwithdraw Successful.");
				String str=amount+"Rs withdraw";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\nInsufficient balance");
			}
		}catch(Exception ex){
			
		}
	}
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(amount<=10000) {
				transactions++;
				balance+=amount;
				System.out.println("\ndeposit Successful.");
				String str=amount+"Rs deposited";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry the limit is 10000");
			}
		}catch(Exception ex){
			
		}
	}
	public void transfer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Recepient name: ");
		String recepient=sc.nextLine();
		System.out.println("\nEnter Amount to transfer: ");
		float amount=sc.nextFloat();
		try {
			if(balance>=amount) {
				if(amount<=50000f) {

				transactions++;
				balance-=amount;
				System.out.println("\nsuccessfuly transfer to"+recepient);
				String str=amount+"Rs transferred to"+recepient+"\n";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry the limit is 50000");
			}
		}else{
			System.out.println("\nInsufficient balance");
		}}catch(Exception ex){
		
			
		}
	}
	public void checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
	public void transactionHistory() {
		if(transactions==0) {
			System.out.println("No Transaction happened");
		}
		else {
			System.out.println("\n"+transactionHistory);
		}
		
	}
}
public class AtmInterface {
  public static int takeIntegerInput(int limit) {
	int input=0;
	boolean flag=false;
	while(!flag) {
		try {
			Scanner sc=new Scanner(System.in);
			input=sc.nextInt();
			flag=true;
			if(flag && input>limit || input<1) {
				System.out.println("choose the number between 1 to "+limit);
				flag=false;
			}
		}catch(Exception ex) {
			System.out.println("enter only integer value");
			flag=false;
		}
	}
	return input;
  }
  public static void main(String arg[]) {
	  System.out.println("\n**********WELCOME TO PRAKASH ATM INTERFACE**********");
	  System.out.println("\n1.Register \n2.exit");
	  System.out.println("choose one option:");
	  int choose=takeIntegerInput(2);
	  if(choose==1) {
		  BankAccount b=new BankAccount();
		  b.register();
		  while(true) {
			  System.out.println("\n1.login\n2.exit");
			  System.out.println("Enter Your Choice:");
			  int ch=takeIntegerInput(2);
			  if(ch==1) {
				  if(b.login()) {
					  System.out.println("\n*******WELCOME BACK*****");
					  boolean isFinished=false;
					  while(!isFinished) {
						  System.out.println("\n1.Withdraw\n2.Deposit \n3.Transfer\n4.check Balance\n5.Transaction History\n6.Exit");
						  System.out.println("Enter Your Choice:");
						  int c=takeIntegerInput(6);
						  switch(c) {
						  case 1:
							  b.withDraw();
							  break;
							  
						  case 2:
							  b.deposit();
							  break;
						  case 3:
							  b.transfer();
							  break;
						  case 4:
							  b.checkBalance();
							  break;
						  case 5:
							  b.transactionHistory();
							  break;
						  case 6:
							  isFinished=true;
							  break;
						  }
					  }
				  }
			  }else {
				  System.exit(0);
			  }
			  
		  }
	  }else {
		  System.exit(0);
	  }
	  
  }
}
