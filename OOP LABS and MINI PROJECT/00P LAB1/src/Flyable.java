// Flyable.java
    public interface Flyable {
        void fly();
    }

    // Bird.java
    class Bird implements Flyable {
        private final String name;

        public Bird(String name) {
            this.name = name;
        }

        @Override
        public void fly() {
            System.out.println(name + " the bird flaps its wings and takes off.");
        }
    }

    // Aeroplane.java
     class Aeroplane implements Flyable {
        private final String model;

        public Aeroplane(String model) {
            this.model = model;
        }

        @Override
        public void fly() {
            System.out.println("The " + model + " aeroplane spins its engines and takes off.");
        }
    }

    // Main.java
    class FlyDemo {
        public static void main(String[] args) {
            Flyable[] flyers = {
                    new Bird("Eagle"),
                    new Aeroplane("Boeing 737")
            };

            for (Flyable f : flyers) {
                f.fly();
            }
        }
    }

