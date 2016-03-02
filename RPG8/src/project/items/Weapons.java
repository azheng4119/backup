package project.items;

public class Weapons extends Item{
	private Ammo ammo;
	private int damage;
	private int ammoClip;
	private int ammoCapacity;
	private double criticalHit;
	private int critHitMul;
	private int weight;
	private boolean buyable;
	private int cost;
	private String rof;
	private double rofRPS;
	private double reloadSpd;
	private boolean secondaryFire;
	private boolean canSilence;
	private int gunNum;
	private int ammoTotal;
	private int pellets;
	private int splash;
	private String gunImage;
	
	
	public Weapons(String name, String desc, Ammo ammo, int damage, int ammoClip, int ammoCapacity,
			double criticalHit, int critHitMul, int weight, boolean buyable, int cost, String rof, double rofRPS, 
			double reloadSpd, boolean secondaryFire, boolean canSilence, int effect, int pellets, int splash,
			String gunImage,  int gunNum) {
		super(name, desc,cost, effect);
		
		this.ammo = ammo;
		this.damage = damage;
		this.ammoClip = ammoClip;
		this.ammoCapacity = ammoCapacity;
		this.criticalHit = criticalHit;
		this.critHitMul = critHitMul;
		this.weight = weight;
		buyable = true;
		this.cost = cost;
		this.rof = rof;
		this.rofRPS = rofRPS;
		this.reloadSpd = reloadSpd;
		secondaryFire = false;
		canSilence = true;
		this.gunNum = gunNum;
		ammoTotal = ammoClip;
		this.pellets = pellets;
		this.splash = splash;
		this.gunImage = gunImage;
	}

	public int getSplash() {
		return splash;
	}
	public String getGunImage() {
		return gunImage;
	}
	public int getAmmoTotal() {
		return ammoTotal;
	}
	public int getPellets() {
		return pellets;
	}
	public void setAmmoTotal(int ammoTotal) {
		this.ammoTotal = ammoTotal;
	}
	public Ammo getAmmo() {
		return ammo;
	}

	public void setAmmo(Ammo ammo) {
		this.ammo = ammo;
	}

	public int getDamage() {
		return damage;
	}

	public int getAmmoClip() {
		return ammoClip;
	}

	public void setAmmoClip(int ammoClip) {
		if(ammoTotal <= ammoClip){
			this.ammoClip = ammoClip;
		}	
	}

	public int getAmmoCapacity() {
		return ammoCapacity;
	}

	public void setAmmoCapacity(int ammoCapacity) {
		this.ammoCapacity = ammoCapacity;
	}

	public double getCriticalHit() {
		return criticalHit;
	}

	public void setCriticalHit(double criticalHit) {
		this.criticalHit = criticalHit;
	}

	public int getCritHitMul() {
		return critHitMul;
	}

	public void setCritHitMul(int critHitMul) {
		this.critHitMul = critHitMul;
	}

	public boolean isBuyable() {
		return buyable;
	}

	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public double getReloadSpd() {
		return reloadSpd;
	}

	public boolean isSecondaryFire() {
		return secondaryFire;
	}

	public void setSecondaryFire(boolean secondaryFire) {
		this.secondaryFire = secondaryFire;
	}

	public boolean isCanSilence() {
		return canSilence;
	}

	public void setCanSilence(boolean canSilence) {
		this.canSilence = canSilence;
	}

	public int getGunNum() {
		return gunNum;
	}

	public int getWeight() {
		return weight;
	}

	public String getRof() {
		return rof;
	}

	public double getRofRPS() {
		return rofRPS;
	}

}
