public class HasAdmin implements ATMState {

    ATMMachine atmMachine;

    public HasAdmin(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You don't have to insert a card");
    }

    @Override
    public void ejectCard() {
        System.out.println("There is no Card in the ATM");

    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("You are admin you don't have to insert a pin");

    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("checking ATM machine for cash");
        if(cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("You can't redraw");
            System.out.println("Card Ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());
        } else {
            System.out.println(cashToWithdraw + " is provide by the machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);

            System.out.println("Card Ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());

            if(atmMachine.cashInMachine <= 0){

                atmMachine.setATMState(atmMachine.getNoCashState());
            }
        }

    }
}
