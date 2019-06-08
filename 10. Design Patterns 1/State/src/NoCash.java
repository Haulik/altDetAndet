public class NoCash implements ATMState {

    ATMMachine atmMachine;

    public NoCash(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    @Override
    public void insertCard() {

        System.out.println("The ATM is emty");

    }

    @Override
    public void ejectCard() {

        System.out.println("There is no card in the ATM");

    }

    @Override
    public void insertPin(int pinEntered) {

        System.out.println("We don't have any more cash in this ATM");

    }

    @Override
    public void requestCash(int cashToWithdraw) {

        System.out.println("We don't have any more cash in this ATM");

    }
}
