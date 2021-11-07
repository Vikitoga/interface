package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketList;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketList repository = Mockito.mock(TicketList.class);
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 4689, "ROV", "AER",70);
    private Ticket second = new Ticket(2, 2895,"VKO","KUF", 105);
    private Ticket third = new Ticket(3,5542, "ROV", "AER", 435);
    private Ticket fourth = new Ticket(4, 1480, "ROV", "AER", 530);
    private Ticket fifth = new Ticket(5, 15700, "DME", "MJZ", 460);


    @BeforeEach
    public void createSaleList() {
        Ticket[] listOfTicket = {first, second, third, fourth, fifth};
        doReturn(listOfTicket).when(repository).findAll();
    }

    @AfterEach
    public void verifyMock() {
        verify(repository).findAll();
    }


    @Test
    public void shouldGetSomeTicket() {
        Ticket[] actual = manager.getAll("ROV", "AER");
        Ticket[] expected = new Ticket[]{fourth, first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetNoTicket() {
        Ticket[] actual = manager.getAll("VKO", "AER");
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetOneTicket() {
        Ticket[] actual = manager.getAll("VKO", "KUF");
        Ticket[] expected = new Ticket[]{second};
        assertArrayEquals(expected, actual);
    }
}