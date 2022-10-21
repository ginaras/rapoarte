public class Main {
    public static void main(String[] args) {


            int i;
            int j;

            i = (int) (Math.random() * (100 - 1));
            j = (int) (Math.random() * (100 - i));
        System.out.println(i+" + "+j+" = "+(i+j));

        i = (int) (Math.random() * (10 - 1));
        j = (int) (Math.random() * (10 - i));
        System.out.println(i+" x "+j+" = "+(i*j));


        i = (int) (Math.random() * (100 - 1));
        j = (int) (Math.random() * (100 - i));
        final boolean b = i - j > 0;
        if(b) {
            System.out.println(i+" - "+j+" = "+(i-j));
        }else {
            System.out.println(j+" - "+i+" = "+(j-i));
        }

        i = (int) (Math.random() * (100 - 1));
        j = (int) (Math.random() * (2));

        System.out.println(j+"  "+i+" = "+(""));

    }


}