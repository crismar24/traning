public class Lion extends Animal {
    String eyes;

    public Lion(String name, String eyes) {
        super(name);
        this.eyes = eyes;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }
}
