
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sql.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Order {
    private WebDriver driver;
    static DBWorker worker = new DBWorker();


    public Order(WebDriver driver) {
        this.driver = driver;
    }

    By orderPhone = By.xpath("//input[@id='orderPhone']");
    By orderEmail = By.xpath("//input[@id='orderEmail']");
    By orderFio = By.xpath("//input[@id='orderName']");
    By orderAddress = By.xpath("//textarea[@id='deliveryAddress']");

    By orderCity = By.xpath("//input[@id='deliveryCity']");
    By orderStreet = By.xpath("//input[@id='deliveryStreet']");
    By orderHouse = By.xpath("//input[@id='deliveryHouse']");
    By orderApartment = By.xpath("//input[@id='deliveryApartment']");
    By orderFrontDoor = By.xpath("//input[@id='deliveryFrontDoor']");
    By orderFloor = By.xpath("//input[@id='deliveryFloor']");
    By orderHouseCode = By.xpath("//input[@id='deliveryHouseCode']");
    By orderCommentForCourier = By.xpath("//textarea[@id='courierComment']");
    By orderComment = By.xpath("//textarea[@name='comment']");
    By payButton = By.xpath("//span[text()='Перейти к оплате']");
    By orderButton = By.xpath("//span[text()='Оформить заказ']");
    By addAddressButton = By.xpath("//span[text()='Добавить этаж, домофон, комментарий']");
    By searchbox = By.xpath("//input[@id='searchbox']");


    By addCommentButton = By.xpath("//button[text()='Добавить комментарий к заказу']");
//    By addCommentButton = By.cssSelector(".order-summary__comment-trigger");

    By authPassword = By.xpath("//div[@class='verify-form__row']/input[@name='code']");
    By confirmButton = By.xpath("//span[text()='Подтвердить']");
    By whatsAppButton = By.xpath("//span[text()='Сообщение в WhatsApp']");
    By phoneButton = By.xpath("//span[text()='Звонок по телефону']");
    By smsButton = By.xpath("//span[text()='СМС о статусе заказа']");
    By companyStoreButton = By.xpath("//span[text()='Забрать в фирменном магазине']");
    By metropolisStoreButton = By.xpath("//span[text()='Poison Drop в ТЦ «Метрополис»']");
    By redBridgeStoreButton = By.xpath("//span[text()='Poison Drop в Универмаге «Au Pont Rouge. У Красного моста»']");
    By atriumStoreButton = By.xpath("//span[text()='Poison Drop в ТЦ «Атриум»']");
    By internationalButton = By.xpath("//span[text()='Доставить в другую страну']");
    By orderCountry = By.xpath("//input[@id='internationalCountry']");
    By orderInternationalCity = By.xpath("//input[@id='internationalCity']");
    By orderInternationalAddress = By.xpath("//input[@id='internationalAddress']");
    By noPayButton = By.xpath("//label[@for='offlinePayment']/span");
    By pickPointButton = By.xpath("//span[text()='Доставить до постамата по России']");
    By selectPostomatButton = By.xpath("//span[text()='Выбрать постамат']");
    By searchboxButton = By.xpath("//div[@class='combobox searchbox']/span");
    By rodonitButton = By.xpath("//div[@onclick='PickPointWidgetHost.showPointBox(\"6601-054\"); return false;']");
    By selectButton = By.xpath("//div[text()='ВЫБРАТЬ']");
    By paperButton = By.xpath("//span[text()='Бумажный']");


    //headers
    By payHeader = By.xpath("//span[text()='Заплатить']");
    By orderHeader = By.xpath("//span[text()='Мы приняли ваш заказ']");


    public String getPayHeader() {
        return driver.findElement(payHeader).getText();
    }

    public String getOrderHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
        return driver.findElement(orderHeader).getAttribute("textContent");
    }

    public Order typePhone(String phone) {
        driver.findElement(orderPhone).sendKeys(phone);
        return this;
    }

    public Order typeEmail(String email) {
        driver.findElement(orderEmail).sendKeys(email);
        return this;
    }

    public Order typeFio(String fio) {
        driver.findElement(orderFio).sendKeys(fio);
        return this;
    }

    public Order typeOrderAddress(String address) {
        driver.findElement(orderAddress).sendKeys(address);
        return this;
    }

    public Order typeCity(String city) {
        driver.findElement(orderCity).sendKeys(city);
        return this;
    }

    public Order typeStreet(String street) {
        driver.findElement(orderStreet).sendKeys(street);
        return this;
    }

    public Order typeHouse(String house) {
        driver.findElement(orderHouse).sendKeys(house);
        return this;
    }

    public Order typeApartment(String apartment) {
        driver.findElement(orderApartment).sendKeys(apartment);
        return this;
    }

    public Order typeFrontDoor(String frontDoor) {
        driver.findElement(orderFrontDoor).sendKeys(frontDoor);
        return this;
    }

    public Order typeFloor(String floor) {
        driver.findElement(orderFloor).sendKeys(floor);
        return this;
    }

    public Order typeHouseCode(String houseCode) {
        driver.findElement(orderHouseCode).sendKeys(houseCode);
        return this;
    }

    public Order typeCommentForCourier(String commentForCourier) {
        driver.findElement(orderCommentForCourier).sendKeys(commentForCourier);
        return this;
    }

    public Order typeComment(String comment) {
        driver.findElement(orderComment).sendKeys(comment);
        return this;
    }

    public Order clickOnPayButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(payButton));
        return this;
    }

    public Order clickOnOrderButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(orderButton));
