package uml.dutiens.org;

import java.util.* ;
import java.io.* ;

import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class Metier {

	private long id;
	private String nom;
	private String description ;
	private String titreAnnonce ;
	private String adresse ;
	private double tarif ;
	private ArrayList<String> images ;
	private String mapUrl ;
	private String agendaUrl ;
	private AnnonceDTO annonce ;

	public Metier(String nomFich){
			nomFich = "src/main/resources/uml/dutiens/org/data/" + nomFich ;
			images = new ArrayList<String>() ;
		try {	
			File inputFile = new File(nomFich);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();

			this.nom = doc.getElementsByTagName("nom").item(0).getTextContent();
			this.titreAnnonce = doc.getElementsByTagName("nomAnnonce").item(0).getTextContent();
			this.description = doc.getElementsByTagName("description").item(0).getTextContent();
			this.tarif = Double.parseDouble(doc.getElementsByTagName("tarif").item(0).getTextContent());
			this.id = Long.parseLong(doc.getElementsByTagName("id").item(0).getTextContent());
			this.adresse = doc.getElementsByTagName("adresse").item(0).getTextContent();
			this.mapUrl = doc.getElementsByTagName("mapUrl").item(0).getTextContent();
			this.agendaUrl = doc.getElementsByTagName("agendaUrl").item(0).getTextContent();
		
			NodeList phList = doc.getElementsByTagName("photo") ; 
			for(int i = 0 ; i < phList.getLength() ; i++)
				images.add("../../../../resources/uml/dutiens/org/images/"+phList.item(i).getTextContent()) ;

			 this.annonce = new AnnonceDTO(id, nom, description,titreAnnonce, adresse, tarif, mapUrl, images, agendaUrl) ;
		} catch (Exception e) {e.printStackTrace();}
	}

	public long   getId() { return id; }
	public String getNom() { return nom; }
	public String getDescription(){return description;}
	public String getTitre(){return titreAnnonce;}
	public String getAdresse(){return adresse;}
	public String getMap(){return mapUrl;}
	public String getAgenda(){return agendaUrl;}
	public double getTarif(){return tarif;}
	public ArrayList<String> getImages(){return images ;}

	public String toString(){
		return "\nNom : "+titreAnnonce+
			"\nDescription : "+description+
			"\nAdresse : "+adresse+
			"\nTarif : "+tarif+
			"\nImages : "+images ; 
	}
	public AnnonceDTO getAnnonce(){
		return annonce;
	}

}
