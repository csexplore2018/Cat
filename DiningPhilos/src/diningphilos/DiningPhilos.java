package diningphilos;


public class DiningPhilos {

    // boolean array of fork statuses (lifted or not) 
    static boolean forkLifted [] = {false, false, false, false};
    
    // length of forkLifted array
    static int numberOfForks = 4;
    
    //currrent time slice ctr
    static int t = 0;

    public static void main(String[] args) {
        
        Philosopher aristotle = new Philosopher();
        aristotle.name = "Aristotle";
        
        Philosopher socrates = new Philosopher();
        socrates.name = "Socrates";
        
        Philosopher descartes = new Philosopher();
        descartes.name = "Descartes";
        
        Philosopher plato = new Philosopher();
        plato.name = "Plato";
        
        // if each philosophers lifts left fork first,
        // then neither can ever eat, 
        // because both forks must be lifted to eat.
        aristotle.liftLeftFork();
        aristotle.liftRightFork();
        socrates.liftLeftFork();
        socrates.liftRightFork();
        
        resetForks();
        
        // if each philosophers lifts even fork first,
        // then one philosopher can eat
        aristotle.liftEvenFork();
        descartes.liftEvenFork();
        socrates.liftEvenFork();
        plato.liftEvenFork();
        aristotle.liftOddFork();
        descartes.liftOddFork();
        socrates.liftOddFork();
        plato.liftOddFork();
        
        t++;
        aristotle.eat();
        descartes.eat();
        socrates.eat();
        plato.eat();
        
        t++;
        aristotle.eat();
        descartes.eat();
        socrates.eat();
        plato.eat();
        
        t++;
        socrates.liftEvenFork();
        plato.liftEvenFork();
        aristotle.liftEvenFork();
        descartes.liftEvenFork();
        socrates.liftOddFork();
        plato.liftOddFork();
        aristotle.liftOddFork();
        descartes.liftOddFork();
        
        t++;
        aristotle.eat();
        descartes.eat();
        socrates.eat();
        plato.eat();
        
        t++;
        aristotle.eat();
        descartes.eat();
        socrates.eat();
        plato.eat();
        
    }
    public static void resetForks() {
        forkLifted[0] = false;
        forkLifted[1] = false;
        forkLifted[2] = false;
        forkLifted[3] = false;
        System.out.println();
        System.out.println("Reset Forks");
        System.out.println();
    }
}

class Philosopher {
    String name = "Plato"; // name is always Plato, unless changed
    int philosopherNumber = 0; 
    static int numberOfPhilosophers = 0; 
    int leftFork = 0;
    int rightFork = 0;
    boolean rightForkUp = false;
    boolean leftForkUp = false;
    boolean philosopherIsEven = false;
    int lastAte = -100;
    
    Philosopher() { // constructor
        
        // philosophers are numbered from 0 to n-1
        philosopherNumber = numberOfPhilosophers;
        // numberOfPhilosophers is n
        numberOfPhilosophers++; 
        
        leftFork = philosopherNumber; // leftFork always == phil. num.
        rightFork = philosopherNumber + 1;
        // right fork is zero for highest numbered philosopher
        if (philosopherNumber == DiningPhilos.numberOfForks - 1) 
            rightFork = 0;
    }
    void eat() {
        if (leftForkUp && rightForkUp && DiningPhilos.t - lastAte > 10){
            System.out.println(name + ": Yum!");
            lastAte = DiningPhilos.t;
            //drop forks
            DiningPhilos.forkLifted[leftFork] = false;
            DiningPhilos.forkLifted[rightFork] = false;
        }
        else think();
    }
    void think() {
        System.out.println(name + ": Hm.");
    }
    void liftLeftFork() {
        if (DiningPhilos.t - lastAte > 10) {
            if(DiningPhilos.forkLifted[leftFork]) {
                System.out.println(name + ": Can't lift left fork: " 
                        + leftFork);
            }
            else {
                DiningPhilos.forkLifted[leftFork] = true;
                leftForkUp = true;
                System.out.println(name + ": Successfully lifted left fork: " 
                        + leftFork);
            }
        }
    }
    void liftRightFork() {
        if (DiningPhilos.t - lastAte > 10) {
            if(DiningPhilos.forkLifted[rightFork]) {
                System.out.println(name + ": Can't lift right fork: " 
                        + rightFork);
            }
            else {
                DiningPhilos.forkLifted[rightFork] = true;
                rightForkUp = true;
                System.out.println(name + ": Successfully lifted right fork: " 
                        + rightFork);
            }
        }
    } 
    void liftEvenFork() {
        if(leftFork % 2 == 0) liftLeftFork();
        else liftRightFork();
    }
    void liftOddFork() {
        if(leftFork % 2 != 0) liftLeftFork();
        else liftRightFork();
    }
    void putDown() {
        for (int time = 0; time < 100; time++){
            if (time % 5 == 0) {
                
            }
        }
    }
}
