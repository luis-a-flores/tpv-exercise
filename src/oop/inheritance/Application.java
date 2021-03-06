package oop.inheritance;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import oop.inheritance.data.Card;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;
import oop.inheritance.ingenico.IngenicoEthernet;
import oop.inheritance.ingenico.IngenicoGPS;
import oop.inheritance.ingenico.IngenicoKeyboard;
import oop.inheritance.ingenico.IngenicoModem;
import oop.inheritance.ingenico.IngenicoPrinter;
import oop.inheritance.tpv.AbstractTPVFactory;
import oop.inheritance.tpv.CardSwipper;
import oop.inheritance.tpv.ChipReader;
import oop.inheritance.tpv.CommunicationDevice;
import oop.inheritance.tpv.Display;
import oop.inheritance.tpv.Keyboard;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private AbstractTPVFactory abstractTPVFactory;

    public Application(AbstractTPVFactory abstractTPVFactory) {
        this.abstractTPVFactory = abstractTPVFactory;
    }

    public void showMenu() {

        Display ingenicoDisplay = abstractTPVFactory.getDisplay();

        ingenicoDisplay.showMessage(5, 5, "MENU");
        ingenicoDisplay.showMessage(5, 10, "1. VENTA");
        ingenicoDisplay.showMessage(5, 13, "2. DEVOLUCION");
        ingenicoDisplay.showMessage(5, 16, "3. REPORTE");
        ingenicoDisplay.showMessage(5, 23, "4. CONFIGURACION");
    }

    public String readKey() {
        Keyboard ingenicoKeyboard = abstractTPVFactory.getKeyboard();

        return ingenicoKeyboard.get();
    }

    public void doSale() {
        CardSwipper cardSwipper = abstractTPVFactory.getCardSwipper();
        ChipReader chipReader = abstractTPVFactory.getChipReader();
        Display display = abstractTPVFactory.getDisplay();
        Keyboard keyboard = abstractTPVFactory.getKeyboard();
        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.showMessage(5, 20, "Capture monto:");

        String amount = keyboard.get(); //Amount with decimal point as string

        Transaction transaction = Transaction.builder()
                .LocalDateTime(localDateTime.now())
                .Card(card)
                .AmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        IngenicoPrinter ingenicoPrinter = new IngenicoPrinter();
        Card card = transaction.getCard( );

        ingenicoPrinter.print(5, "APROBADA");
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, card.getAccount());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "" + transaction.getAmountInCents());
        ingenicoPrinter.lineFeed();
        ingenicoPrinter.print(5, "________________");

    }

    private TransactionResponse sendSale(Transaction transaction) {
        Map<CommunicationType, CommunicationDevice> communicationDeviceMAp = abstractTPVFactory.getComunicationDeviceMap();

        CommunicationDevice communicationDevice = communicationDeviceMAp.get(CommunicationType.ETHERNET);

        communicationDevice.open();
        communicationDevice.send(transaction);
        TransactionResponse transactionResponse = communicationDevice.recive();
        communicationDevice.close();

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        Display display = abstractTPVFactory.getDisplay();

        display.clear();
    }
}
