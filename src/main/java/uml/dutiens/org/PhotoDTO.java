package uml.dutiens.org;

public class PhotoDTO {
	private String lien ;
	public PhotoDTO(String lien){
		this.lien = lien; 
	}
	public String getPhoto(){
		return lien ;
	}
}
