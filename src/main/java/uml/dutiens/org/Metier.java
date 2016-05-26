import java.util.* ;
import java.io.* ;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Metier{

	private String description ;
	private String nomAnnonce ;
	private String adresse ;
	private int tarif ;
	private ArrayList<String> images ;
	private String mapUrl ;
	private String agendaUrl ;

	public Metier(String nomFich){
			nomFich = "../../../../resources/uml/dutiens/org/data/" + nomFich ;
			images = new ArrayList<String>() ;
		try {	
			File inputFile = new File(nomFich);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();

			this.nomAnnonce = doc.getElementsByTagName("nomAnnonce").item(0).getTextContent();
			this.description = doc.getElementsByTagName("description").item(0).getTextContent();
			this.tarif = Integer.parseInt(doc.getElementsByTagName("tarif").item(0).getTextContent());
			this.adresse = doc.getElementsByTagName("adresse").item(0).getTextContent();
			this.mapUrl = doc.getElementsByTagName("mapUrl").item(0).getTextContent();
			this.agendaUrl = doc.getElementsByTagName("agendaUrl").item(0).getTextContent();
		
			NodeList phList = doc.getElementsByTagName("photo") ; 
			for(int i = 0 ; i < phList.getLength() ; i++)
				images.add("../../../../resources/uml/dutiens/org/images/"+phList.item(i).getTextContent()) ; 
		} catch (Exception e) {e.printStackTrace();}
	}

	public String getDescription(){return description;}
	public String getNom(){return nomAnnonce;}
	public String getAdresse(){return adresse;}
	public String getMap(){return mapUrl;}
	public String getAgenda(){return agendaUrl;}
	public int getTarif(){return tarif;}
	public ArrayList<String> getImages(){return images ;}




	public String toString(){
		return "\nNom : "+nomAnnonce+
			"\nDescription : "+description+
			"\nAdresse : "+adresse+
			"\nTarif : "+tarif+
			"\nImages : "+images ; 
	}

}
