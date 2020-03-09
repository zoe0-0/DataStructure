package Algorithm;

import java.util.LinkedList;

//LinkedList로 queue 구현하기


public class AnimalShelterLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Dog d1 = new Dog("puppy");
		Dog d2 = new Dog("chichi");
		Dog d3 = new Dog("choco");
		Cat c1 = new Cat("cow");
		Cat c2 = new Cat("miu");
		Cat c3 = new Cat("lookie");
		
		AnimalShelter as = new AnimalShelter();

		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(d3);
		as.enqueue(c3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());

	}


}

enum AnimalType{
	DOG,CAT
}

abstract class Animal{
	AnimalType type;
	String name;
	int order;
	Animal(AnimalType type, String name){
		this.type = type;
		this.name = name;
	}
	
	void setOrder(int order) {
		this.order = order;
	}
	
	int getOrder() {
		return order;
	}
	
	String info() {
		return order+") type: "+type+", name: "+name;
	}
}


class Dog extends Animal{
	Dog(String name) {
		super(AnimalType.DOG, name);
	}
}

class Cat extends Animal{
	Cat(String name){
		super(AnimalType.CAT,name);
	}
}

class AnimalShelter{
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	int order;
	AnimalShelter(){
		order = 1;
	}
	void enqueue(Animal animal) {
		animal.setOrder(order);
		++order;
		if(animal.type==AnimalType.DOG) 
			dogs.addLast((Dog) animal);
		else if(animal.type==AnimalType.CAT) 
			cats.addLast((Cat) animal);
	}
	
	Animal dequeueDog() {
		return dogs.poll();
	}
	
	Animal dequeueCat() {
		return cats.poll();
	}
	Animal dequeue() {
		if(dogs.size()==0 && cats.size()==0) {
			return null;
		}else if(dogs.size()==0) {
			return cats.poll();
		}else if(cats.size()==0) {
			return dogs.poll();
		}
		
		Animal dog = dogs.peek();
		Animal cat = cats.peek();
		
		
		//poll() - Retrieves and removes the head (first element) of this list.

		if(dog.getOrder()<cat.getOrder()) {
			return dogs.poll();
		}else {
			return cats.poll();
		}
		
		
	}
}
