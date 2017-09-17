import Animals.Animals;
import Animals.Cats.Cats;
public class Main
{
    public  static void main(String[] args)
    {
        Animals genericAnimal = new Animals();

        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.favFood);

        Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");

        System.out.println();

        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.favToy);

        Animals tabby = new Cats("Tabby", "Salmon", "Ball");

        acceptAnimal(tabby);
    }
    public  static void acceptAnimal(Animals randAnimal)
    {
        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        // This is Polymorphism
        // The interpreter automatically figures out what type
        // of Animal it's dealing with and checks to make sure
        // if methods were overwritten that they are called
        // instead
        randAnimal.walkAround();

        // If you want access to fields or methods only found
        // in the Cat class you have to cast the object to
        // that specific class first
        Cats tempCat = (Cats) randAnimal; // ?????????????????????????????
        System.out.println(tempCat.favToy);
        // You could also cast the object directly like this
        System.out.println(((Cats)randAnimal).favToy);//????????????????????????

        /*if(randAnimal instanceof Cats)
        {
            System.out.println(randAnimal.getName() + " is a Cat");
        }*/
        if(randAnimal instanceof Animals)
        {
            System.out.println(randAnimal.getName() + " is a Cat");
        }
    }
}
