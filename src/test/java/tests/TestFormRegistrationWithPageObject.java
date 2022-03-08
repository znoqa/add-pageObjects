package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class TestFormRegistrationWithPageObject {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Irina";
    String lastName = "Ivanova";
    String userEmail = "ivanova@gmail.com";
    String userGender = "Female";
    String userNumber = "9871234567";
    String day = "12";
    String month = "December";
    String year = "2012";
    String subjects = "Maths";
    String userHobbies = "Reading";
    String currentAddress = "Milky Way Galaxy";
    String fileName = "i.jpg";
    String stateName = "NCR";
    String cityName = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "700x1080";
    }

    @Test
        //заполняем форму
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setUserHobbies(userHobbies)
                .setCurrentAddress(currentAddress)
                .uploadPicture(fileName)
                .setState(stateName)
                .setCity(cityName)
                .clickSubmit();

        //проверка заполненной формы
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", userGender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", userHobbies)
                .checkForm("Address", currentAddress)
                .checkForm("Picture", fileName)
                .checkForm("State and City", stateName + " " + cityName);
    }
}



