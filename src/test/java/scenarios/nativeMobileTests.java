package scenarios;

import static com.epam.tc.hw2.utilities.TestDataProvider.EMAIL;
import static com.epam.tc.hw2.utilities.TestDataProvider.PASSWORD;
import static com.epam.tc.hw2.utilities.TestDataProvider.TITLE_BUDGET_ACTIVITY_PAGE;
import static com.epam.tc.hw2.utilities.TestDataProvider.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.pageObjects.nativeApp.BudgetActivityPageObject;
import com.epam.tc.hw2.pageObjects.nativeApp.LoginPageObject;
import com.epam.tc.hw2.setup.BaseTest;
import org.testng.annotations.Test;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() {

        LoginPageObject loginPageObject = (LoginPageObject) getPageObject().getObjectInstance();

        BudgetActivityPageObject budgetActivityPageObject = loginPageObject
            .openRegistrationPage()
            .registerNewAccount(EMAIL, USERNAME, PASSWORD)
            .login(EMAIL, PASSWORD);

        assertThat(budgetActivityPageObject.getTitle()).isEqualTo(TITLE_BUDGET_ACTIVITY_PAGE);
    }
}
