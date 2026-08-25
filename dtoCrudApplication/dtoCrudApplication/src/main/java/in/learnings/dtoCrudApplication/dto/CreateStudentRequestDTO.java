package in.learnings.dtoCrudApplication.dto;

import jakarta.validation.constraints.*;


public class CreateStudentRequestDTO {
    @NotNull(message = "please enter the name ")
    @NotBlank(message = "the name should be 2 to 50 characters" )
    private String name;
    @NotNull(message = "enter the age ")
    @Min(value = 18, message ="the age should be greater than 18 ")
    private int age;
    @NotNull(message = "email required")
    @Email(message = "enter the correct email address")
    private String email;
    @NotNull
    private Integer Roll;

    private String Subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoll() {
        return Roll;
    }

    public void setRoll(Integer roll) {
        Roll = roll;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
