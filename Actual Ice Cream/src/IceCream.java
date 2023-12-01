// Concrete Component
// It is the wrapped class
// It defines the basic behavior, which can be altered by decorators

public class IceCream implements IIceCream{
    private String flavor;

    public IceCream(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void serve() {
        System.out.print("Here's your " + flavor + " Ice Cream");
    }
}
