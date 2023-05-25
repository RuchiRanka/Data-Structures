public class OOPS {
    
    public static void main(String args[]) {

        // Pen p1 = new Pen(); //created a pen object called p1
        // p1.setColor("Blue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // p1.setColor("Yellow");
        // System.out.println(p1.getColor());

        // BankAccount myAcc = new BankAccount();
        // myAcc.username = "ruchiru";
        // myAcc.setPassword("ru");

        // Student s1 = new Student();

        // Student s2 = new Student("Ruchi");
        // Student s3 = new Student(2203286);
        // System.out.println(s1.name);

        // s1.name = "Ruchi";
        // s1.rollno = 286;
        // s1.password = "abc";
        // s1.marks[0] = 90;
        // s1.marks[1] = 80;
        // s1.marks[2] = 100;

        // Student s2 = new Student(s1);
        // s2.password = "xyz";
        
        // s1.marks[0] = 100;
        
        // for(int i=0; i<s1.marks.length; i++){
        //     System.out.println(s2.marks[i]);
        // }
        
        // Fish shark = new Fish();    //Single level inheritance
        // shark.eat();

        // Dog coco = new Dog();       //Multi level inheritance
        // coco.breathe();
        // coco.legs = 4;
        // System.out.println(coco.legs);

        // Calculator calc = new Calculator();   //Complie time polymorphism
        // System.out.println(calc.sum(1,2));
        // System.out.println(calc.sum((float)1.5, (float)2.5));
        // System.out.println(calc.sum(1,2,3));

        // Animal ani = new Animal();   //Run time polymorphism
        // ani.eat();
        // Deer dr = new Deer();
        // dr.eat();

        // Horse h = new Horse(); //Abstraction
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();
        
        // Mustang myHorse = new Mustang();
        // //Animal -> Horse -> Mustang

        // Queen q = new Queen();
        // q.moves();

        // Bear b = new Bear();
        // b.eat();
        // b.walk();
        // System.out.println(b.color);

        Student1 s1 = new Student1();      //static keyword
        // s1.schoolName = "KPS";
        // Student1 s2 = new Student1();
        // System.out.println(s2.schoolName);
        // Student1 s3 = new Student1();
        // s3.schoolName = "New Era";
        // System.out.println(s1.schoolName);
        // System.out.println(s2.schoolName);

        // s1.sum((float)21.5, (float)0.5);
        // Student1.sum(21,1);
        // System.out.println(Student1.roll);

        Horse1 h = new Horse1();
        System.out.println(h.color);
    }
}

class Animal3 {
    String color = "dark";

    Animal3() {
        System.out.println("Animal constructor is called");
    }
}

class Horse1 extends Animal3 {
    Horse1() {
        super.color = "brown";
        System.out.println("Horse constructor is called");
    }
}

class Student1 {
    String name;
    static int roll=21;
    static String schoolName;

    static void sum(int a, int b) {
        System.out.println(a+b);
    }

    void sum(float a, float b) {
        System.out.println(a+b);
    }
    
    void setName(String name) {
        this.name = name;
    }

    void getName() {
        System.out.println(this.name);
    }
}

//Multiple Inheritance
interface Herbivore {
    void eat();
    // String color = "brown";
}

interface Carnivore {
    void eat();
    void walk();
    // String color = "gray";
}

class Bear implements Herbivore, Carnivore {
    public void eat() {
        System.out.println("eats grass and meat");
    }
    public void walk() {
        System.out.println("Meaty walks");
    }
}

//Interface
interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal(all 4 directions)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal - by 1 step");
    }
}

//Abstract Class
abstract class Animal2 {
    //abstract class can have a constructor
    Animal2() {
        System.out.println("Animal constructor called");
    }

    // String color = "brown";

    void eat() {
        System.out.println("Animal eats");
    }
    
    // abstract void walk();
}

class Horse extends Animal2 {
    Horse() {
        System.out.println("Horse constructor called");
    }

    // String color = "darkbrown";

    // void changeColor() {
    //     color = "darkbrown";
    // }

    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }
}

class Chicken extends Animal2 {
    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
}

class Calculator {

    int sum (int a, int b) {
        return a + b;
    }

    float sum (float a, float b) {
        return a + b;
    }

    int sum (int a, int b, int c) {
        return a + b + c;
    }

}

//Base class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Deer extends Animal {

    void eat() {
        System.out.println("eats grass");
    }
}

class Mammal extends Animal {
    int legs;

    void walk() {
        System.out.println("walks");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("flies");
    }
}

// class Dog extends Mammal {
//     String breed;
// }

// //Derived class / subclass
// class Fish extends Animal {
//     int fins;

//     void swim() {
//         System.out.println("swims");
//     }
// }

// class Student {

//     String name;
//     int rollno;
//     String password;
//     int marks[] = new int[3];

//     // //Shallow copy constructor
//     // Student(Student s1) {
//     //     this.name = s1.name;
//     //     this.rollno = s1.rollno;
//     //     this.marks = s1.marks;
//     // }

//     //Deep copy constructor
//     Student(Student s1) {
//         this.name = s1.name;
//         this.rollno = s1.rollno;
//         for(int i=0; i<s1.marks.length; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }

//     //Constructor
//     Student() {
//         System.out.println("Constructor is called");
//     }

//     Student(String name) {
//         this.name = name;
//     }

//     Student(int rollno) {
//         this.rollno = rollno;
//     }

// }

// class BankAccount {

//     public String username;
//     private String password;

//     void setPassword(String pwd) {
//         password = pwd;
//     }
// }

// class Pen {

//     //properties
//     private String color; 
//     private int tip;

//     //functions - getters
//     String getColor() {
//         return this.color;
//     }

//     int getTip() {
//         return this.tip;
//     }

//     //functions - setters
//     void setColor(String newColor) {
//         color = newColor;
//     }

//     void setTip(int newTip) {
//         tip = newTip;
//     }

//     // //this keyword usage
//     // void setTip(int tip){
//     //     this.tip = tip;
//     // }

// }
