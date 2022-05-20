package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private By searchLabel = By.xpath("//*[@id='columns']//child::*[@class='navigation_page' and contains(text(),'Search')]");
    private By sortByLabel= By.xpath("//*[@id='productsSortForm']//child::*[contains(text(),'Sort by')]");
    private By sortingField = By.id("selectProductSort");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement waitOfSearchLabel(){
        WebElement label = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(searchLabel));
        return label;
    }
    public boolean searchIsOpened(){
        return driver.findElement(searchLabel).isDisplayed();
    }
    public boolean sortByIsPresent(){
        return driver.findElement(sortByLabel).isDisplayed();
    }
    public void selectSortingOption(String sortingParameter){
        Select sortOptionFromDropDown = new Select(driver.findElement(sortingField));
        sortOptionFromDropDown.selectByVisibleText(sortingParameter);
    }

}