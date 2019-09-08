package secretsanta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SecretSanta {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> familyMembers = new ArrayList<>();
        HashMap<String, String> secretSantaMap = new HashMap<>();

        System.out.print("Enter number of family members: ");
        int numFamilyMembers = scanner.nextInt();
        //vvv In case a user tries to be funny vvv
        while (numFamilyMembers < 2) {
            System.out.println("Invalid Entry. Must be 2 or higher");
            System.out.print("Enter number of family members: ");
            numFamilyMembers = scanner.nextInt();
        }

        for (int i = 0; i < numFamilyMembers; i++) {
            System.out.print("Enter family member's name: ");
            familyMembers.add(scanner.next());
        }

        for (int i = 0; i < numFamilyMembers; i++) {
            String familyMember = familyMembers.get(random.nextInt(numFamilyMembers - i));
            familyMembers.remove(familyMember);
            String secretSanta = familyMembers.get(random.nextInt(familyMembers.size()));
            while (secretSantaMap.containsValue(secretSanta)) {
                secretSanta =familyMembers.get(random.nextInt(familyMembers.size()));
            }
            secretSantaMap.put(familyMember, secretSanta);
            familyMembers.add(familyMember);
        }

        for (String s : familyMembers) {
            System.out.println(s+"'s Secret Santa is "+secretSantaMap.get(s));
        }
    }

}