//        driver.findElement(orderButton).click();
        return this;
    }

    public Order clickOnAddAdresButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(addAddressButton));
//        driver.findElement(addAdresButton).click();
        return this;
    }

    public Order clickOnAddCommentButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", driver.findElement(addCommentButton));
        return this;
    }

    public Order typePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(authPassword));
        driver.findElement(authPassword).sendKeys(password);

        driver.findElement(authPassword).sendKeys(String.valueOf(password));
        return this;
    }

    public Order clickOnConfirmButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(confirmButton));
        return this;
    }

    public Order clickOnWhatsAppButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(whatsAppButton));
        return this;
    }

    public Order clickOnPhoneButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(phoneButton));
        return this;
    }

    public Order clickOnSmsButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(smsButton));
        return this;
    }

    public Order clickOnCompanyStoreButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(companyStoreButton));
        return this;
    }

    public Order clickOnPickPointButton() {
        driver.findElement(pickPointButton).click();
        return this;
    }

    public Order clickOnSelectPostomatButton() {
        driver.findElement(selectPostomatButton).click();
        return this;
    }

    public Order clickOnSearchboxButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(searchboxButton));
//        driver.findElement(searchboxButton).click();
        return this;
    }

    public Order clickOnMetropolisStoreButton() {
        driver.findElement(metropolisStoreButton).click();
        return this;
    }

    public Order clickOnRedBridgeStoreButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(redBridgeStoreButton));
        return this;
    }

    public Order clickOnAtriumStoreButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(atriumStoreButton));
//        driver.findElement(atriumStoreButton).click();
        return this;
    }

    public Order clickOnInternationalButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(internationalButton));
//        driver.findElement(internationalButton).click();
        return this;
    }

    public Order typeCountry(String country) {
        driver.findElement(orderCountry).sendKeys(country);
        return this;
    }

    public Order typeInternationalCity(String internationalCity) {
        driver.findElement(orderInternationalCity).sendKeys(internationalCity);
        return this;
    }

    public Order typeInternationalAddress(String internationalAddress) {
        driver.findElement(orderInternationalAddress).sendKeys(internationalAddress);
        return this;
    }

    public Order clickOnNoPayButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(noPayButton));
        return this;
    }

    public Order confirmWithPassword(String password) {
        this.typePassword(password);
        this.clickOnConfirmButton();
        return new Order(driver);
    }

    public Order typeSearchbox(String search) {
        driver.findElement(searchbox).sendKeys(search);
        return this;
    }

    public Order clickOnRodonitButton() {
        driver.findElement(rodonitButton).click();
        return this;
    }

    public Order clickOnSelectButton() {
        driver.findElement(selectButton).click();
        return this;
    }

    public Order clickOnPaperButton() {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", driver.findElement(paperButton));
//        driver.findElement(paperButton).click();
        return this;
    }

    //Курьер
    public Order orderWithAllStrings(String phone, String email, String fio, String address, String apartment,
                                     String frontDoor, String floor, String houseCode, String commentForCourier, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithWhatsApp(String phone, String email, String fio, String address, String apartment,
                                   String frontDoor, String floor, String houseCode, String commentForCourier, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();

        return new Order(driver);
    }

    //Заказы без оплаты
    public Order orderWithNoPayAndPhone(String phone, String email, String fio, String address, String apartment,
                                        String frontDoor, String floor, String houseCode, String commentForCourier) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnNoPayButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order orderWithNoPayAndWA(String phone, String email, String fio, String address, String apartment,
                                     String frontDoor, String floor, String houseCode, String commentForCourier) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    //Цветной:
    public Order orderWithCompanyStoreTsvetnoy(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreTsvetnoyWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreTsvetnoySms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnSmsButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order tsvetnoyWithNoPayAndPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnNoPayButton();
        this.clickOnPhoneButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order tsvetnoyWithNoPayAndWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order tsvetnoyWithNoPayAndSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnNoPayButton();
        this.clickOnSmsButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }


    //Метрополис:
    public Order orderWithCompanyStoreMetropolisPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreMetropolisWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreMetropolisSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnSmsButton();
        this.clickOnPayButton();
        return new Order(driver);
    }


    public Order metropolisWithNoPayAndPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnNoPayButton();
        this.clickOnPhoneButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order metropolisWithNoPayAndWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order metropolisWithNoPayAndSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnNoPayButton();
        this.clickOnSmsButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    //Атриум:
    public Order orderWithCompanyStoreAtriumPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreAtriumWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithCompanyStoreAtriumSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnSmsButton();
        this.clickOnPayButton();
        return new Order(driver);
    }


    public Order atriumWithNoPayAndPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnNoPayButton();
        this.clickOnPhoneButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order atriumWithNoPayAndWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order atriumWithNoPayAndSMS(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnNoPayButton();
        this.clickOnSmsButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }


    //У Красного моста:
    public Order orderWithredBridgePhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithredBridgeWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithredBridgeSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnSmsButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order redBridgeWithNoPayAndPhone(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnNoPayButton();
        this.clickOnPhoneButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order redBridgeWithNoPayAndWA(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order redBridgeWithNoPayAndSms(String phone, String email, String fio) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnNoPayButton();
        this.clickOnSmsButton();
        this.clickOnOrderButton();
        return new Order(driver);
    }


    //Доставить в другую страну:
    public Order internationalWithPhone(String phone, String email, String fio, String country, String internationalCity, String internationalAddress) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnInternationalButton();
        this.typeCountry(country);
        this.typeInternationalCity(internationalCity);
        this.typeInternationalAddress(internationalAddress);
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order internationalWithWhatsApp(String phone, String email, String fio, String country, String internationalCity, String internationalAddress) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnInternationalButton();
        this.typeCountry(country);
        this.typeInternationalCity(internationalCity);
        this.typeInternationalAddress(internationalAddress);
        this.clickOnWhatsAppButton();
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order orderWithPickPointPhone(String phone, String email, String fio, String search) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPickPointButton();
        this.clickOnSelectPostomatButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String windowHandler : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandler);
        }
