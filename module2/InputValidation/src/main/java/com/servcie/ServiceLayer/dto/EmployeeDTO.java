package com.servcie.ServiceLayer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.servcie.ServiceLayer.anotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name of the Employee can't be blank")
    @Size(min=3,max=10,message="Number of Charcters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the Employee can't be blank")
    @Email(message="Email should be valid email")
    private String email;

    @NotNull(message = "Age of the Employee can't be blank")
    @Max(value=80,message = "Age can't be greater than 80")
    @Min(value=18,message="Age of Employee can't be less than 18")
    private Integer age;


    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6,fraction = 2,message = "The salary can be in the form XXXX.YY")
    @DecimalMax(value="900000.99")
    @DecimalMin(value="1000.10")
    private Double salary;


    @PastOrPresent(message = "DateOfJoining field in Employee can't be in the future")
    private LocalDate dateOfJoining;



    @NotBlank(message = "Role of the Employee can't be blank")
   // @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;//ADMIN.USER

    @AssertTrue(message = "Employee Should be active")
    @JsonProperty("isActive")
    private Boolean isActive;





//
//    public EmployeeDTO(){
//
//    }
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//    public  void  setId(Long id){
//        this.id=id;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }
}
