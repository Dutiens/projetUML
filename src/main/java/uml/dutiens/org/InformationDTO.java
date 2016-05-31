package uml.dutiens.org;

public class InformationDTO {
	private long id ;
	private String nom ;
	private String description ;
	private String titreAnnonce ;
	private String adresse ;
	private double tarif ;
	private double longitude ;
	private double latitude ;


	public InformationDTO(long id, String nom , String description, String titreAnnonce, String adresse , double tarif, double latitude, double longitude){
		this.id = id ;
		this.nom = nom; 
		this.description = description; 
		this.titreAnnonce = titreAnnonce; 
		this.adresse = adresse; 
		this.tarif = tarif; 
		this.latitude = latitude; 
		this.longitude = longitude; 
	}
	public long getId() {return id;}
	public String getNom(){return nom ;}
	public String getDescription(){return description ;}
	public String getTitreAnnonce(){return titreAnnonce ;}
	public String getAdresse(){return adresse ;}
	public double getTarif(){return tarif ;}
	public double getLatitude(){return latitude ;}
	public double getLongitude(){return longitude ;}
}
