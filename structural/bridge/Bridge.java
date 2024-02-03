package structural.bridge;

public class Bridge {
    public static void main(String[] args) {
        Device tv = new Tv();
        RemoteControl remote = new RemoteControl(tv);
        remote.togglePower();
        System.out.println("The tv enabled is " + tv.isEnabled());

        Device radio = new Radio();
        AdvancedRemoteControl advRemote = new AdvancedRemoteControl(radio);
        advRemote.volumeUp();
        System.out.println("The current volume of radio is " + radio.getVolume());
        advRemote.mute();
        System.out.println("The current volume of radio is " + radio.getVolume());
    }
}

class RemoteControl {

    protected Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}

class AdvancedRemoteControl extends RemoteControl {
    AdvancedRemoteControl(Device device) {
        super(device);
        // TODO Auto-generated constructor stub
    }

    void mute() {
        device.setVolume(0);
    }
}

interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);
}

class Tv implements Device {

    boolean enabled;
    int volume;
    int channel;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}

class Radio implements Device {

    boolean enabled;
    int volume;
    int channel;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }
}