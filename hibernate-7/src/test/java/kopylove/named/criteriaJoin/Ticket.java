package kopylove.named.criteriaJoin;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Ticket
{
    @Id
    @Column(name = "TICKET_ID", unique = true, nullable = false)
    private int key;

    @Column(name = "TICKET_DESCRIPTION")
    private String name;

    @Embedded
    private TicketDetails ticketDetails;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    TicketDetails getTicketDetails()
    {
        return ticketDetails;
    }

    void setTicketDetails(TicketDetails ticketDetails)
    {
        this.ticketDetails = ticketDetails;
    }
}
