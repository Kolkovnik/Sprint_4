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
    public static By rentalDuration = By.xpath(".//span[@class='Dropdown-arrow']");
    //Кнопка "Заказать"
    public static By lastOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка "Да"
    public static By yesButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка статуса заказа
    public static By orderStatusButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageNavigation(WebDriver driver) {
        OrderPageNavigation.driver = driver;
    }

    public void firstNameFieldClick() {
        driver.findElement(firstNameField).click();
    }

    public void secondNameFieldClick() {
        driver.findElement(secondNameField).click();
    }

    public void addressFieldClick() {
        driver.findElement(addressField).click();
    }

    public void selectMetroFieldClick() {
        driver.findElement(selectMetroField).click();
    }

    public void phoneFieldClick() {
        driver.findElement(phoneField).click();
    }

    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }

    public void getSubwayStationClick() {
        driver.findElement(getSubwayStation).click();
    }

    public void orderDateFieldClick() {
        driver.findElement(orderDateField).click();
    }

    public void rentalDurationClick() {
        driver.findElement(rentalDuration).click();
    }

    public void lastOrderButtonClick() {
        driver.findElement(lastOrderButton).click();
    }

    public void yesButtonClick() {
        driver.findElement(yesButton).click();
    }
}