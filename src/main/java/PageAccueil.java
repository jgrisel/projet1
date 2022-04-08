import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAccueil extends PageBandeau {
	
	public PageAccueil(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//tr[@valign='top']//span[text()='Calendrier']")
    public WebElement fil_d_ariane_calendrier;

}
