package uml.dutiens.org;

import uml.dutiens.db.DbWrapper; 

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

	private String mapUrl ;
	private String agendaUrl ;

	private DbWrapper db;
	private AnnonceDTO annonce ;

	public Metier(long id_annonce){
		this.db = new DbWrapper();
		this.db.init();

		String nomFich = String.format("src/main/resources/uml/dutiens/org/data/%06d.xml", id_annonce);
		ArrayList<String> images = new ArrayList<String>() ;
		try {	
			File inputFile = new File(nomFich);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();

			String nom = doc.getElementsByTagName("nom").item(0).getTextContent();
			//String nom = db.getNom(id_annonce);
			String titreAnnonce = doc.getElementsByTagName("nomAnnonce").item(0).getTextContent();
			String description = doc.getElementsByTagName("description").item(0).getTextContent();
			double tarif = Double.parseDouble(doc.getElementsByTagName("tarif").item(0).getTextContent());
			long id = id_annonce;
			String adresse = doc.getElementsByTagName("adresse").item(0).getTextContent();
			String mapUrl = doc.getElementsByTagName("mapUrl").item(0).getTextContent();
			String agendaUrl = doc.getElementsByTagName("agendaUrl").item(0).getTextContent();

			NodeList phList = doc.getElementsByTagName("photo") ; 
			for(int i = 0 ; i < phList.getLength() ; i++)
				images.add("./src/main/resources/uml/dutiens/org/images/"+phList.item(i).getTextContent()) ;

			this.annonce = new AnnonceDTO(id, nom, description,titreAnnonce, adresse, tarif, mapUrl, images, agendaUrl) ;
		} catch (Exception e) {e.printStackTrace();}
	}

	public long   getId() { return annonce.getInformations().getId(); }
	public String getNom() { return annonce.getInformations().getNom(); }
	public String getDescription(){return annonce.getInformations().getDescription();}
	public String getTitre(){return annonce.getInformations().getTitreAnnonce();}
	public String getAdresse(){return annonce.getInformations().getAdresse();}

	public String getMap(){return mapUrl;} //TODO Corriger

	public double getLongitudeMap(){return 0;}
	public double getLatitudeMap(){return 0;}

	public String getAgenda(){return agendaUrl;} //TODO Corriger

	public double getTarif(){return annonce.getInformations().getTarif();}

	public ArrayList<String> getImages(){
		ArrayList<String> images = new ArrayList<>();
		for (PhotoDTO photo : annonce.getPhotos().getGaleriePhoto())
			images.add(photo.getPhoto());
		return images;
	}

	public String toString(){
		return "\nNom : "+getTitre()+
			"\nDescription : "+getDescription()+
			"\nAdresse : "+getAdresse()+
			"\nTarif : "+getTarif()+
			"\nImages : "+getImages() ; 
	}
	public AnnonceDTO getAnnonce(){
		return annonce;
	}

}
