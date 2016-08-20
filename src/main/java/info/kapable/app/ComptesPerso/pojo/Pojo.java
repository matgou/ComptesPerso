package info.kapable.app.ComptesPerso.pojo;

public abstract class Pojo implements Cloneable {

	public abstract Long getId();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