//        this.typeSearchbox(search);
        this.clickOnSearchboxButton();
        this.clickOnRodonitButton();
        this.clickOnSelectButton();
        this.clickOnPhoneButton();
        this.clickOnPayButton();
        return new Order(driver);
    }


    //Сертификаты:
    public Order elCertificateWithPhone(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order elCertificateWithWA(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnWhatsAppButton();
        //скрол вниз страницы
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithPhone(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    //Бумажный
    public Order certificateWithPhone(String phone, String email, String fio, String address, String apartment,
                                        String frontDoor, String floor, String houseCode, String commentForCourier, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithWA(String phone, String email, String fio, String address, String apartment,
                                      String frontDoor, String floor, String houseCode, String commentForCourier, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnWhatsAppButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithTsvetnoyAndPhone(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithMetropolisAndWA(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnWhatsAppButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithAtriumAndSMS(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnSmsButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    public Order certificateWithRedBridgeAndPhone(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    //Доставить в другую страну:
    public Order certificateWithInternationalAndPhone(String phone, String email, String fio, String country,
                                                      String internationalCity, String internationalAddress, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnInternationalButton();
        this.typeCountry(country);
        this.typeInternationalCity(internationalCity);
        this.typeInternationalAddress(internationalAddress);
        this.clickOnWhatsAppButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnPayButton();
        return new Order(driver);
    }

    //Бумажный сертификат без оплаты:
    public Order certificateWithNoPayAndPhone(String phone, String email, String fio, String address, String apartment,
                                      String frontDoor, String floor, String houseCode, String commentForCourier, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.typeOrderAddress(address);
        this.typeApartment(apartment);
        this.typeFrontDoor(frontDoor);
        this.clickOnAddAdresButton();
        this.typeFloor(floor);
        this.typeHouseCode(houseCode);
        this.typeCommentForCourier(commentForCourier);
        this.clickOnNoPayButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order certificateWithNoPayMetropolisAndSMS(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnMetropolisStoreButton();
        this.clickOnNoPayButton();
        this.clickOnSmsButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order certificateWithNoPayTsvetnoyAndWA(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order certificateWithNoPayAtriumAndPhone(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnAtriumStoreButton();
        this.clickOnNoPayButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnOrderButton();
        return new Order(driver);
    }

    public Order certificateWithNoPayRedBridgeAndWA(String phone, String email, String fio, String comment) {
        this.typePhone(phone);
        this.typeEmail(email);
        this.typeFio(fio);
        this.clickOnPaperButton();
        this.clickOnCompanyStoreButton();
        this.clickOnRedBridgeStoreButton();
        this.clickOnNoPayButton();
        this.clickOnWhatsAppButton();
        this.clickOnAddCommentButton();
        this.typeComment(comment);
        this.clickOnOrderButton();
        return new Order(driver);
    }


    //SQL
    public String getPhonePassword() {
        worker = new DBWorker();
        String code = null;
        String query = "select code from user_authentication_code where phone=+79126459328";

        try {
            Statement statement = worker.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                code = resultSet.getString("code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }


    public static void main(String[] args) {
        worker = new DBWorker();
        String code = "";
        String query = "select code from user_authentication_code where phone=+79126459328";

        try {
            Statement statement = worker.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                code = resultSet.getString("code");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(code);
    }

}