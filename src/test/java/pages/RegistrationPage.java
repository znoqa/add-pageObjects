package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    // components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            userHobbiesInput = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            uploadPictureInput = $("#uploadPicture"),
            stateAndCityInput = $("#stateCity-wrapper"),
            clickSubmitButton = $("#submit"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setUserGender(String userGender) {
        userGenderInput.$(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String userHobbies) {
        userHobbiesInput.$(byText(userHobbies)).click();

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setState(String stateName) {
        stateAndCityInput.$("#state").click();
        $(byText(stateName)).click();

        return this;
    }

    public RegistrationPage setCity(String cityName) {
        stateAndCityInput.$("#city").click();
        $(byText(cityName)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        clickSubmitButton.click();

        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}





