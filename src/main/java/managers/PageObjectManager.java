package managers;

import pages.GoogleSearchPage;
import pages.TruNarrativePage;

public class PageObjectManager {

    private GoogleSearchPage googleSearchPage;

    private TruNarrativePage truNarrativePage;

    public PageObjectManager() {
    }

    /**
     * To check if object exists and return an existing object if exists
     **/

    public GoogleSearchPage getGoogleSearchPage() {
        return (googleSearchPage == null) ? googleSearchPage = new GoogleSearchPage() : googleSearchPage;
    }

    public TruNarrativePage getTruNarrativePage() {
        return (truNarrativePage == null) ? truNarrativePage = new TruNarrativePage() : truNarrativePage;
    }

}
