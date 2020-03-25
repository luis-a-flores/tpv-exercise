package oop.inheritance.ingenico;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class IngenicoModem implements CommunicationDevice {

    private static IngenicoModem ingenicoModem;

    IngenicoModem()
    {

    }

    public static IngenicoModem getInstance()
    {
        if(ingenicoModem == null)
        {
            ingenicoModem=new IngenicoModem();
        }
        return  ingenicoModem;
    }


    public boolean open() {

        return true;
    }


    public boolean send(Transaction message) {
        return true;
    }

    @Override
    public TransactionResponse recive() {
        return null;
    }


    public TransactionResponse receive() {
        return new TransactionResponse(true, "132123");
    }


    public void close() {

    }
}
