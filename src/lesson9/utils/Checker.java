package lesson9.utils;

/**
 * Created by SERGIO on 12.04.2017.
 */
public class Checker {
    //public
    //private
    //default
    //protected

    //private
    //default
    //protected
    //public



    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName){

//        if(companyName == "Google" || companyName == "Amazon"){
  //          return false;
    //    }
      //  return true;

        if(companyNamesValidatedCount > 10){
            return false;
        }
        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
