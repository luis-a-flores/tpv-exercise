package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneVx520GPS implements CommunicationDevice {

    private static VerifoneVx520GPS  verifoneVx520GPS;

    VerifoneVx520GPS()
    {

    }

    public static VerifoneVx520GPS getInstance()
    {
        if(verifoneVx520GPS == null)
        {
            verifoneVx520GPS=new VerifoneVx520GPS();
        }
        return  verifoneVx520GPS;
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
