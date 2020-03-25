package oop.inheritance.ingenico;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class IngenicoGPS implements CommunicationDevice {

    private static IngenicoGPS ingenicoGPS;

    IngenicoGPS()
    {

    }

    public static IngenicoGPS getInstance()
    {
        if(ingenicoGPS== null)
        {
            ingenicoGPS=new IngenicoGPS();
        }
        return  ingenicoGPS;
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
        return new TransactionResponse(true, "782132");
    }

    public void close() {

    }
}
