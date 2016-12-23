public class MyImprovedArrayListTester {

	public static void main(String [] args) {
		MyArrayList<String> list = new MyArrayList<String>(3);

		list.add("A");
		list.add(null);
		list.add("C");

		System.out.println("1) Should be: 3 { A null C }");
		System.out.println("1) Result:    " + list.size() + " " + list);

		list.add("D");
		list.add("E");
		list.add("F");

		System.out.println("2) Should be: 6 { A null C D E F }");
		System.out.println("2) Result:    " + list.size() + " " + list);

		System.out.println("3) Item at 4 should be E: " + list.get(4));

		list.add(1, "J");
		list.add(1, "H");
		list.remove(1);

		System.out.println("4) Should be: 7 { A J null C D E F }");
		System.out.println("4) Result:    " + list.size() + " " + list);

		list.add("D");
		list.add("D");
		list.remove("D");

		System.out.println("5) Should be: 8 { A J null C E F D D }");
		System.out.println("5) Result:    " + list.size() + " " + list);

		MyArrayList<Integer> intList = new MyArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);

		System.out.println("6) Should be: 3 { 1 2 3 }");
		System.out.println("6) Result:    " + intList.size() + " " + intList);

		intList.remove(new Integer(1));
		intList.remove(new Integer(2));
		intList.remove(new Integer(4));

		System.out.println("7) Should be: 1 { 3 }");
		System.out.println("7) Result:    " + intList.size() + " " + intList);

		intList.remove(new Integer(3));

		System.out.println("8) Should be: 0 { }");
		System.out.println("8) Result:    " + intList.size() + " " + intList);

		MyArrayList<Integer> bigList = new MyArrayList<Integer>(10);
		for (int i = 0; i < 100; i++) {
			bigList.add(i);
		}
		for (int i = 0; i < 95; i++) {
			bigList.remove(0);
		}

		System.out.println("9) Should be: 5 { 95 96 97 98 99 }");
		System.out.println("9) Result:    " + bigList.size() + " " + bigList);


		try {
			Object o = bigList.get(7);
			System.out.println("If you see this, you're not throwing exceptions properly.\n");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown successfully!");
		}
		System.out.println("Efficiency testing time!");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++)
		{
			bigList.add(i);
		}
		long totalTime = (System.currentTimeMillis() - startTime)/1000;
		System.out.println("Done!  You took " + totalTime + " seconds!");
	

	}
	}
