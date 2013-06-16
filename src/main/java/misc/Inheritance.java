package misc;

class Mammal {
    int temp;
    String name = "George";

    public Mammal() {
        temp = 98;
    }

    public String getName() {
        return name;
    }
}
class Cat extends Mammal {
    int lives;
    String name = "Morris";

    public Cat() {
        lives = 9;
    }
//    public String getName() {
//        return name;
//    }
}
public class Inheritance {
    public static void main(String[] args) {
        Mammal mm = new Cat();
        System.out.println("Mam Temp :" + mm.temp);
        //System.out.println("Cat Lives:" + mm.lives);
        System.out.println("Mam Name :" + mm.getName());
    }
}
// There are two related but concretely separate concepts here.
//   The runtime type of an object.
//   The static (and runtime) type of a variable.
//
// The runtime type of the object will determine how it behaves at runtime.
// It's determined by the constructor you called when you used the new keyword.
// The static type of the variable dictates how your code can interact with or
// reference that variable (and the object it refers to).
// In this case, the static type of the variable is Mammal while the runtime type
// of the object it points to is Cat. Thus, while it behaves like a Cat at runtime and
// shows its name as being 'Morris', at compile time the compiler only knows
// that it is a Mammal, and cannot refer to the lives variable (which is defined in Cat, not Mammal).
