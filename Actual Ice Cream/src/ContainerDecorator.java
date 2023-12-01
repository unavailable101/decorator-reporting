// Concrete Decorator
// override the methods of the base decorator, but still make use of it either before or after their own execution

class ContainerDecorator extends IceCreamBaseDecorator {
    private String containerType;

    public ContainerDecorator(IIceCream iceCream, String containerType) {
        super(iceCream);
        this.containerType = containerType;
    }

    @Override
    public void serve() {
        super.serve();
        System.out.println(" in a " + containerType);
    }
}