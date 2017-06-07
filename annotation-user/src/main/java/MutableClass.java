/**
 * Created by maqsoodi on 5/24/2017.
 */
@Immutable
public class MutableClass {

    private final String name;

    public MutableClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
