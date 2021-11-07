package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketList;
import java.util.Arrays;

public class TicketManager {
    private TicketList repository;

    public TicketManager(TicketList repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public void deleteById(int id) {
        repository.removeById(id);
    }

    public Ticket[] getAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket: repository.findAll()) {
            if (ticket.getAirportFrom() == from && ticket.getAirportTo() == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }
}
