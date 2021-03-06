package oop.inheritance.tpv;

import java.util.Map;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;

public abstract class AbstractTPVFactory {

    public static AbstractTPVFactory getFactory(SupportedTerminal supportedTerminal) {
        switch (supportedTerminal) {
            case INGENICO:
                return new IngenicoTPVFactory();
            case VERIFONE:
                return new VerifoneV240Factory();
        }

        throw new UnsupportedOperationException("Terminal not supported");
    }

    public abstract CardSwipper getCardSwipper();

    public abstract ChipReader getChipReader();

    public abstract Display getDisplay();

    public abstract Keyboard getKeyboard();

    public abstract Map<CommunicationType, CommunicationDevice> getComunicationDeviceMap();
}

