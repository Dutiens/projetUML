import java.util.*;
public class GaleriePhotoDTO {
	private ArrayList<PhotoDTO> photos ;
	public GaleriePhotoDTO(ArrayList<String> photos){
		this.photos = new ArrayList<PhotoDTO>() ;
		for(String s : photos)
			this.photos.add(new PhotoDTO(s)) ;
	}
	public ArrayList<PhotoDTO> getGaleriePhoto(){
		return this.photos;
	}
}
