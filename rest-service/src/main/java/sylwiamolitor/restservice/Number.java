package sylwiamolitor.restservice;


/**
 * Class, which contains result
 */
public class Number {

    /**
     * Result of calculations
     */
    private final String result;

    /**
     * Constructor
     * @param result result of calculations
     */
    public Number(String result) {
        this.result = result;
    }

    /**
     * Getter of calculation result
     * @return calculation result
     */
    public String getResult() {
        return result;
    }



}