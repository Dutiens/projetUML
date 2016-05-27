package uml.dutiens.org;

public class DisponibilitesDTO {
	private String lien ;
	public DisponibilitesDTO(String lien){
		this.lien = lien; 
	}
	public String getAgendaUrl(){
		return lien ;
	}
}
