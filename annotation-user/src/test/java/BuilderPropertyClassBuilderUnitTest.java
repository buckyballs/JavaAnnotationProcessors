import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderPropertyClassBuilderUnitTest {

    @Test
    public void whenBuildPersonWithBuilder_thenObjectHasPropertyValues() {

        BuilderPropertyClass builderPropertyClass = new BuilderPropertyClassBuilder().setAge(25).setName("John").build();

        assertEquals(25, builderPropertyClass.getAge());
        assertEquals("John", builderPropertyClass.getName());

    }

}
