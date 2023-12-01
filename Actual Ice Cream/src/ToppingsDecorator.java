// Concrete Decorator
// override the methods of the base decorator, but still make use of it either before or after their own execution

import java.util.List;

class ToppingsDecorator extends IceCreamBaseDecorator {
    private List<String> toppings;

    public ToppingsDecorator(IIceCream iceCream, List<String> toppings) {
        super(iceCream);
        this.toppings = toppings;
    }

    @Override
    public void serve() {
        super.serve();
        if (!toppings.isEmpty()) {
            System.out.print(" with ");
            for (int i = 0; i < toppings.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(toppings.get(i));
            }
        }
        System.out.println(".");
    }
}
