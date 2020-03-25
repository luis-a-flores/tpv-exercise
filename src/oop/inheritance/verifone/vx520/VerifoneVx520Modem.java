package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx520Modem implements CommunicationDevice {

    private static VerifoneVx520Modem  verifoneVx520Modem;

    VerifoneVx520Modem()
    {

    }

    public static VerifoneVx520Modem getInstance()
    {
        if(verifoneVx520Modem == null)
        {
            verifoneVx520Modem=new VerifoneVx520Modem();
        }
        return  verifoneVx520Modem;
    }

    /**
     * Opens a connection using the modem device
     *
     * @return true if the connection was successfully opened
     */
    public boolean open() {

        return true;
    }

    @Override
    public boolean send(Transaction transaction) {
        return false;
    }

    @Override
    public TransactionResponse recive() {
        return null;
    }

    /**
     * Closes the channel releasing every used resources
     */
    public void close() {

    }
}
