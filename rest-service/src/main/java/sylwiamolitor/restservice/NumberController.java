package sylwiamolitor.restservice;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * Class, which is controlling mapping
 */
@RestController
public class NumberController {

    /**
     * Number
     */
    private static final String number = "%s";


    /**
     * Start page.
     * @return HTML page
     */
    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n"
                +"<br>"
                + "Choose exercise:"
                +"<br>"
                + "Exercise 1 - return the number in binary system as a string."
                +"<br>"
                +"<form action=\"http://localhost:8080/ex1/55\">"
                +"<input type=\"submit\" value=\"Go to Ex1\" />"
                +"</form>"
                +"<br>"
                + "Exercise 2 - switch digits (1 to 0,  0 to 1, e.g. 1000 to 0111) and return the number in octal system as a string."
                +"<br>"
                +"<form action=\"http://localhost:8080/ex2/55\">"
                +"<input type=\"submit\" value=\"Go to Ex2\" />"
                +"</form>"
                +"<br>"
                + "Exercise 3 - reverse the digits (e.g. 0100 to 0010) and return the number in hexadecimal system as a string."
                +"<br>"
                +"<form action=\"http://localhost:8080/ex3/55\">"
                +"<input type=\"submit\" value=\"Go to Ex3\" />"
                +"</form>"
                +"<br>"
                + "Exercise 4 - move all 1s to the left, and all 0s to the right (e.g. 1010 to 1100) and return the number in decimal system as a string."
                +"<br>"
                +"<form action=\"http://localhost:8080/ex4/55\">"
                +"<input type=\"submit\" value=\"Go to Ex4\" />"
                +"</form>"
                +"<br>"
                +"Default value is 55, to change it, change the last number in url from 55 to another."
                +"<br>"
                +"For example http://localhost:8080/ex4/55 to http://localhost:8080/ex4/2"
                +"<br>"
                + "</body>\n" + "</html>";
    }

    /**
     * Exercise 1
     * @param number number to calculate
     * @return result
     */
    @ApiOperation(value= "Exercise1", notes = "return the number in binary system as a string")
    @GetMapping("/ex1/{number}")
    public Number exercise1(@ApiParam(value ="input number")@PathVariable String number) {
        if(number.matches("-?\\d+(\\.\\d+)?"))
        {
            if(Integer.parseInt(number) <0)
            return new Number(String.format(NumberController.number, "0"));

            String number2 = Integer.toBinaryString(Integer.parseInt(number));

            return new Number(String.format(NumberController.number, number2));
        }
        else
            return new Number(String.format(NumberController.number, "0"));
    }

    /**
     * Exercise 2
     * @param number number to calculate
     * @return result
     */
    @ApiOperation(value= "Exercise2", notes = "switch digits (1 to 0,  0 to 1, e.g. 1000 to 0111) and return the number in octal system as a string")
    @GetMapping("/ex2/{number}")
    public Number exercise2(@ApiParam(value ="input number")@PathVariable String number) {

        if(number.matches("-?\\d+(\\.\\d+)?"))
        {
            String number2 = Integer.toBinaryString(Integer.parseInt(number));
            number2= number2.replace('1','2');
            number2 =  number2.replace('0','1');
            number2 = number2.replace('2','0');
            number2 = Integer.toOctalString(Integer.parseInt(number2,2));
            return new Number(String.format(NumberController.number, number2));
        }
        else
            return new Number(String.format(NumberController.number, "0"));
    }
    /**
     * Exercise 3
     * @param number number to calculate
     * @return result
     */
    @ApiOperation(value= "Exercise3", notes = "reverse the digits (e.g. 0100 to 0010) and return the number in hexadecimal system as a string.")
    @GetMapping("/ex3/{number}")
    public Number exercise3(@ApiParam(value ="input number")@PathVariable String number)  {
        if(number.matches("-?\\d+(\\.\\d+)?"))
        {
            if(Integer.parseInt(number) <0)
                return new Number(String.format(NumberController.number, "0"));
            String number2 = Integer.toBinaryString(Integer.parseInt(number));

            byte[] strAsByteArray = number2.getBytes();

            byte[] result = new byte[strAsByteArray.length];

            for (int i = 0; i < strAsByteArray.length; i++)
                result[i] = strAsByteArray[strAsByteArray.length - i - 1];

            String number3 = new String(result);
            int decimal = Integer.parseInt(number3,2);
            String number4 = Integer.toString(decimal,16);


            return new Number(String.format(NumberController.number, number4));
        }
        else
            return new Number(String.format(NumberController.number, "0"));
    }

    /**
     * Exercise 4
     * @param number number to calculate
     * @return result
     */
    @ApiOperation(value= "Exercise4", notes = "move all 1s to the left, and all 0s to the right (e.g. 1010 to 1100) and return the number in decimal system as a string.")
    @GetMapping("/ex4/{number}")
    public Number exercise4(@ApiParam(value ="input number")@PathVariable String number) {
        if(number.matches("-?\\d+(\\.\\d+)?"))
        {
            if(Integer.parseInt(number) <0)
                return new Number(String.format(NumberController.number, "0"));

            String number2 = Integer.toBinaryString(Integer.parseInt(number));

            char[] tempArray = number2.toCharArray();

            Arrays.sort(tempArray);
            int i, n = tempArray.length;
            char t;
            for (i = 0; i < n / 2; i++)
            {
                t = tempArray[i];
                tempArray[i] = tempArray[n - i - 1];
                tempArray[n - i - 1] = t;
            }

            int decimal = Integer.parseInt(new String(tempArray),2);
            String number3 = Integer.toString(decimal);
            return new Number(String.format(NumberController.number, number3));
        }
        else
            return new Number(String.format(NumberController.number, "0"));
    }
}