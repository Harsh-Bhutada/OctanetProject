import java.util.Scanner;

public class ATM {
    static double bankBalance;
    int pin;
    static double[] myArr = new double[10];
    static int i=0;

    ATM(int pin) {
        this.pin = pin;
    }

    public void withdrawal(double amount) {
        bankBalance -= amount;
        myArr[i] = -amount;
        i++;
    }

    public  void deposit(double amount) {
        bankBalance += amount;
        myArr[i] = amount;
        i++;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void changePin() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your pin");
            int pin = input.nextInt();
            if (this.pin == pin) {
                System.out.println("Enter the pin you want to set");
                this.pin = input.nextInt();
                System.out.println("The pin is changed");
                break;
            }
            else {
                System.out.println("Enter correct pin");
            }
        }
    }

    public double[] transactionHistory() {
        return myArr;
    }

//    public int exitMachine() {
//        return 0;
//    }

    @Override
    public String toString() {
        return "SBI BANK:\n" +
                "pin= ****\n" + "balance=" + bankBalance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int password, count=0;
        System.out.println("Enter the pin");
        while (true) {
            password = input.nextInt();
            if (password >= 1000 && password <=9999) {
                break;
            }
            else {
                System.out.println("Enter a 4digit pin");
            }
        }
        ATM sbi = new ATM(password);
        System.out.println(sbi.toString());
        while (true) {
            System.out.println("1.Deposit\n2.Withdraw\n3.Balance\n4.Change PIN\n5.Transaction History\n6.Exit");
            int choice = input.nextInt();
            if (choice ==6) {
                break;
            }
            double amount;
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to be deposit");
                    amount = input.nextDouble();
                    sbi.deposit(amount);
                    count++;
                    break;
                case 2:
                    System.out.println("Enter the amount to be withdrawn");
                    amount = input.nextDouble();
                    sbi.withdrawal(amount);
                    count++;
                    break;
                case 3:
                    System.out.println(sbi.getBankBalance());
                    break;
                case 4:
                    sbi.changePin();
                    break;
                case 5:
                    double[] array = sbi.transactionHistory();
                    for (int i=0;i<count;i++) {
                        System.out.println(array[i]);
                    }
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
    }
}
