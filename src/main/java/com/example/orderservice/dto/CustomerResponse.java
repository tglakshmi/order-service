package com.example.orderservice.dto;




import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String phoneNo;
    private List<AddressResponse> address;
}

