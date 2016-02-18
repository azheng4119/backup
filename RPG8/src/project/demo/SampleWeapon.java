package project.demo;

public class SampleWeapon {
	private String wimagesrc;
	private String pimagesrc;
	private int dmg;
	private int velocity;
	private int maxammo;
	private int ammo;
	
	public SampleWeapon(String wimagesrc, String pimagesrc, int[] weaponstats){
		this.wimagesrc = wimagesrc;
		this.pimagesrc = pimagesrc;
		this.dmg = weaponstats[0];
		this.velocity = weaponstats[1];
		this.maxammo = weaponstats[2];
		this.ammo = weaponstats[3];
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public String getWimagesrc() {
		return wimagesrc;
	}
	
	public String getPimagesrc() {
		return pimagesrc;
	}
	
	public int getDmg() {
		return dmg;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getMaxammo() {
		return maxammo;
	}

	public int getAmmo() {
		return ammo;
	}
}
