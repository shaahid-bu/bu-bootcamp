import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {
	public static void main(String[] args) {
		HashMap<String, Contact> contacts = new HashMap<>();

		contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
		contacts.put("Shaahid Shaik", new Contact("Shaahid Shaik", "+1 617 555 0102"));
		contacts.put("Shanaya Shaik", new Contact("Shanaya Shaik", "+1 617 555 0103"));
		contacts.put("Maahir Shaik", new Contact("Maahir Shaik", "+1 617 555 0104"));
		contacts.put("Akhik Shaik", new Contact("Akhik Shaik", "+1 617 555 0105"));

		String lookupName = "Ada Lovelace";
		Contact found = contacts.get(lookupName);
		if (found == null) {
			System.out.println("Contact not found.");
		} else {
			System.out.println("Lookup result for " + lookupName + ":");
			System.out.println(found);
		}

		String missingName = "Tasneem Tesla";
		Contact missing = contacts.get(missingName);
		if (missing == null) {
			System.out.println("Contact not found.");
		} else {
			System.out.println(missing);
		}

		ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
		sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

		System.out.println("=== All Contacts ===");
		for (Contact contact : sorted) {
			System.out.println(contact);
		}
	}
}
