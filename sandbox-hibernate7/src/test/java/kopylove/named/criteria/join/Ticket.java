package kopylove.named.criteria.join;

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

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public TicketDetails getTicketDetails()
    {
        return ticketDetails;
    }

    public void setTicketDetails(TicketDetails ticketDetails)
    {
        this.ticketDetails = ticketDetails;
    }
}
