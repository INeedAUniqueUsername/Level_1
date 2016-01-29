public class Platypus {
	private String name;
	
	public Platypus()
	{
	}
	
	public Platypus(String name)
	{
		this.name = name;
	}
	
	void sayHi(){
		System.out.println("The platypus " + name + " is smarter than your average platypus.");
	}
	
	public static void main(String[] args) {
		//1. Make an instance of your new pet platypus
		Platypus perry = new Platypus();
		//2. Call the sayHi method
		perry.sayHi();
		//3. Create a constructor in the platypus class so that you can give your platypus a name.
		perry = new Platypus("Perry");
		perry.sayHi();
		
		Platypus platypus = new Platypus("The platypus Perry is smarter than your average platypus.");
		platypus.sayHi();
		
		Platypus oxymoron = new Platypus("(actually not a platypus)");
		oxymoron.sayHi();
	}
}
