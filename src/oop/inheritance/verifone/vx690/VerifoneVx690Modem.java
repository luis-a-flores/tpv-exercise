package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx690Modem implements CommunicationDevice {

    private static VerifoneVx690Modem verifoneVx690Modem;

    VerifoneVx690Modem()
    {
    }

    public static VerifoneVx690Modem getInstance()
    {
        if(verifoneVx690Modem == null)
        {
            verifoneVx690Modem=new VerifoneVx690Modem();
        }
        return  verifoneVx690Modem;
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


    public void close() {

    }
}
