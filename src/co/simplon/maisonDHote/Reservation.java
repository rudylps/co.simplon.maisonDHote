package co.simplon.maisonDHote;

public class Reservation {

	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private int nbPersonne;
	private String region;
	private String dateArrivee;
	private int nbNuit;
	private boolean animal;
	private boolean parking;
	private boolean dej;
	private String typeSejour;
	private int prixTotal;
	
	public int getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public int getNbNuit() {
		return nbNuit;
	}
	public void setNbNuit(int nbNuit) {
		this.nbNuit = nbNuit;
	}
	public boolean isAnimal() {
		return animal;
	}
	public void setAnimal(boolean animal) {
		this.animal = animal;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isDej() {
		return dej;
	}
	public void setDej(boolean dej) {
		this.dej = dej;
	}
	public String getTypeSejour() {
		return typeSejour;
	}
	public void setTypeSejour(String typeSejour) {
		this.typeSejour = typeSejour;
	}
	
	
	
	
}
