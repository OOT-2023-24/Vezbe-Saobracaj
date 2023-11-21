package geometry;

public interface Moveable {
	
	//Kljucna rec final kada se nalazi uz promenljivu onda oznacava konstantu
	// kada se nalazi uz klasu onda znaci da nije moguce naslediti-extendovati klasu
	// kada se nalazi uz metodu onda tu metodu nije moguce redefinisati
	
	//Nema potrebe da se zapisuje public static final posto se to podrazumeva 
	//int BROJ = 20;
	
	//Podrazumeva se da ispred ovih metoda stoji public abstract
	void moveBy(int byX, int byY);
	void moveTo(int x, int y);
	
}
