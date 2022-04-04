package scenarios;

import static com.epam.tc.hw2.utils.TestDataProvider.EMAIL;
import static com.epam.tc.hw2.utils.TestDataProvider.PASSWORD;
import static com.epam.tc.hw2.utils.TestDataProvider.TITLE_BUDGET_ACTIVITY_PAGE;
import static com.epam.tc.hw2.utils.TestDataProvider.USERNAME;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.pageObjects.nativeApp.BudgetActivityPageObject;
import com.epam.tc.hw2.pageObjects.nativeApp.LoginPageObject;
import com.epam.tc.hw2.setup.BaseTest;
import org.testng.annotations.Test;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This test provide user registration,"
        + "logging and check that the BudgetActivity page is opened")
    public void simpleNativeTest() {

        LoginPageObject loginPageObject = (LoginPageObject) getPageObject().getObjectInstance();

        BudgetActivityPageObject budgetActivityPageObject = loginPageObject
            .openRegistrationPage()
            .registerNewAccount(EMAIL, USERNAME, PASSWORD)
            .login(EMAIL, PASSWORD);

        assertThat(budgetActivityPageObject.getTitle()).isEqualTo(TITLE_BUDGET_ACTIVITY_PAGE);
    }
}
