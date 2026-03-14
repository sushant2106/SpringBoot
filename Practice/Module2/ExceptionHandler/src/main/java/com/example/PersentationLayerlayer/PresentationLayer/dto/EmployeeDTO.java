package com.example.PersentationLayerlayer.PresentationLayer.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;


import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name of the Employee can't be blank")
    @Size(min=3,max=20,message = "Number of Charcters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the employee can't be balank")
    @Email(message = "Email should be valid email")
    private String email;

    @NotNull(message ="Age of the Employee can't be blank")
    @Max(value=80,message = "Age can't be greater then 80")
    @Min(value=18,message = "Age of Employe can't be less than 18")
    private Integer age;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6,fraction = 2,message = "The salary can be in the form XXXX.YY")
    @DecimalMax(value="900000.99")
    @DecimalMin(value = "1000.10")
    private Double salary;


    @PastOrPresent(message = "DateOfJoining field in Employee can't be in the future")
    private LocalDate dateOfJoining;

    @NotBlank(message = "Role of the Employee can't be blank")
    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be USER or ADMIN")
    private String role;

    @AssertTrue(message = "Employee Should be active")
    @JsonProperty("isActive")
    private Boolean isActive;


}
