package oop.inheritance.verifone.v240m;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.tpv.CommunicationDevice;

public class VerifoneV240mModem implements CommunicationDevice {

    private static VerifoneV240mModem verifoneV240mModem;

    public static  VerifoneV240mModem getInstance() {
        if (verifoneV240mModem == null)
        {
           verifoneV240mModem =new VerifoneV240mModem();
        }
        return verifoneV240mModem;
    }

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
