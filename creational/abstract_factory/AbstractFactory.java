package creational.abstract_factory;

public class AbstractFactory {
    public static void main(String[] args) {
        Application application = new Application(new WindowsFactory());
        application.createUI();
        application.renderComponents();
    }
}

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Windows BTN Render");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Windows Checkbox Render");
    }
}

class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Mac BTN Render");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Mac Checkbox Render");
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;
    private GUIFactory factory;

    Application(GUIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderComponents() {
        button.render();
        checkbox.render();
    }
}