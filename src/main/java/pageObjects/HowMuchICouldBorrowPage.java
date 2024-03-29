package pageObjects;

import AbstractComponents.AbstractComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Exception.InvalidValuePassedException;
import java.time.Duration;
import static common.CommonConst.*;



public class  HowMuchICouldBorrowPage extends AbstractComponents {
    private WebDriver driver;
    WebDriverWait wait;

    public HowMuchICouldBorrowPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "label[for='application_type_single']")
    private WebElement Single;

    @FindBy(css = "label[for='application_type_joint']")
    private WebElement Joint;

    @FindBy(css = "select[title='Number of dependants']")
    private WebElement Number_of_dependents;

    @FindBy(css = "label[for='borrow_type_home']")
    private WebElement HomeToLiveIn;
    @FindBy(css = "label[for='borrow_type_investment']")
    private WebElement residentialInvestment;

    @FindBy(css = "input[aria-labelledby='q2q1']")
    private WebElement yourAnnualIncome;

    @FindBy(css = "input[aria-labelledby='q2q2']")
    private WebElement yourAnnualOtherIncome;

    @FindBy(css = "input[aria-labelledby='q2q3']")
    private WebElement secondApplicantAnnualIncome;

    @FindBy(css = "input[aria-labelledby='q2q4']")
    private WebElement secondApplicantOtherAnnualIncome;

    @FindBy(css = "input[aria-labelledby='q3q1']")
    private WebElement monthlyLivingExpenses;

    @FindBy(css = "input[aria-labelledby='q3q2']")
    private WebElement currentHomeLoanMonthlyRepayments;
    @FindBy(css = "input[aria-labelledby='q3q3']")
    private WebElement Other_loan_monthly_repayments;
    @FindBy(css = "input[aria-labelledby='q3q4']")
    private WebElement Other_monthly_commitments;

    @FindBy(css = "input[aria-labelledby='q3q5']")
    private WebElement Total_credit_card_limits;

    @FindBy(css = "button#btnBorrowCalculater")
    private WebElement WorkOutHowMuchICouldBorrowButton;

    @FindBy(css = "span#borrowResultTextAmount")
    private WebElement EstimatedBorrowAmount;

   /* @FindBy(css = "button[class='start-over']")
    WebElement StartOver;
    @FindBy(css = "div[class='borrow__error__text']")
    WebElement ErrorText;*/

    private By startOver = By.cssSelector("button[class='start-over']");
    private By errorText = By.cssSelector("div[class='borrow__error__text']");

    public  void selectApplicationType(String applicationType) throws InvalidValuePassedException {

        WebElement webElement = null;
        if(applicationType.equalsIgnoreCase(SINGLE_APPLICATION_TYPE))
        {
            Single.click();
        }
        else if(applicationType.equalsIgnoreCase(JOINT_APPLICATION_TYPE))
        {
            Joint.click();
        }
        else
        {
            throw new InvalidValuePassedException(INVALID_APPLICATION_TYPE);
        }

    }


    public void goTo()
    {
        driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");

    }
    public void setNumber_of_dependents(int dependents)
    {
        Number_of_dependents.sendKeys(String.valueOf(dependents));
    }

    public  void selectPropertyType(String propertyType) throws InvalidValuePassedException {

        WebElement webElement = null;
        if(propertyType.equalsIgnoreCase(HOME_TO_LIVE_IN_PROPERTY_TYPE))
        {
            HomeToLiveIn.click();
        }
        else if(propertyType.equalsIgnoreCase(RESIDENTIAL_INVEST_PROPERTY_TYPE))
        {
            residentialInvestment.click();
        }
        else
        {
            throw new InvalidValuePassedException(INVALID_PROPERTY_TYPE);
        }

    }
    public  void enterYourAnnualIncome(String annualIncome)
    {
        yourAnnualIncome.sendKeys(annualIncome);

    }

    public  void enterYourAnnualOtherIncome(String annualOtherIncome){
        yourAnnualOtherIncome.sendKeys(annualOtherIncome);
    }
    public  void enterMonthlyLivingExpenses(String monthlyExpense){

        monthlyLivingExpenses.sendKeys(monthlyExpense);
    }

    public  void enterCurrentHomeLoanMonthlyRepayments(String homeLoanRepayments){
        currentHomeLoanMonthlyRepayments.sendKeys(homeLoanRepayments);
    }

    public  void enterOtherLoanMonthlyRepayments(String otherLoanRepayments){

        Other_loan_monthly_repayments.sendKeys(otherLoanRepayments);
    }

    public  void enterOtherMonthlyCommitments(String otherMonthlyComitVal){

        Other_monthly_commitments.sendKeys(otherMonthlyComitVal);
    }

    public  void enterTotalCreditCardLimits(String totalCreditCardLimitVal){

        Total_credit_card_limits.sendKeys(totalCreditCardLimitVal);
    }

    public void clickWorkOutHowMuchICouldBorrowButton(){

        WorkOutHowMuchICouldBorrowButton.click();
    }

    public String showEstimatedAmountThatCanBeBorrowed() throws InterruptedException {
        Thread.sleep(6000);
        return EstimatedBorrowAmount.getText();

    }

    public void clickStartOver(){

        visibilityOfElementLocated(startOver);
        driver.findElement(startOver).click();

    }





    public String checkErrorMessage(){
        visibilityOfElementLocated(errorText);
        String error = driver.findElement(errorText).getText();
        return error;
    }




}