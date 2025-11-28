package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageNavigation {
    public static WebDriver driver;

        //Страница "Для кого самокат"
    //Поле ввода имени
    public static By firstNameField = By.xpath(".//input[contains(@placeholder,'Имя')]");
    //Поле ввода фамилии
    public static By secondNameField = By.xpath(".//input[contains(@placeholder,'Фамилия')]");
    //Поле ввода адреса
    public static By addressField = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    //Список станций метро
    public static By selectMetroField = By.xpath(".//input[contains(@placeholder,'Станция метро')]");
    //Поле вода номера телефона
    public static By phoneField = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    //Выбор станции метро
    public static By getSubwayStation = By.xpath(".//div[@class='select-search__select']");
    //Кнопка "Далее"
    public static By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

        //Страница "Про аренду"
    //Поле ввода даты подачи самоката
    public static By orderDateField = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //Список длительности аренды
    public static By rentalDurationField = By.xpath(".//span[@class='Dropdown-arrow']");
    //Аренда "двое суток"
    public static By rentScooterForTwoDays = By.xpath(".//div[contains(text(), 'двое суток')]");
    //Кнопка "Заказать"
    public static By lastOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "Да"
    public static By yesButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка статуса заказа
    public static By orderStatusButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageNavigation(WebDriver driver) {
        OrderPageNavigation.driver = driver;
    }

    private void nextButtonClick() {
        driver.findElement(nextButton).click();
    }
    private void lastOrderButtonClick() {
        driver.findElement(lastOrderButton).click();
    }
    private void yesButtonClick() {
        driver.findElement(yesButton).click();
    }

    private void setName(String name) {
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(name);
    }
    private void setSecondName(String secondName) {
        driver.findElement(secondNameField).click();
        driver.findElement(secondNameField).clear();
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    private void setAddress(String address) {
        driver.findElement(addressField).click();
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    private void setMetroStation(String metroStation) {
        driver.findElement(selectMetroField).click();
        driver.findElement(selectMetroField).sendKeys(metroStation);
        driver.findElement(getSubwayStation).click();
    }

    private void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneField).click();
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    public void login(String name, String secondName, String address, String metroStation, String phoneNumber) {
        setName(name);
        setSecondName(secondName);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        nextButtonClick();
    }

    private void setOrderDate(String orderDate) {
        driver.findElement(orderDateField).click();
        driver.findElement(orderDateField).clear();
        driver.findElement(orderDateField).sendKeys(orderDate);
    }

    private void setRentalDurationForTwoDays() {
        driver.findElement(rentalDurationField).click();
        driver.findElement(rentScooterForTwoDays).click();
    }

    public void rentScooter(String orderDate) {
    setOrderDate(orderDate);
    setRentalDurationForTwoDays();
    lastOrderButtonClick();
    yesButtonClick();
    }
}