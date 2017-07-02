package lesson18;

public class Definition {

    private void notifyUsers(String[] userEmails) {

        for (String email : userEmails) {

            try {
                //send email to user - error
                System.out.println("Email " + email + " was send");

            } catch (Exception e){
                System.err.println("Email " + email + "wasn't send");

                //how should i handle exception
            }
            finally {
                //updateStatus
            }

        }
    }
}
