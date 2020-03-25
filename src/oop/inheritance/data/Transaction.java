package oop.inheritance.data;

import java.time.LocalDateTime;

public class Transaction {
    private int amountInCents;
    private Card card;
    private LocalDateTime localDateTime;

    public static Object builder()
    {
    }

    public Transaction getAmountInCents()
    {
        this.amountInCents=amountInCents;
        return this;
    }

    public Transaction setAmountInCents(int amountInCents)
    {
        this.amountInCents = amountInCents;
        return this;
    }

    public Transaction getCard(Card card) {
        this.card=card;
        return this;
    }

    public Transaction setCard(Card card) {
        this.card = card;
        return this;
    }

    public Transaction getLocalDateTime(LocalDateTime localDateTime)
    {
        this.localDateTime=localDateTime;
        return localDateTime;
    }

    public Transaction setLocalDateTime(LocalDateTime localDateTime) {

        this.localDateTime = localDateTime;
        return this;
    }

    public Transaction buil()
    {
        return  new Transaction(amountInCents,card,localDateTime);
    }
}
