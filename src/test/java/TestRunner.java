import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/features/DokonywanieZakupu.feature",
//src/test/java/features/DokonywanieZakupu.feature
        //src/test/java/features/DodawanieAdresu.feature
        plugin ={"pretty"},
        publish = true)
public class TestRunner {
}
