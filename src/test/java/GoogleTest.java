import base.BaseWebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GooglePage;

public class GoogleTest extends BaseWebTest {

    private GooglePage googlePage = new GooglePage();

    @BeforeClass
    public void createPreconditions() {
        googlePage
                .navigateToGooglePage()
                .waitForPageToLoad();
    }

    @Test(description = "Dummy Web app test")
    public void test_001() {
        googlePage
                .inputTextToSearchField("linkedIn")
                .clickSearchButton();
    }
}
