public class HasPin implements ATMState {

    ATMMachine atmMachine;

    public HasPin(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    @Override
    public void insertCard() {

        System.out.println("You can't insert more than 1 card");

    }

    @Override
    public void ejectCard() {

        System.out.println("Card Ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());

    }

    @Override
    public void insertPin(int pinEntered) {

        System.out.println("You already inserted you pin");

    }

    @Override
    public void requestCash(int cashToWithdraw) {

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
