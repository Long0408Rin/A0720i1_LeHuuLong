package B7_Abstract_and_Interface.Animal_and_interfaceEdible;

import B7_Abstract_and_Interface.Animal_and_interfaceEdible.Animal.Animal;
import B7_Abstract_and_Interface.Animal_and_interfaceEdible.Animal.Chicken;
import B7_Abstract_and_Interface.Animal_and_interfaceEdible.Animal.Tiger;
import B7_Abstract_and_Interface.Animal_and_interfaceEdible.edible.Edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howtoEat());
            }
        }
    }
}