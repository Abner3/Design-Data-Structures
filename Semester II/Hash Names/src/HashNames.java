import java.lang.Integer;


public class HashNames {

	public static void main(String[] args) {
		int hashTableSize = 75;
		//ListNode[] studentHashTable = new ListNode[hashTableSize];
		String[] students = {
				"David Ahn",
				"Daria Arzy",
				"Jordan Barkin",
				"Abner Benitez",
				"Jonathan Damico",
				"Sidney Gathrid",
				"Jonathan Goldberg",
				"Will Granger",
				"Eleanor Halloran",
				"Shauna Hannani",
				"Vincent Le",
				"Sam McCabe",
				"Ryan O'Donnell",
				"Pria Pant",
				"Nathan Schoenberg",
				"RJ Schreck",
				"Javier Solis",
				"Claire Tan",
				"Matthew Wang",
				"Kevin Wesel",
				"Zachary Goldstein",
				"Elizabeth Haker",
				"Lochryn Howe",
				"Gabe Kaplan",
				"Ethan Knight",
				"Caroline Koloff",
				"Calvin Koo",
				"Marcus Leher",
				"Jarett Malouf",
				"Marc Novicoff",
				"Charlie Noxon",
				"Izzy Reiff",
				"Adin Ring",
				"Jonah Ring",
				"Jason Santillan",
				"Hana Takei",
				"Warren Wang",
				"Chance Washburn",
				"Nick Witham",
				"Paige Yoo",
				"Miles Povich",
				"Mitch Burdorf",
				"Aileen Cano",
				"Jacob Cohn",
				"Marie Eric",
				"Dylan Faulcon",
				"Timothy Kihiczak",
				"Nicole Kim",
				"Xander Klein",
				"Keller Maloney",
				"Alec Mendelsohn",
				"Jonty Nobbs",
				"Paul Rodriguez",
				"Tiber Seireeni",
				"Nick Settelmayer",
				"Pavan Tauh"
		};
		
		int collisions = 0;
		int[] chainLengths = new int[hashTableSize];
		int maxChainLength = 0;
		int emptyBuckets = hashTableSize;
		
		for (String student : students)
		{
			int index = (myHash(student) & 0x7FFFFFFF) % hashTableSize;
			if (chainLengths[index] != 0)
				collisions++;
			else
				emptyBuckets--;

			chainLengths[index]++;
			if (chainLengths[index] > maxChainLength)
				maxChainLength = chainLengths[index];

		}

		float usedProportion = ((float) (hashTableSize - emptyBuckets)) / ((float) hashTableSize);
		System.out.println("Total collisions: " + collisions);
		System.out.println("Proportion of collisions: " +((float) collisions) / ((float) students.length));
		System.out.println("Max chain length: " + maxChainLength);
		System.out.println("Proportion of used buckets: " + usedProportion);

	}

	private static int myHash(String s)
	{
		return (s.charAt(0) - 'A') * 5;
	}

}
