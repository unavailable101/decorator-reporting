// Base Decorator
// references the wrapped object via the interface so it can reference both the concrete component and its decorators
// Base Decorator is an abstract class that implements the Component interface.
public abstract class IceCreamBaseDecorator implements IIceCream{
    protected IIceCream iceCream;

    public IceCreamBaseDecorator(IIceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public void serve() {
        iceCream.serve();
    }
}
