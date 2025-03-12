package org.example.spring_homework_001.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TicketsModelNoId {
    private String passengerName;
    private Date travelDate;
    private String sourceStation;
    private String destinationStation;
    private Double price;
    private Boolean paymentStatus;
    private Boolean ticketStatus;
    private Integer seatNumber;
}
