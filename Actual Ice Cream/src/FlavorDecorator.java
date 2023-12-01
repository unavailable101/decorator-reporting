// Concrete Decorator
// override the methods of the base decorator, but still make use of it either before or after their own execution

public class FlavorDecorator extends IceCreamBaseDecorator{
    private String additionalFlavor;

    public FlavorDecorator(IIceCream iceCream, String additionalFlavor) {
        super(iceCream);
        this.additionalFlavor = additionalFlavor;
    }

    @Override
    public void serve() {
        super.serve();
        System.out.print(" and " + additionalFlavor + " Ice Cream");
    }

}
