package lesson9;

import lesson9.utils.Checker;

/**
 * Created by SERGIO on 12.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Company company = new Company("Test", "Test");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());


        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
        //System.out.println(checker.companyNamesValidatedCount);

    }
}
