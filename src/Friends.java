public class Friends {


	public static void main(String[] args){
    	//3. Create an instance of Classmate for each person in your class.
   	 	Classmate[] classmates = new Classmate[7];
    	//4. set descriptions for each Classmate
   	 	for(int i = 0; i < classmates.length; i++)
   	 	{
   	 		classmates[i] = new Classmate();
   	 	}
   	 	classmates[0].setDescription("I don't know...");
   	 	classmates[1].setDescription("A human with  1 body, 1 head, 2 arms, 2 legs, 2 hands, 2 feet, 2 eyes, 1 nose, 2 ears, 1 mouth, 1 stomach, 1 heart. 1 liver, 2 lungs, 2 kidneys, 2 intestines, 10 fingers, 10 toes, and 2 heads");
   	 	classmates[2].setDescription("Hey! I know this person! He is my classmate!");
   	 	classmates[3].setDescription("Error: Unknown variable 'TODO: Write Description'");
   	 	classmates[4].setDescription("Just another classmate");
   	 	classmates[5].setDescription("This person's name is Abcdefghijklmnopqrstuvwxyz 1234567890");
   	 	classmates[6].setDescription("Me");
   	 //5. Use your getter to print out each description
   	 	for(int i = 0; i < classmates.length; i++)
   	 	{
   	 		System.out.println(classmates[i].getDescription());
   	 	}
	}





}
class Classmate{
	String description;
    
	//1. create a setter that sets a description for this person
	void setDescription(String description)
	{
		this.description = description;
	}
	//2. create a getter that gets a description of this person
	String getDescription()
	{
		return description;
	}
}

