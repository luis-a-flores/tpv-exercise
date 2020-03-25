package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx690GPS implements CommunicationDevice {

    private static VerifoneVx690GPS verifoneVx690GPS;

    VerifoneVx690GPS()
    {
    }

    public static VerifoneVx690GPS getInstance()
    {
        if(verifoneVx690GPS == null)
        {
            verifoneVx690GPS=new VerifoneVx690GPS();
        }
        return  verifoneVx690GPS;
    }

    /**
     * Opens a connection using the GPS device
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
