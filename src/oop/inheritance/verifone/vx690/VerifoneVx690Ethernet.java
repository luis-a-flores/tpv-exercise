package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx690Ethernet implements CommunicationDevice {
    private static VerifoneVx690Ethernet verifoneVx690Ethernet;

    VerifoneVx690Ethernet(){

    }

    public static VerifoneVx690Ethernet getInstance()
    {
        if(verifoneVx690Ethernet == null)
        {
            verifoneVx690Ethernet=new VerifoneVx690Ethernet();
        }
        return  verifoneVx690Ethernet;
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
