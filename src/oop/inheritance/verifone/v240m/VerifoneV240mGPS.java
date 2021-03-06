package oop.inheritance.verifone.v240m;


import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.ingenico.IngenicoEthernet;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneV240mGPS implements CommunicationDevice {
    private static VerifoneV240mGPS verifoneV240mGPS;

    VerifoneV240mGPS()
    {

    }

    public static VerifoneV240mGPS getInstance()
    {
        if(verifoneV240mGPS == null)
        {
            verifoneV240mGPS=new VerifoneV240mGPS();
        }
        return  verifoneV240mGPS;
    }


    @Override
    public boolean open() {
        return false;
    }

    /**
         * Opens a connection using the GPS device
         * <p>
         * /**
         * Sends a message to the server
         *
         * @param transaction message to be sent to the server
         * @return true if the message was sent successfully, false otherwise
         */
        public boolean send(Transaction transaction) {
            return true;
        }

    @Override
    public TransactionResponse recive() {
        return null;
    }

    @Override
    public void close() {

    }

    public TransactionResponse receive() {
            return new TransactionResponse(true, "12314");
        }
}

