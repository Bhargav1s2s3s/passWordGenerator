import java.util.Random;

public class PasswordGenerater {
    private static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String symbols = "-_=+)(*&^%$#@!~`?/.,|}{][";
    private Random random;

    public PasswordGenerater() {
        random = new Random();
    }

    // insert buttom operation
    public String generaterPassword(int length ,boolean upper ,boolean lower ,boolean number ,boolean symb) {

        StringBuilder pass = new StringBuilder();

        String addMaterials = "";

        if(upper) addMaterials += upperCase;
        if(lower) addMaterials += lowerCase;
        if(number) addMaterials += numbers;
        if(symb) addMaterials += symbols;

        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(addMaterials.length());
            char ele = addMaterials.charAt(rand);
            pass.append(ele);
        }

        return pass.toString();

    }

}
