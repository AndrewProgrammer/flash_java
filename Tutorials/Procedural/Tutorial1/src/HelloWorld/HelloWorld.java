package HelloWorld;

public class HelloWorld {
    static  String randomString = "String to print";
    static  final  double PINUM = 3.141529;
    public static  void main(String[] args)
    {
        System.out.println("Hello World!");
        System.out.println(randomString);
        System.out.println(PINUM);

        int integerOne = 22;

        int integerTwo
                =
                integerOne
                +1;
        System.out.println(integerTwo);

        byte bigByte = 127;
        short bigShort = 32767;
        int bigInt = 210000000; // 2.1 Billion
        long bigLong = 9220000000000000000L; // 92 and 16 (0)
        float bigFloat = 3.14F;
        double bigDouble = 3.1213171238912789372189;

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        boolean trueOrFalse= true;

        char randomChar = 66;
        char anotherChar = 'A';

        char espaceChars = '\\';

        System.out.println(randomChar);
        System.out.println(espaceChars);

        String randomString = "I`m a random string";
        String anotherString = "Stuff";

        String andAnotherString = randomString + ' ' + anotherString;

        System.out.println(randomString);
        System.out.println(espaceChars);
        System.out.println(andAnotherString);


        String byteString = Byte.toString(bigByte);
        String shortString = Short.toString(bigByte);
        String intString = Integer.toString(bigByte);
        String longString = Long.toString(bigByte);
        String floatString = Float.toString(bigByte);
        String doubleString = Double.toString(bigByte);
        //String booleanString = Boolean.toString(bigByte); // cause of boolean

        double aDoubleValue = 3;
        int doubleToInt = (int)aDoubleValue; // Convert in Double

        int stringToInt = Integer.parseInt(intString); //Convert to Int

        System.out.println(doubleToInt);
        System.out.println(stringToInt);
    }
}
