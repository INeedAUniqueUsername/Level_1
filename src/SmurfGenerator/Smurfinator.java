package SmurfGenerator;

import java.util.Random;

public class Smurfinator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Smurf handy = new Smurf("Handy");
		System.out.println(handy.getName());
		handy.eat();
		Smurf papa = new Smurf("Papa");
		System.out.println(papa.getName());
		System.out.println(papa.getHatColor());
		System.out.println(papa.isGirlOrBoy());
		Smurf smurfette = new Smurf("Smurfette");
		System.out.println(smurfette.getName());
		System.out.println(smurfette.getHatColor());
		System.out.println(smurfette.isGirlOrBoy());
		String[] alphabet = new String[26];
		alphabet[0] = "a";
		alphabet[1] = "b";
		alphabet[2] = "c";
		alphabet[3] = "d";
		alphabet[4] = "e";
		alphabet[5] = "f";
		alphabet[6] = "g";
		alphabet[7] = "h";
		alphabet[8] = "i";
		alphabet[9] = "j";
		alphabet[10] = "k";
		alphabet[11] = "l";
		alphabet[12] = "m";
		alphabet[13] = "n";
		alphabet[14] = "o";
		alphabet[15] = "p";
		alphabet[16] = "q";
		alphabet[17] = "r";
		alphabet[18] = "s";
		alphabet[19] = "t";
		alphabet[20] = "u";
		alphabet[21] = "v";
		alphabet[22] = "w";
		alphabet[23] = "x";
		alphabet[24] = "y";
		alphabet[25] = "z";
		int nameLength = new Random().nextInt(20);
		String randomName = "";
		for(int i = 0; i < nameLength; i++)
		{
			randomName = randomName + alphabet[new Random().nextInt(25)];
		}
		Smurf random = new Smurf(randomName);
		System.out.println(random.getName());
		random.eat();

	}

}
