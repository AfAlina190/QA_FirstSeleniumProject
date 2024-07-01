package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage1{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ":nth-child(29)>a")
    WebElement alertJsWindow;

    public JsAlertsWidowsPage getJSAlertsPage() {
        click(alertJsWindow);
        return new JsAlertsWidowsPage(driver);
    }

    @FindBy(css = ":nth-child(33)>a")
    WebElement multipleWindowsLink;
    public MultipleWindowsPage getMultipleWindowsPage() {
        click(multipleWindowsLink);
        return new MultipleWindowsPage(driver);
    }

    @FindBy(css = ":nth-child(34)>a")
    WebElement nestedFrames;
    public NestedFramesPage getNestedFramesPage(){
        click(nestedFrames);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Horizontal Slider')]")
    WebElement sliderPage;

    public SliderPage getSliderPage() {
        click(sliderPage);
        return new SliderPage(driver);

    }

    @FindBy(xpath = "//a[contains(text(),'Hovers')]" )
    WebElement hoverPage;

    public HoverPage getHoversPage() {
        click(hoverPage);
        return new HoverPage(driver);
    }

    @FindBy(css = ":nth-child(7)>a")
    WebElement contextMenuLink;

    public ContextMenuPage getContextMenuPage() {
        click(contextMenuLink);
        return new ContextMenuPage(driver);
    }

    @FindBy(css = ":nth-child(11)>a")
    WebElement dropdownLink;

    public DropDownListPage getDropdownListPage() {
        click(dropdownLink);
        return new DropDownListPage(driver);
    }

    @FindBy(css = ":nth-child(10)>a")
    WebElement dragAndDropLink;

    public DragAndDropPage getDragAndDropPage() {
        click(dragAndDropLink);
        return new DragAndDropPage(driver);
    }
}

