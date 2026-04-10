package com.example.Department.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {


    private Long id;

    @NotBlank(message = "title of the Department can't be blank")
    @Size(min=3,max=10,message="Number of Characters in title should be in the range: [3,10]")
    private String title;

    @AssertTrue(message = "Department should be active")
    @JsonProperty("isActive")
    private  Boolean isActive;

    @PastOrPresent(message = "DateofJoining field in Department can't be in future")
    private LocalDate createdAt;

}
