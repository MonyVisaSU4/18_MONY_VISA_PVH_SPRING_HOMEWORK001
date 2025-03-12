package org.example.spring_homework_001.Controler;

import org.example.spring_homework_001.Models.TicketsModel;
import org.example.spring_homework_001.Models.TicketsModelNoId;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketsControler {
    private final List<TicketsModel> ticketList = new ArrayList<>();

    public TicketsControler(){
        ticketList.add(new TicketsModel(1,"Teav Chanra", Date.valueOf("2025-03-15"),"Phnom Penh","Prey Veng",250.99,true,true,36));
        ticketList.add(new TicketsModel(2,"Mony Visa",Date.valueOf("2025-03-18"),"Siem Reap","Prey Veng",550.99,true,true,76));
        ticketList.add(new TicketsModel(3,"Hak korlimhour",Date.valueOf("2025-03-25"),"Battambang","Prey Veng",150.99,true,true,16));
    }

    // already
    @PostMapping("/addTickets")
    public List<TicketsModel> addItem(@RequestBody TicketsModel model){
        ticketList.add(model);
        return ticketList;
    }

    // already
    @GetMapping("/showTickets")
    public List<TicketsModel> showItem(){
        return ticketList;
    }

    // already
    @GetMapping("/{searchById}")
    public List<TicketsModel> searchId(@PathVariable Integer searchById){
        List<TicketsModel> afterSearch = new ArrayList<>();
        for(TicketsModel getModel : ticketList){
            if(Objects.equals(getModel.getTicketId(), searchById)){
                afterSearch.add(getModel);
                return afterSearch;
            }
        }
        return null;
    }

    // already
    @GetMapping("/searchByName")
    public List<TicketsModel> searchName(@RequestParam String searchByName){
        List<TicketsModel> afterSearchbyName = new ArrayList<>();
        for(TicketsModel getModelName : ticketList){
            if(getModelName.getPassengerName().equals(searchByName)){
                afterSearchbyName.add(getModelName);
                return afterSearchbyName;
            }
        }
        return null;
    }

    // Already
    @PutMapping("/{updateMyTicket}")
    public String updateById(@RequestParam Integer updateMyTicket, @RequestBody TicketsModel upingTicket){
        List<TicketsModel> updateList = new ArrayList<>();
        Collection<TicketsModelNoId> appendRow = new ArrayList<>();
        for(TicketsModel findToUp : ticketList){
            if(Objects.equals(findToUp.getTicketId(), updateMyTicket)){
                ticketList.remove(findToUp);
                updateList.add(findToUp);
                upingTicket.setTicketId(updateMyTicket);
                upingTicket.setPassengerName(upingTicket.getPassengerName());
                upingTicket.setTicketStatus(upingTicket.getTicketStatus());
                upingTicket.setPrice(upingTicket.getPrice());
                upingTicket.setSeatNumber(upingTicket.getSeatNumber());
                upingTicket.setPaymentStatus(upingTicket.getPaymentStatus());
                upingTicket.setSourceStation(upingTicket.getSourceStation());
                upingTicket.setTravelDate(upingTicket.getTravelDate());
                upingTicket.setDestinationStation(upingTicket.getDestinationStation());
                ticketList.add(upingTicket);
                return "Updated Successfully";
            }
        }
        return "";
    }

    // already
    @DeleteMapping("/{deleteTicket}")
    public String deleteById(@PathVariable Integer deleteTicket){
        for(TicketsModel findDelete : ticketList){
            if(Objects.equals(findDelete.getTicketId(), deleteTicket)){
                ticketList.remove(findDelete);
                return "Delete Successfully";
            }
        }
        return null;
    }
}
