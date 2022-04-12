import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface PageInterfaceJDD {
	
	
	Properties propertyJDD = SocleTechniqueClass.initScenario();
	
	
	String Username=propertyJDD.getProperty("Username");
	String Password=propertyJDD.getProperty("Password");
	String Prenom=propertyJDD.getProperty("Prénom");
	String Nom=propertyJDD.getProperty("Nom");
	String ID=propertyJDD.getProperty("ID");
	String Nom_utilisateur=propertyJDD.getProperty("Nom_utilisateur");
	String Password_utilisateur=propertyJDD.getProperty("Password_utilisateur");
	String Email=propertyJDD.getProperty("Email");
}
