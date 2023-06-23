package stepDefinitions;

public class deneme_StepDef {

    enum Cinsiyet{
        Erkek,
        Kadin,
        kadin,
    }

    enum OdemeTipi{
        paypal,
        stripe,
        squareUp
    }

    public static void main(String[] args) {

        Cinsiyet kadin = Cinsiyet.Kadin;
        Cinsiyet erkek = Cinsiyet.Erkek;

        System.out.println("erkek = " + erkek);
        System.out.println("kadin = " + kadin);


        String odeme = "paypal";

        if(OdemeTipi.paypal.toString().equals(odeme)){
           paypalOdemeAl();
        }
        if(OdemeTipi.stripe.toString().equals(odeme)){
           stripeOdemeAl();
        }
        if(OdemeTipi.squareUp.toString().equals(odeme)){
            squareUpOdemeAl();
        }

    }


    private static void paypalOdemeAl(){
        System.out.println("paypal = " + true);
    }

    private static void squareUpOdemeAl(){
        System.out.println("squareUp = " + true);
    }

    private static void stripeOdemeAl(){
        System.out.println("stripe = " + true);
    }





}
