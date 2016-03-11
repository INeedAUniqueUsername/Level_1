// Copyright Wintriss Technical Schools 2013
public class TeaMaker {

	/* Figure out how to make a cup of tea using the classes below */
	public static void main(String[] args)
	{
		TeaBag bag = new TeaBag(new TeaBag(randomFlavor()).GREEN);
		System.out.println(bag.getFlavor());
		Kettle kettle = new Kettle();
		System.out.println(kettle.getWater());
		kettle.boil();
		System.out.println(	kettle.getWater().isHot());
		Cup cup = new Cup();
		cup.makeTea(bag, kettle.getWater());
		
	}
	
	public static String randomFlavor()
	{
		String[] flavorz = new String[10];
		int random = (int) (flavorz.length*Math.random());
		flavorz[0] = "Vanilla";
		flavorz[1] = "Moldy";
		flavorz[2] = "Chalkleight";
		flavorz[3] = "Poison Fruit";
		flavorz[4] = "Paranormal";
		flavorz[5] = "Tea Flavor";
		flavorz[6] = "Forgotten";
		flavorz[7] = "Quantum";
		flavorz[8] = "Depression Fruit";
		flavorz[9] = "Cancer";
		return flavorz[random];
	}
}

class TeaBag {

	public final static String GREEN = "Green";
	public final static String MINT = "Mint";
	public final static String CHAMOMILE = "Chamomile";
	public final static String PASSION_FRUIT = "Passion Fruit";

	private String flavor;

	TeaBag(String flavor) {
		this.flavor = flavor;
	}

	String getFlavor() {
		return flavor;
	}

}

class Kettle {

	private Water water = new Water();

	Water getWater() {
		return water;
	}

	void boil() {
		this.water.isHot = true;
	}

	class Water {

		private boolean isHot = false;

		public boolean isHot() {
			return this.isHot;
		}
	}

}

class Cup {

	private TeaBag teabag;

	void makeTea(TeaBag teabag, Kettle.Water hotWater) {
		this.teabag = teabag;
		if (hotWater.isHot())
			System.out.println("Making hot " + teabag.getFlavor() + " tea.");
		else
			System.out.println("Can't make tea with cold water! ");
	}

}


