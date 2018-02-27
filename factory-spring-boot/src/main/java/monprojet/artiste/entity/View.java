package monprojet.artiste.entity;

public interface View {
	
	public static interface Common{}
	public static interface Album extends Common{}
	public static interface Artiste extends Common{}
	public static interface Sacem extends Common{}
	
	public static interface AlbumWithEverything extends Artiste, Sacem{}
	
	public static interface ArtisteWithAlbum extends Album{}
	public static interface SacemWithAlbum extends Album{}
}
