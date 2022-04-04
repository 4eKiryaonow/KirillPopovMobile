package scenarios;

import static com.epam.tc.hw2.utils.TestDataProvider.QUERY;
import static com.epam.tc.hw2.utils.TestDataProvider.URL;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.pageObjects.webApp.SearchResultPageObject;
import com.epam.tc.hw2.pageObjects.webApp.WebPageObject;
import com.epam.tc.hw2.setup.BaseTest;
import org.testng.annotations.Test;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that search request has relevant values in result")
    public void simpleWebTest() {

        WebPageObject webPageObject = (WebPageObject) getPageObject().getObjectInstance();
        SearchResultPageObject searchResultPageObject =
            webPageObject
                .openUrl(URL)
                .searchRequest(QUERY);

        searchResultPageObject
            .getSearchResultsTitles()
            .forEach(title -> assertThat(title).as("").containsIgnoringCase(QUERY));
    }
}
