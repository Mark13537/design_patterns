package creational.factory_method;

class FactoryMethod {
    public static void main(String[] args) {
        Dialog clientDialog = Application.initDialog();
        clientDialog.render();
    }
}

abstract class Dialog {
    abstract Button createButton();

    void render() {
        // Call the factory method to create a product object.
        Button okButton = createButton();
        // Now use the product.
        // okButton.onClick();
        // okButton.render();
        okButton.onClick();
        okButton.render();
    }
}

interface Button {
    void render();

    void onClick();
}

class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {
    @Override
    Button createButton() {
        return new HTMLButton();
    }
}

class WindowsButton implements Button {
    @Override
    public void render() {
        // Render a button in Windows style.
        System.out.println("Windows BTN Render");
    }

    @Override
    public void onClick() {
        // Bind a native OS click event.
        System.out.println("Windows BTN onClick");
    }
}

class HTMLButton implements Button {
    @Override
    public void render() {
        // Return an HTML representation of a button.
        System.out.println("HTML BTN Render");
    }

    @Override
    public void onClick() {
        // Bind a web browser click event.
        System.out.println("HTML BTN onClick");
    }
}

class Application {
    static Dialog dialog;

    static Dialog initDialog() {
        var config = "Windows";
        if (config == "Windows") {
            dialog = new WindowsDialog();
        }
        // else if (config == "Web") {
        else {
            dialog = new WebDialog();
        }
        return dialog;
    }
}
