package misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexMatchAll {
    private void adTextIsClean(String adText, String filter) {

        try {
            Pattern regex = Pattern.compile(filter, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher m = regex.matcher(adText);

            while (m.find()) {
                System.out.println(m.group());
            }
        } catch (PatternSyntaxException ex) {
            // Syntax error in the regular expression
        }
    }

    public static void main(String[] args) {
        String filter = "fw\\banal\\b|\\bass\\b|\\basshole\\b|\\bbastard\\b|\\bbeastiality\\b|\\bbitch\\b|\\bbitches\\b|\\bbitchy\\b|\\bblow job\\b|\\bblow-job\\b|\\bblowjob\\b|\\bboner\\b|\\bboobies\\b|\\bboobs\\b|\\bbreasts\\b|\\bbutt\\b|\\bcallgirl\\b|\\bcocaine\\b|\\bcock\\b|\\bcojones\\b|\\bcoochy\\b|\\bcunilingus\\b|\\bcunny\\b|\\bcunt\\b|\\bdamn\\b|\\bdickhead\\b|\\bdyke\\b|\\becstacy\\b|\\becstasy\\b|\\bfaggot\\b|\\bfart\\b|\\bfellatio\\b|\\bfuck\\b|\\bfucked\\b|\\bfucked-up\\b|\\bfucker\\b|\\bfucking\\b|\\bgoddamn\\b|\\bhard-on\\b|\\bheroin\\b|\\bhonky\\b|\\bhymie\\b|\\bkike\\b|\\bmarijuana\\b|\\bmasturbate\\b|\\bmotherfucker\\b|\\bnegro\\b|\\bnigger\\b|\\bnipple\\b|\\bpecker\\b|\\bpenis\\b|\\bpiss\\b|\\bprostitute\\b|\\bpussy\\b|\\bscumbag\\b|\\bshit\\b|\\bshits\\b|\\bshitty\\b|\\bson-of-a-bitch\\b|\\bspic\\b|\\btits\\b|\\btitties\\b|\\btitty\\b|\\bvagina\\b|\\bwhore\\b|\\bwop\\b";
        RegexMatchAll t = new RegexMatchAll();

        t.adTextIsClean("fUck this ShiT", filter);
    }
}