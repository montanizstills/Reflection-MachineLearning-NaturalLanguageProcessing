//package selenium;
//
//import com.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
//import org.junit.Test;
//
//public class testUI {
//
//    @Test
//    public void Test0(){
//        ebDriver webDriver = BrowserHandlerFactory.FIREFOX.getDriver();
//        SearchPage searchPage = new SearchPage(webDriver);
//        searchPage.navigateTo();
//        searchPage.selectLanguage("English");
//        searchPage.search("apple");
//        searchPage.clickSearch();
//        AppleJuiceWidget appleJuiceWidget = searchPage.clickAppleJuice();
//        appleJuiceWidget.leaveProductReview("This is a product review");
//        webDriver.close();
//    }
//}
