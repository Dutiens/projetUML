package uml.dutiens.org;

public class InformationDTO {
	private long id ;
	private String nom ;
	private String description ;
	private String titreAnnonce ;
	private String adresse ;
	private double tarif ;
	private String mapUrl ;


	public InformationDTO(long id, String nom , String description, String titreAnnonce, String adresse , double tarif, String mapUrl){
		this.id = id ;
		this.nom = nom; 
		this.description = description; 
		this.titreAnnonce = titreAnnonce; 
		this.adresse = adresse; 
		this.tarif = tarif; 
		this.mapUrl = mapUrl; 
	}
	public long getId() {return id;}
	public String getNom(){return nom ;}
	public String getDescription(){return description ;}
	public String getTitreAnnonce(){return titreAnnonce ;}
	public String getAdresse(){return adresse ;}
	public double getTarif(){return tarif ;}
	public String getMapUrl(){return mapUrl ;}
}
