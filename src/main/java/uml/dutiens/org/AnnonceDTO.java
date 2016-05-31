package uml.dutiens.org;

import java.util.*;
public class AnnonceDTO{
	private DisponibilitesDTO disponibilite ;
	private InformationDTO infos ;
	private GaleriePhotoDTO photos ;
	public AnnonceDTO(long id , String nom , String description, String titreAnnonce, String adresse , double tarif, double latitude, double longitude, ArrayList<String> photos, String dispo){
		disponibilite = new DisponibilitesDTO(dispo) ;
		infos = new InformationDTO(id, nom, description, titreAnnonce, adresse, tarif, latitude, longitude) ;
		this.photos = new GaleriePhotoDTO(photos);
	}

	public DisponibilitesDTO getDisponibilites(){ return disponibilite;}
	public InformationDTO getInformations(){ return infos;}
	public GaleriePhotoDTO getPhotos(){return photos;}

}
