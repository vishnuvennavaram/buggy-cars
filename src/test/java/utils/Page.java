package utils;

/**
 * This class is used to instantiate all utils classes
 */
public class Page{
    protected BrowserUtils browserUtils;
    protected PageUtils pageUtils;
    protected DriverUtils driverUtils;

    public Page() {
        this.pageUtils = new PageUtils();
        this.browserUtils = new BrowserUtils();
        this.driverUtils = DriverUtils.getInstance();
    }
}
