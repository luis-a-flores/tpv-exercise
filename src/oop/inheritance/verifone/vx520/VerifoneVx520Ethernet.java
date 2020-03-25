package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx520Ethernet implements CommunicationDevice{

    private static VerifoneVx520Ethernet  verifoneVx520Ethernet;

    VerifoneVx520Ethernet()
    {

    }

    public static VerifoneVx520Ethernet getInstance()
    {
        if(verifoneVx520Ethernet == null)
        {
            verifoneVx520Ethernet=new VerifoneVx520Ethernet();
        }
        return  verifoneVx520Ethernet;
    }

    /**
     * Opens a connection using the ethernet device
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
