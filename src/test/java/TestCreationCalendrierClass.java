import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCreationCalendrierClass {
	
	WebDriver driver;
	WebDriverWait wait;

	@Before

	public void setup() throws Exception {

		//Initialisation du driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		
		//initialiser le fichier.properties
		Properties propertyJDD = new Properties();
	    propertyJDD.load(new FileInputStream("src/main/resources/JDD.properties/JDD.properties"));
	    
	    //aller sur le site du PROJET
	    driver.get(propertyJDD.getProperty("URL"));
	    driver.manage().window().maximize();

	}

	@After

	public void teardown() {
		driver.quit();
	}

	
	@Test
	public void test() throws Exception {
		
		wait = new WebDriverWait(driver, 15); // Explicit wait
		
		  //v�rifier que la page est correcte
	    assertEquals("LibrePlan: acc�s utilisateur", driver.getTitle());
	    
	    //initialiser la PageConnexion
	    PageConnexion page_connexion = PageFactory.initElements(driver, PageConnexion.class);
	    
	    
	    //se connecter � la page d'accueil
	    PageAccueil page_accueil = page_connexion.logIn(driver, "admin", "admin");
	    
	    //v�rification page accueil
	    WebElement fil_d_ariane_calendrier = wait.until(ExpectedConditions.visibilityOf(page_accueil.fil_d_ariane_calendrier)); // Explicit wait
	    boolean verifPage = fil_d_ariane_calendrier.isDisplayed();

        assertTrue(verifPage);
	
	    //acc�der � la page de la liste des calendriers
	   PageListeCalendrier page_liste_calendrier = page_accueil.clicItemCalendrier(driver);
	   
	   //v�rification page liste calendrier
	   WebElement titre_liste_calendrier = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Titre_Liste_Calendrier)); // Explicit wait
	   WebElement colonne_nom = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Colonne_Nom));
	   WebElement colonne_op�rations = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Colonne_Op�rations));
	   WebElement colonne_h�rit�_date = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Colonne_H�rit�_Date));
	   WebElement colonne_h�ritage_a_jour = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Colonne_H�ritages_A_Jour));
	    boolean verifPage1 = titre_liste_calendrier.isDisplayed()&& colonne_nom.isDisplayed()&&colonne_op�rations.isDisplayed()
	    		&&colonne_h�rit�_date.isDisplayed()&&colonne_h�ritage_a_jour.isDisplayed();

       assertTrue(verifPage1);
	   
	   //acc�der � la page de cr�ation des calendriers
	   
	   PageCreationCalendrier page_creation_calendrier = page_liste_calendrier.clicCreerCalendrier(driver);
	   
	   //v�rification page cr�ation calendrier
	   
	   WebElement titre_cr�er_calendrier = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Titre_Creer_Calendrier)); // Explicit wait
	   WebElement donn�es_calendrier = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Donn�es_Calendrier));
	   WebElement enregistrer_button = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Enregistrer_button));
	   WebElement enregistrer_continuer_button = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Enregistrer_Continuer_button));
	   WebElement annuler_button = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Annuler_button));
	    boolean verifPage2 = titre_cr�er_calendrier.isDisplayed()&& donn�es_calendrier.isDisplayed()&&enregistrer_button.isDisplayed()
	    		&&enregistrer_continuer_button.isDisplayed()&&annuler_button.isDisplayed();

       assertTrue(verifPage2); 
       
       //cr�er un calendrier
       
       boolean verif3 = page_creation_calendrier.checkBoxCodeVerif();
		assertTrue(verif3);
		
		page_creation_calendrier.CreerCalendrier(driver,"Calendrier - Test 1");
		
	   //v�rification cr�ation calendrier
		WebElement calendrier_test_1 = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Calendrier_Test_1));
		boolean verifPage4 = titre_liste_calendrier.isDisplayed()&& calendrier_test_1.isDisplayed();

       assertTrue(verifPage4);
       
       //cr�er une d�rive
       page_liste_calendrier.CreerD�rive(driver);
       
       //v�rification de la page de d�rive
       
       WebElement type_d�rive = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Type_D�rive));
       boolean verifPage5 = titre_cr�er_calendrier.isDisplayed()&& type_d�rive.isDisplayed();
       assertTrue(verifPage5);
       //v�rification case nom vide
       assertEquals(page_creation_calendrier.Nom_Fieldset.getAttribute("value"), "");
      
       //Cr�er un calendrier d�riv� - nom non conforme
      
      	boolean verif6 = page_creation_calendrier.checkBoxCodeVerif();
		assertTrue(verif6);
		
		page_creation_calendrier.CreerCalendrier(driver,"Calendrier - Test 1");
		
		//v�rification du message de non conformit�
		WebElement message_non_conforme = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Message_Non_Conforme));
	       boolean verifPage7 = message_non_conforme.isDisplayed();
	       assertTrue(verifPage7);
	   
	     //Cr�er un calendrier d�riv� conforme
	       
	       boolean verif8 = page_creation_calendrier.checkBoxCodeVerif();
			assertTrue(verif8);
			
			page_creation_calendrier.Creer_continuer_Calendrier(driver,"Calendrier - Test Calendrier D�riv�");
			
		//v�rification cr�ation calendrier d�riv�
			
			WebElement titre_d�rive = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Titre_D�rive));
			WebElement message_confirmation_d�rive = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Message_confirmation_d�rive));
		       boolean verifPage9 = titre_d�rive.isDisplayed()&&message_confirmation_d�rive.isDisplayed();
		       assertTrue(verifPage9);
		       
		//Retour page de gestion des calendriers
			
		   page_creation_calendrier.Annuler_Calendrier(driver);
			
		//v�rification retour page liste	
			WebElement calendrier_d�rive_test_1 = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Calendrier_d�rive_test_1));
			boolean verifPage10 = titre_liste_calendrier.isDisplayed()&& calendrier_d�rive_test_1.isDisplayed();

	       assertTrue(verifPage10);	
		
	       //affichage calendrier d�riv�
	       
	       page_liste_calendrier.Minusbuttonclick(driver);
	       
	       //v�rification que le calendrier d�riv� n'est plus affich�
	       assertEquals(page_liste_calendrier.Minus_button_close.getAttribute("class"), "z-dottree-ico z-dottree-root-close");
		
	       //cliquer sur le bouton cr�er une copie d'un calendrier
	       
	       page_liste_calendrier.Copybuttonclick(driver);
	       
	       //v�rification affichage page creation suite � copie
	          
		    boolean verifPage11 = titre_cr�er_calendrier.isDisplayed();
	       assertTrue(verifPage11);
	       assertEquals(page_creation_calendrier.Nom_Fieldset.getAttribute("value"), "Calendrier - Test 1");
	       assertEquals(page_creation_calendrier.Type_Field.getText(), "Calendrier source");
	       
	      //Cr�er une copie non conforme
	       
	       page_creation_calendrier.Creer_continuer_Calendrier(driver,"Calendrier - Test 1");
	       
	      //v�rification message erreur de la copie
	       
	       WebElement message_copie_non_conforme = wait.until(ExpectedConditions.visibilityOf(page_creation_calendrier.Message_Copie_Non_Conforme));
	       boolean verifPage12 = message_copie_non_conforme.isDisplayed();
	       assertTrue(verifPage12);
	       
	      //cr�er une copie conforme
	       
	       boolean verif13 = page_creation_calendrier.checkBoxCodeVerif();
			assertTrue(verif13);
	       page_creation_calendrier.CreerCalendrier(driver,"Calendrier - Test 2");
	       
	      //v�rification copie conforme
	       
	       WebElement message_test_enregistr� = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Message_test_enregistr�));
	       WebElement calendrier_test_2 = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Calendrier_test_2));
			boolean verifPage14 = titre_liste_calendrier.isDisplayed()&& message_test_enregistr�.isDisplayed()&&calendrier_test_2.isDisplayed();

	       assertTrue(verifPage14);
	      
	     //Suppression calendrier 1 et 2 pour clean database
	       
	       page_liste_calendrier.Supprimerbuttonclick(driver);
	       
	     //v�rification Supression
	       
	       WebElement message_suppression_test_1 = wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Message_supression_test_1));
	       WebElement message_suppression_test_2= wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Message_supression_test_2));
	       WebElement message_suppression_test_d�riv�= wait.until(ExpectedConditions.visibilityOf(page_liste_calendrier.Message_supression_test_d�riv�));
			boolean verifPage15 = message_suppression_test_1.isDisplayed()&& message_suppression_test_2.isDisplayed()&&message_suppression_test_d�riv�.isDisplayed();

	       assertTrue(verifPage15);
	      
	}

}

