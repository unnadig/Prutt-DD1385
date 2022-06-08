class CompositeDemo {
	public static void main(String[] args) {
		// Skapa behållare
		CompositeElement root = new CompositeElement("Resväska", 100);
		CompositeElement comp1 = new CompositeElement("Necessär", 5);
		CompositeElement comp2 = new CompositeElement("Plastpåse", 1);
		CompositeElement comp3 = new CompositeElement("Skolåda", 2);

		// Lägg till föremål i behållarna
		comp2.add(new LeafElement("Schampoflaska", 5));
		comp1.add(comp2);
		comp1.add(new LeafElement("Tandborste", 5));
		comp1.add(new LeafElement("Hudkräm", 10));
		root.add(comp1);
		
		comp3.add(new LeafElement("Skor", 10));
		root.add(comp3);
		root.add(new LeafElement("Vattenflaska", 5));
		root.add(new LeafElement("Laptop", 50));
		root.add(new LeafElement("Strumpor", 10));
		// Skriv ut föremål och vikt
		System.out.println(root);
		System.out.println("\nTotalvikt: "+root.getWeight());
		// Radera föremål ur en behållare
		comp2.remove(0);
		System.out.println(root);
		System.out.println("\nTotalvikt: "+root.getWeight());
		// Radera en behållare samt allt dess innehåll
		root.remove(1);
		System.out.println(root);
		System.out.println("\nTotalvikt: "+root.getWeight());
	}
}