/**
 * Created by maqsoodi on 5/24/2017.
 */
@Immutable
public class ImmutableClass {

    private final String name;

    public ImmutableClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
