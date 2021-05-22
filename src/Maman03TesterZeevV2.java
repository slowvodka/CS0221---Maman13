
public class Maman03TesterZeevV2
{
    public static void main(String[] args)
    {

        System.out.println("********** Test Q1 RGBImage - Start **********\n");
        System.out.println("Notes!:\n" +
        "*if says Exception - it means the code does not run at all!!!!\n"+
        "*to make the best of this tester fix the code if the order of the testers\n" +
        "meaning - constructors, then getters, then setters, then getwidth etc. \n" +
        "it is important since some of the testers require some working methods\n"+
        "*some of the Error output is not so informative since i`m bit lazy\n" +
        "\n* LAST UPDATE 12-04-2021 \n");

        System.out.println("**** Test - RGBImage default constructor, getters and setters");
        constructorTest();
        System.out.println("**** Test - RGBImage getWidth, getHeight");
        HeightWidthTest();
        System.out.println("**** Test - RGBImage second constructor & copy constructor");
        constructor2Test();
        System.out.println("**** Test - RGBImage aliasing Test");
        aliasingTest();
        System.out.println("**** Test - RGBImage equals Test");
        equalsTest();
        System.out.println("**** Test - RGBImage toString Test");
        toStringTest();
        System.out.println("**** Test - RGBImage flipHorizontal Test");
        flipHorTest();
        System.out.println("**** Test - RGBImage flipVertical Test");
        flipVerTest();
        System.out.println("**** Test - RGBImage invertColors Test");
        invColorsTest();
         System.out.println("**** Test - RGBImage toRGBColorArray Test");
        toRGBColorArrayTest();
        System.out.println("**** Test - RGBImage toGrayscaleArray Test");
        toGrayscaleArrayTest();

        System.out.println("**** Test - RGBImage shiftCol Test");
        shiftColTest();

        System.out.println("**** Test - RGBImage shiftRow Test");
        shiftRowTest();

        System.out.println("**** Test - RGBImage rotateClockwise Test");
        rotateClockwiseTest();
        System.out.println("**** Test - RGBImage rotateCounterClockwise Test");
        rotateCounterClockwiseTest();

        System.out.println("********** Test Q1 RGBImage - End **********\n");
    }

    public static void constructorTest()
    {
        //empty constructor same rows and cols
        try {
            RGBImage t1Constructor = new RGBImage(10, 10);
            System.out.println("\tOK!");
        }
        catch(Exception e){
            System.out.println("\tError - cannot initialize constructor");
        }

        //empty constructor more cols
        try {
            RGBImage t1Constructor = new RGBImage(5, 10);
            System.out.println("\tOK!");
        }
        catch(Exception e){
            System.out.println("\tError - Error when more rows than columns");
        }

        //empty constructor more rows
        try {
            RGBImage t1Constructor = new RGBImage(10, 5);
            System.out.println("\tOK!");
        }
        catch(Exception e){
            System.out.println("\tError - Error when more columns than rows");
        }

        //testing getter
        try {
            RGBImage t1Constructor = new RGBImage(10, 5);
            RGBColor pix = new RGBColor (t1Constructor.getPixel(0,0));
            if (pix.equals(new RGBColor()))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - Getter is not working properly.");

            try
            {
                pix = new RGBColor (t1Constructor.getPixel(11,11));
                if (pix.equals(new RGBColor()))
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - Getter is not working properly - try to get pixel out of array");
            }
            catch(Exception e){
                System.out.println("\tError - *Exception* in getter - try to get pixel out of array");
            }
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* in getPixel method");
        }

        //testing setter
        try {
            RGBColor newPix = new RGBColor(1,1,1);
            RGBImage t1Constructor = new RGBImage(10, 5);
            t1Constructor.setPixel(0,0,newPix);
            RGBColor pix = new RGBColor (t1Constructor.getPixel(0,0));
            if (pix.equals(new RGBColor(1,1,1)))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - Setter is not working properly.");

            try
            {
                t1Constructor.setPixel(11,11, new RGBColor(0,0,1));
                System.out.println("\tOK!");
            }
            catch(Exception e){
                System.out.println("\tError - *Exception* in Setter - try to set pixel out to array");
            }
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* in SetPixel method");
        }

        //check empty constructor are all black
        try {
            RGBColor blackPix = new RGBColor();
            RGBImage t1Constructor = new RGBImage(10, 5);
            boolean flag = true;
            for (int i = 0; i<10 && flag ; i++) {
                for (int j = 0; j < 5 && flag; j++) {
                    if (!t1Constructor.getPixel(i, j).equals(blackPix))
                        flag = false;
                }
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - initialization constructor all pixels should be black");
            }
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* in initialization of default constructor");
        }
    }//end of constructor, getter, setter test

    public static void HeightWidthTest(){
        int r = 10, c= 5;
        RGBImage t1Constructor = new RGBImage(r, c);

        //height
        try {
            int rows = t1Constructor.getHeight();
            if (rows == r)
                System.out.println("\tOK!");
            else
                System.out.println("\tError - getHeight() does not work");
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* when run getHeight()");
        }

        //width
        try {
            int cols = t1Constructor.getWidth();
            if (cols == c)
                System.out.println("\tOK!");
            else
                System.out.println("\tError - getWidth() does not work");
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* when run getWidth()");
        }

        //test if only 1 row and 1 column
        try {
            RGBImage t2Constructor = new RGBImage(1, 1);
            int rows = t2Constructor.getHeight();
            int cols = t2Constructor.getWidth();
            if (cols == 1 && rows == 1 )
                System.out.println("\tOK!");
            else
                System.out.println("\tError - Width and Height are 1,1 but actual are " + rows + "," + cols);
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* when run getWidth()/ getHeight()");
        }

    }//end of HeightWidthTest

    public static void constructor2Test(){
        RGBColor[][] arr = new RGBColor[2][3];
        RGBColor[][] arr2 = new RGBColor[2][3];
        for (int i =0; i<2; i++)
            for (int j =0; j<3; j++)
                arr[i][j] = new RGBColor();
        /*
        [1][0][0]  [0][1][0] [0][0][1]
        [1][1][1]  [1][1][1] [0][0][0]
         */
        arr[0][0].setRed(1);
        arr[0][1].setGreen(1);
        arr[0][1].setBlue(1);
        arr[1][0] = new RGBColor(1,1,1);
        arr[1][1] = new RGBColor(1,1,1);
        for (int i = 0; i < 2 ; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                arr2[i][j] = new RGBColor(arr[i][j]);
            }
        }

        //test constructor from array if RGBcolor
        try {
            RGBImage img = new RGBImage(arr);
            System.out.println("\tOK!");
            boolean flag = true;
            for (int i = 0; i<2 && flag; i++)
            {
                for (int j = 0; j < 3 && flag; j++)
                {
                    if (!arr2[i][j].equals(arr[i][j]))
                        flag = false;
                }
            }
            if (flag)
                System.out.println("\tOK!");
            else
                System.out.println("\tError - constructor in RGBImage(RGBColor[][] pixels)");
        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in constructor RGBImage(RGBColor[][] pixels)");
        }

        //test copy constructor
        try{
            RGBImage img = new RGBImage(arr);
            RGBImage imgCopy = new RGBImage(img);
            RGBColor pix = new RGBColor(255,254,253);
            img.setPixel(0,0,new RGBColor(pix));
            imgCopy.setPixel(0,0,new RGBColor(pix));
            boolean flag = true;
            for (int i = 0; i < 2 && flag; i++)
            {
                for (int j = 0; j < 3 && flag; j++)
                {
                    if (!(img.getPixel(i,j).equals(imgCopy.getPixel(i,j))))
                        flag = false;
                }
            }
            if (flag)
                System.out.println("\tOK!");
            else
                System.out.println("\tError - Copy constructor does not copy");

        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in Copy constructor");
        }
    } //end constructor2Test

    public static void aliasingTest(){
        RGBImage img = new RGBImage(2,2);
        RGBColor pix = new RGBColor(1,1,1);
        img.setPixel(0,0,pix);
        pix.setRed(2);
        if (pix == img.getPixel(0,0) || pix.getRed() == img.getPixel(0,0).getRed())
            System.out.println("\tError - Aliasing problem default constructor");
        else
            System.out.println("\tOK!");

        RGBColor[][] arr = new RGBColor[2][2];
        for (int i = 0; i<2 ; i++)
            for (int j = 0; j < 2 ; j++)
                arr[i][j] = new RGBColor();

        pix = new RGBColor(1,1,1);
        arr[0][0] = new RGBColor(pix);
        img = new RGBImage(arr);
        arr[0][0] = new RGBColor(2,2,2);
        if (arr[0][0] == img.getPixel(0,0) || arr[0][0].getRed() == img.getPixel(0,0).getRed())
            System.out.println("\tError - Aliasing problem second constructor");
        else
            System.out.println("\tOK!");

        RGBImage img2 = new RGBImage(img);
        img2.setPixel(0,0, new RGBColor(100,0,0));
        if (img == img2 || img.getPixel(0,0).getRed() == img2.getPixel(0,0).getRed())
            System.out.println("\tError - Aliasing problem Copy constructor");
        else
            System.out.println("\tOK!");
    } //end of aliasing tester

    public static void equalsTest(){
        try{
            RGBColor[][] arr = new RGBColor[2][3];
            for (int i = 0; i<2 ; i++)
                for (int j = 0; j < 3 ; j++)
                    arr[i][j] = new RGBColor(i*j,i*j,i*j);
            RGBImage img1 = new RGBImage(arr);
            RGBImage img2 = new RGBImage(img1);
            if (img1.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - image not equals to itself");
            }

            if (img1.equals(img2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - equals does not work");
            }

            arr = new RGBColor[3][2];
            for (int i = 0; i<3 ; i++)
                for (int j = 0; j < 2 ; j++)
                    arr[i][j] = new RGBColor(i*j,i*j,i*j);
            img1 = new RGBImage(arr);
            img2 = new RGBImage(img1);
            if (img1.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - image not equals to itself");
            }

            if (img1.equals(img2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - equals does not work");
            }
            img1 = new RGBImage(3,2);
            img2 = new RGBImage(2,2);

            if (!img1.equals(img2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not in the same size");
            }

            if (!img2.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not in the same size");
            }
            RGBColor pix = new RGBColor(255,254,253);

            img2 = new RGBImage(img1);
            img2.setPixel(0,0,pix);
            if (!img2.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not the same in pixel 0,0");
            }
            img2 = new RGBImage(img1);
            img2.setPixel(0,0,pix);
            if (!img2.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not the same in pixel 0,0");
            }

            if (!img1.equals(img2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not the same in pixel 0,0");
            }
            img1 = new RGBImage(3,2);
            img2 = new RGBImage(img1);
            img2.setPixel(2,1,pix);

            if (!img1.equals(img2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not the same in pixel 2,1");
            }

            if (!img2.equals(img1))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - images not the same in pixel 2,1");
            }
        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in equals method");
        }
    }//end of equals test

    public static void toStringTest(){
        try{

            RGBImage img = new RGBImage(1,1);
            String s = "(0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be \n" + s + "actual \n" + img.toString());
            }

            img = new RGBImage(2,2);
            s = "(0,0,0) (0,0,0)\n(0,0,0) (0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be\n" + s + "actual \n" + img.toString());
            }

            img = new RGBImage(1,3);
            s = "(0,0,0) (0,0,0) (0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be \n" + s + "actual \n" + img.toString());
            }

            img = new RGBImage(3,1);
            s = "(0,0,0)\n(0,0,0)\n(0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be \n" + s + "actual \n" + img.toString());
            }

            img = new RGBImage(3,2);
            s = "(0,0,0) (0,0,0)\n(0,0,0) (0,0,0)\n(0,0,0) (0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be \n" + s + "actual \n" + img.toString());
            }

            img = new RGBImage(2,3);
            s = "(0,0,0) (0,0,0) (0,0,0)\n(0,0,0) (0,0,0) (0,0,0)\n";
            if (s.equals(img.toString()))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - String should be \n" + s + "actual \n" + img.toString());
            }
        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in toString method");
        }
    }//end of toString Test

    public static void flipHorTest(){
        try {
            //1pixel
            try {
                RGBImage img1 = new RGBImage(1, 1);
                RGBImage img2 = new RGBImage(1, 1);
                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping one pixel");
            }
            //3X3 change in 0,0
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 3);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(0,0,pix);
                img2.setPixel(0,2,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X3 image");
            }
            //3X3 change in 0,2
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 3);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(0,0,pix);
                img2.setPixel(0,2,pix);

                img1.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X3 image");
            }
            //3X3 change in 2,0
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 3);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(2,0,pix);
                img2.setPixel(2,2,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X3 image");
            }
            //3X2
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 2);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(0,0,pix);
                img2.setPixel(0,1,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X2 image");
            }

            //2X3
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(2, 3);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(1,0,pix);
                img2.setPixel(1,2,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X3 image");
            }


            //1X1 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(1, 1);
                RGBImage img2 = new RGBImage(img1);
                //img1.setPixel(0,0,pix);
                img2.setPixel(0,0,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 1X1 image");
            }

            //2X2 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(2, 2);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(0,0,pix);
                img1.setPixel(1,1,pix);
                img2.setPixel(0,0,pix);


                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tError - \nimg1: " + img1 + "\nimg2: " + img2 + "not same but got true");
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2 image");
            }

            //3X2 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 2);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(2,0,pix);
                img2.setPixel(0,0,pix);

                img2.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tError - \nimg1: " + img1 + "\nimg2: " + img2 + "not same but got true");
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X2 image");
            }

            //3X3 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 2);
                RGBImage img2 = new RGBImage(img1);
                img1.setPixel(0,0,pix);
                img2.setPixel(2,0,pix);

                img1.flipHorizontal();
                if (img1.equals(img2))
                    System.out.println("\tError - \nimg1: " + img1 + "\nimg2: " + img2 + "not same but got true");
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 3X3 image");
            }
        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in flipHorTest method");
        }
    }// end of flipHorTest

    public static void flipVerTest() {
        try {
            //1pixel
            try {
                RGBImage img1 = new RGBImage(1, 1);
                RGBImage img2 = new RGBImage(1, 1);
                img2.flipVertical();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \noriginal: " + img1 + "\nflipped: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping one pixel");
            }

            //2X2
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(2, 2);
                RGBImage img2 = new RGBImage(2, 2);
                img1.setPixel(0,0,pix);
                img2.setPixel(1,0,pix);
                img2.flipVertical();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2");
            }

            //2X2
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(2, 2);
                RGBImage img2 = new RGBImage(2, 2);
                img1.setPixel(0,0,pix);
                img2.setPixel(1,0,pix);
                img1.flipVertical();
                if (img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nshould be: " + img2 + "\nactual: " + img1);
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2");
            }

            //2X2 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(2, 2);
                RGBImage img2 = new RGBImage(2, 2);
                img2.setPixel(0,0,pix);
                img1.setPixel(0,1,pix);
                img2.flipVertical();
                if (!img1.equals(img2))
                    System.out.println("\tOK!");
                else {
                    System.out.println("\tError - \nimg1: " + img1 + "\nimg2: " + img2 + "not same but got true");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2");
            }

            //3X2
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 2);
                RGBImage img2 = new RGBImage(3, 2);
                img2.setPixel(0,0,pix);
                img1.setPixel(2,0,pix);
                img2.flipVertical();
                if (!img1.equals(img2))
                    System.out.println("\tError - \nshould be: " + img1 + "\nactual: " + img2);
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2");
            }

            //3X2 not same
            try {
                RGBColor pix = new RGBColor(255,254,253);
                RGBImage img1 = new RGBImage(3, 2);
                RGBImage img2 = new RGBImage(3, 2);
                img2.setPixel(0,0,pix);
                img1.setPixel(0,1,pix);
                img2.flipVertical();
                if (img1.equals(img2))
                    System.out.println("\tError - \nimg1: " + img1 + "\nimg2: " + img2 + "not same but got true");
                else {
                    System.out.println("\tOK!");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* when flipping 2X2");
            }

        } catch (Exception e) {
            System.out.println("\tError - *Exception* in flipVertical method");
        }

    } // end of flipVerTest

    public static void invColorsTest() {
        try {
            RGBColor pix = new RGBColor(255,254,253);
            RGBColor invPix = new RGBColor(pix);
            invPix.invert();

            //1X1
            try {
                RGBImage img1 = new RGBImage(1,1);
                RGBImage img2 = new RGBImage(1,1);
                img1.setPixel(0,0, pix);
                img2.setPixel(0,0, invPix);
                img2.invertColors();

                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 1 pixel");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 1 pixel");
            }

            //1X1
            try {
                RGBImage img1 = new RGBImage(1,1);
                RGBImage img2 = new RGBImage(1,1);
                img2.setPixel(0,0, pix);
                img1.setPixel(0,0, invPix);
                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 1 pixel");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 1 pixel");
            }

            //2X2
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,0, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,0, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X2 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X2 pixels");
            }

            //2X2
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,1, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X2 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X2 pixels");
            }

            //3X2
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(3,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,1, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 3X2 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 3X2 pixels");
            }

            //3X2
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(3,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,1, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 3X2 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 3X2 pixels");
            }

            //2X3
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,3);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,2, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,2, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X3 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X3 pixels");
            }

            //2X3
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,3);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,0, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,0, invPix);

                img1.invertColors();
                if (img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X3 pixels");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X3 pixels");
            }

            //1X1 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(1,1);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,0, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,0, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 1X1 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 1X1 pixels");
            }

            //2X2 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,1, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X2 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X2 pixels");
            }

            //3X2 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(3,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,1, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 3X2 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 3X2 pixels");
            }

            //3X2 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(3,2);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,1, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,1, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 3X2 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 3X2 pixels");
            }

            //2X3 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,3);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(1,2, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(1,2, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError inverting 2X3 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X3 pixels");
            }

            //2X3 not same
            try {
                RGBColor wt = new RGBColor(255,255,255);
                RGBImage img1 = new RGBImage(2,3);
                RGBImage img2 = new RGBImage(img1);

                img2.setPixel(0,0, pix);

                for (int i =0; i<img1.getHeight(); i++ )
                    for (int j =0; j<img1.getWidth(); j++ )
                        img1.setPixel(i,j,wt);
                img1.setPixel(0,0, pix);

                img1.invertColors();
                if (!img2.equals(img1))
                    System.out.println("\tOK!");
                else{
                    System.out.println("\tError - inverting 2X3 pixels, they are not same but got True");
                }
            } catch (Exception e) {
                System.out.println("\tError - *Exception* invertColors 2X3 pixels");
            }

        } catch (Exception e) {
            System.out.println("\tError - *Exception* in invertColors method");
        }
    } // end of invert colors test

    public static void toRGBColorArrayTest(){
        try{
            RGBColor pix = new RGBColor(255,254,253);
            RGBColor[][] imgInArr;

            //1X1 black
            try{
                RGBImage img1 = new RGBImage(1,1);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 1X1 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 1X1 pixel");
            }

            //1X1
            try{
                RGBImage img1 = new RGBImage(1,1);
                img1.setPixel(0,0,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 1X1 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 1X1 pixel");
            }

            //2X2 black
            try{
                RGBImage img1 = new RGBImage(2,2);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 2X2 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 2X2 pixel");
            }

            //2X2
            try{
                RGBImage img1 = new RGBImage(2,2);
                img1.setPixel(0,0,pix);
                img1.setPixel(0,1,new RGBColor(2,4,5));
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 2X2 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 2X2 pixel");
            }

            //3X2 black
            try{
                RGBImage img1 = new RGBImage(3,2);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 3X2 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 3X2 pixel");
            }

            //3X2
            try{
                RGBImage img1 = new RGBImage(3,2);
                img1.setPixel(0,0,pix);
                img1.setPixel(1,0,pix);
                img1.setPixel(2,0,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 3X2 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 3X2 pixel");
            }

            //2X3
            try{
                RGBImage img1 = new RGBImage(2,3);
                img1.setPixel(0,1,pix);
                img1.setPixel(0,2,pix);
                img1.setPixel(0,0,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img1.getHeight() && flag ; i++)
                    for (int j=0 ; j < img1.getWidth() && flag ; j++)
                        if (!img1.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generate array from 2X3 pixel ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 2X3 pixel");
            }

            //1X1 wrong
            try{
                RGBImage img1 = new RGBImage(1,1);
                RGBImage img2 = new RGBImage(1,1);
                img1.setPixel(0,0,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img2.getHeight() && flag ; i++)
                    for (int j=0 ; j < img2.getWidth() && flag ; j++)
                        if (!img2.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (!flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generated wrong array in 1X1 ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 1X1 pixel");
            }

            //2X2 wrong
            try{
                RGBImage img1 = new RGBImage(2,2);
                RGBImage img2 = new RGBImage(2,2);
                img1.setPixel(0,1,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img2.getHeight() && flag ; i++)
                    for (int j=0 ; j < img2.getWidth() && flag ; j++)
                        if (!img2.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (!flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generated wrong array in 2X2 ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 2X2 pixel");
            }

            //3X2 wrong
            try{
                RGBImage img1 = new RGBImage(2,2);
                RGBImage img2 = new RGBImage(2,2);
                img2.invertColors();
                img1.setPixel(0,1,pix);
                imgInArr = img1.toRGBColorArray();
                Boolean flag = true;
                for (int i=0 ; i < img2.getHeight() && flag ; i++)
                    for (int j=0 ; j < img2.getWidth() && flag ; j++)
                        if (!img2.getPixel(i,j).equals(imgInArr[i][j]))
                            flag = false;
                if (!flag)
                    System.out.println("\tOK!");
                else
                    System.out.println("\tError - generated wrong array in 3X2 ");
            }
            catch (Exception e)
            {
                System.out.println("\tError - *Exception* in 3X2 pixel");
            }
        }catch (Exception e){
            System.out.println("\tError - *Exception* in toRGBColorArray method");
        }
    }//end of toRGBColorArrayTest

    public static void toGrayscaleArrayTest(){
        try{
            RGBColor pix = new RGBColor(255,254,253);
            RGBColor invPix = new RGBColor(pix);
            invPix.invert();
            double pixD = pix.convertToGrayscale();
            double invPixD = invPix.convertToGrayscale();
            double blackD = new RGBColor(0,0,0).convertToGrayscale();

            //1X1
            RGBImage img1 = new RGBImage(1,1);
            double[][] d1 = img1.toGrayscaleArray();
            double[][] d1Ans = {{blackD}};
            if (DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 array");

            //2X2
            img1 = new RGBImage(2,2);
            img1.setPixel(0,0,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{pixD, blackD}, {blackD, blackD}};
            if (DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 array");

            //3X2
            img1 = new RGBImage(3,2);
            img1.setPixel(0,0,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{pixD, blackD}, {blackD, blackD} ,{blackD, blackD}};
            if (DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 array");

            //3X2
            img1 = new RGBImage(2,3);
            img1.setPixel(0,0,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{pixD, blackD,blackD} , {blackD,blackD, blackD}};
            if (DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 array");

            //3X2
            img1 = new RGBImage(2,3);
            img1.setPixel(0,0,pix);
            img1.setPixel(1,2,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{pixD, blackD,blackD} , {blackD,blackD, pixD}};
            if (DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 array");

            //3X2 not same
            img1 = new RGBImage(2,3);
            img1.setPixel(0,0,pix);
            img1.setPixel(1,2,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{invPixD, blackD,blackD} , {blackD,blackD, pixD}};
            if (!DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 array not same but indicates True");

            //3X3 not same
            img1 = new RGBImage(3,3);
            img1.setPixel(0,0,pix);
            img1.setPixel(1,2,pix);
            d1 = img1.toGrayscaleArray();
            d1Ans = new double[][]{{invPixD, blackD,blackD} , {blackD,blackD, pixD}, {invPixD, blackD,blackD}};
            if (!DArrSame(d1,d1Ans))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X3 array not same but indicates True");
        }
        catch(Exception e){
            System.out.println("\tError - *Exception* in toGrayscaleArray method");
        }
    }//end of toGrayscaleArrayTest

    private static boolean DArrSame(double[][] arr1, double[][] arr2 ){
        boolean same = true;
        for (int i=0; same && i<arr1.length; i++ )
            for (int j=0; same && j<arr1[0].length; j++ )
                if (arr1[i][j] != arr2[i][j])
                    same = false;
        return same;
    }

    public static void shiftColTest(){
        try{
            RGBColor pix = new RGBColor(255,254,253);
            RGBColor invPix = new RGBColor(pix);
            invPix.invert();
            RGBColor blackP = new RGBColor();

            //1X1 no change
            RGBImage imginv1 = new RGBImage(1,1);
            RGBImage imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            RGBImage imginv2 = new RGBImage(imginv1);

            //1X1 no offset
            imginv1.shiftCol(0);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 0 offset should not change");

            //1X1 - 3 offset
            imginv1.shiftCol(3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 3 offset should not change");

            //1X1 - -3 offset
            imginv1.shiftCol(-3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with -3 offset should be black");

            //1X1 - 1 offset
            imginv1.shiftCol(1);
            if (imginv1.equals(imgblack))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 1 offset should be black");

            //1X1 - -1 offset
            imginv1.shiftCol(-1);
            if (imginv1.equals(imgblack))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 1 offset should be black");

            //2X2
            imginv1 = new RGBImage(2,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            //2X2 - 0 offset
            imginv1.shiftCol(0);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 0 offset should no change");

            //2X2 - 3 offset
            imginv1.shiftCol(3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 3 offset should no change");

            //2X2 - -3 offset
            imginv1.shiftCol(-3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with -3 offset should no change");

            //2X2 - 1 offset
            imginv1.shiftCol(1);
            imginv2.setPixel(0,0, blackP);
            imginv2.setPixel(1,0, blackP);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 1 offset should change");

            //2X2 - -1 offset
            imginv1 = new RGBImage(2,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(-1);
            imginv2.setPixel(0,1, blackP);
            imginv2.setPixel(1,1, blackP);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with -1 offset should change");

            //3X3 - 2 offset
            imginv1 = new RGBImage(3,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftCol(2);
            imginv2.setPixel(0,2, new RGBColor(255,255,255));
            imginv2.setPixel(1,2, new RGBColor(255,255,255));
            imginv2.setPixel(2,2, new RGBColor(255,255,255));



            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X3 image with 2 offset should change");

            //3X3 - -2 offset
            imginv1 = new RGBImage(3,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftCol(-2);
            imginv2.setPixel(0,0, new RGBColor(255,255,255));
            imginv2.setPixel(1,0, new RGBColor(255,255,255));
            imginv2.setPixel(2,0, new RGBColor(255,255,255));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X3 image with -2 offset should change");

            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(1);
            imginv2.setPixel(0,0, new RGBColor());
            imginv2.setPixel(1,0, new RGBColor());
            imginv2.setPixel(2,0, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with 1 offset should change");

            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(-1);
            imginv2.setPixel(0,1, new RGBColor());
            imginv2.setPixel(1,1, new RGBColor());
            imginv2.setPixel(2,1, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with -1 offset should change");

            //3X2 -2
            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();

            imginv1.shiftCol(-2);


            if (imginv1.equals(imgblack))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with -2 offset should be black");

            //2X3 1
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(1);
            imginv2.setPixel(0,0, new RGBColor());
            imginv2.setPixel(1,0, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 1 offset should change");

            //2X3 2
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(2);
            imginv2.setPixel(0,0, new RGBColor());
            imginv2.setPixel(1,0, new RGBColor());
            imginv2.setPixel(0,1, new RGBColor());
            imginv2.setPixel(1,1, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 2 offset should change");


            //2X3 3
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftCol(3);

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 3 offset should be black");

            //2X3 -2
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftCol(-2);
            imginv2.setPixel(0,2, new RGBColor());
            imginv2.setPixel(1,2, new RGBColor());
            imginv2.setPixel(0,1, new RGBColor());
            imginv2.setPixel(1,1, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with -2 offset should be black");

            //4X4 2 - complex
            imginv1 = new RGBImage(4,4);
            imgblack = new RGBImage(imginv1);
            for (int i = 0 ; i<imgblack.getHeight(); i++)
                for (int j = 0 ; j<imgblack.getWidth()-i; j++)
                    if (i%2 == 0)
                        imginv1.setPixel(i,j,pix);
                    else
                        imginv1.setPixel(i,j,invPix);
            imginv2 = new RGBImage(imgblack);
            RGBImage img = new RGBImage(imginv1);


            imginv1.shiftCol(2);
            imginv2.setPixel(0,2, new RGBColor(pix));
            imginv2.setPixel(0,3, new RGBColor(pix));

            imginv2.setPixel(1,2, new RGBColor(invPix));
            imginv2.setPixel(1,3, new RGBColor(invPix));

            imginv2.setPixel(2,2, new RGBColor(pix));
            imginv2.setPixel(2,3, new RGBColor(pix));

            imginv2.setPixel(3,2, new RGBColor(invPix));
            imginv2.setPixel(3,3, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - 4X4 image is:\n" +
                        img.toString() + "\noffset 2 got:\n" +
                        imginv1.toString() + "\nbut should be:\n" +
                        imginv2.toString());
            }

            //4X4 -2 - complex
            imginv1 = new RGBImage(img);
            imgblack = new RGBImage(4,4);
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftCol(-2);

            imginv2.setPixel(0,0, new RGBColor(pix));
            imginv2.setPixel(0,1, new RGBColor(pix));

            imginv2.setPixel(1,0, new RGBColor(invPix));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - 4X4 image is:\n" +
                        img.toString() + "\noffset 2 got:\n" +
                        imginv1.toString() + "\nbut should be:\n" +
                        imginv2.toString());
            }

        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in shiftCol method");
        }

    }//end of shiftColTest

    public static void shiftRowTest(){
        try{
            RGBColor pix = new RGBColor(255,254,253);
            RGBColor invPix = new RGBColor(pix);
            invPix.invert();
            RGBColor blackP = new RGBColor();

            //1X1 no change
            RGBImage imginv1 = new RGBImage(1,1);
            RGBImage imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            RGBImage imginv2 = new RGBImage(imginv1);

            //1X1 no offset
            imginv1.shiftRow(0);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 0 offset should not change");

            //1X1 - 3 offset
            imginv1.shiftRow(3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 3 offset should not change");

            //1X1 - -3 offset
            imginv1.shiftRow(-3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with -3 offset should no change");

            //1X1 - 1 offset
            imginv1.shiftRow(1);
            if (imginv1.equals(imgblack))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with 1 offset should be black");

            //1X1 - -1 offset
            imginv1.shiftRow(-1);
            if (imginv1.equals(imgblack))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 1X1 image with -1 offset should be black");

            //2X2
            imginv1 = new RGBImage(2,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            //2X2 - 0 offset
            imginv1.shiftRow(0);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 0 offset should no change");

            //2X2 - 3 offset
            imginv1.shiftRow(3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 3 offset should no change");

            //2X2 - -3 offset
            imginv1.shiftRow(-3);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with -3 offset should no change");

            //2X2 - 1 offset
            imginv1.shiftRow(1);
            imginv2.setPixel(0,0, blackP);
            imginv2.setPixel(0,1, blackP);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with 1 offset should change");

            //2X2 - -1 offset
            imginv1 = new RGBImage(2,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftRow(-1);
            imginv2.setPixel(1,0, blackP);
            imginv2.setPixel(1,1, blackP);
            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X2 image with -1 offset should change");


            //3X3 - 2 offset
            imginv1 = new RGBImage(3,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftRow(2);
            imginv2.setPixel(2,0, new RGBColor(255,255,255));
            imginv2.setPixel(2,1, new RGBColor(255,255,255));
            imginv2.setPixel(2,2, new RGBColor(255,255,255));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X3 image with 2 offset should change");


            //3X3 - -2 offset
            imginv1 = new RGBImage(3,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftRow(-2);
            imginv2.setPixel(0,0, new RGBColor(255,255,255));
            imginv2.setPixel(0,1, new RGBColor(255,255,255));
            imginv2.setPixel(0,2, new RGBColor(255,255,255));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X3 image with -2 offset should change");

            //3X2 1
            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftRow(1);
            imginv2.setPixel(0,0, new RGBColor());
            imginv2.setPixel(0,1, new RGBColor());


            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with 1 offset should change");

            //3X2 -1
            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftRow(-1);
            imginv2.setPixel(2,0, new RGBColor());
            imginv2.setPixel(2,1, new RGBColor());


            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with -1 offset should change");

            //3X2 -2
            imginv1 = new RGBImage(3,2);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);
            imginv2.setPixel(0,0,new RGBColor(255,255,255));
            imginv2.setPixel(0,1,new RGBColor(255,255,255));

            imginv1.shiftRow(-2);


            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 3X2 image with -2 offset should be black");

            //2X3 1
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftRow(1);
            imginv2.setPixel(0,0, new RGBColor());
            imginv2.setPixel(0,1, new RGBColor());
            imginv2.setPixel(0,2, new RGBColor());

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 1 offset should change");

            //2X3 2
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftRow(2);

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 2 offset should be black");


            //2X3 3
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imginv1);

            imginv1.shiftRow(3);

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with 3 offset should not change");

            //2X3 -2
            imginv1 = new RGBImage(2,3);
            imgblack = new RGBImage(imginv1);
            imginv1.invertColors();
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftRow(-2);

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else
                System.out.println("\tError - 2X3 image with -2 offset should be black");

            //4X4 2 - complex
            imginv1 = new RGBImage(4,4);
            imgblack = new RGBImage(imginv1);
            for (int i = 0 ; i<imgblack.getHeight(); i++)
                for (int j = 0 ; j<imgblack.getWidth()-i; j++)
                    if (i%2 == 0)
                        imginv1.setPixel(i,j,pix);
                    else
                        imginv1.setPixel(i,j,invPix);
            imginv2 = new RGBImage(imgblack);
            RGBImage img = new RGBImage(imginv1);

            imginv1.shiftRow(2);
            imginv2.setPixel(2,0, new RGBColor(pix));
            imginv2.setPixel(2,1, new RGBColor(pix));
            imginv2.setPixel(2,2, new RGBColor(pix));
            imginv2.setPixel(2,3, new RGBColor(pix));

            imginv2.setPixel(3,0, new RGBColor(invPix));
            imginv2.setPixel(3,1, new RGBColor(invPix));
            imginv2.setPixel(3,2, new RGBColor(invPix));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - 4X4 image is:\n" +
                        img.toString() + "\noffset 2 got:\n" +
                        imginv1.toString() + "\nbut should be:\n" +
                        imginv2.toString());
            }

            //4X4 -2 - complex
            imginv1 = new RGBImage(img);
            imgblack = new RGBImage(4,4);
            imginv2 = new RGBImage(imgblack);

            imginv1.shiftRow(-2);

            imginv2.setPixel(0,0, new RGBColor(pix));
            imginv2.setPixel(0,1, new RGBColor(pix));

            imginv2.setPixel(1,0, new RGBColor(invPix));

            if (imginv1.equals(imginv2))
                System.out.println("\tOK!");
            else {
                System.out.println("\tError - 4X4 image is:\n" +
                        img.toString() + "\noffset 2 got:\n" +
                        imginv1.toString() + "\nbut should be:\n" +
                        imginv2.toString());
            }

        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in shiftRow method");
        }

    }//end of shiftRowTest

    public static void rotateClockwiseTest(){
        int r,c,x;
        RGBImage imgOrig,imgRot;
        RGBColor[][] pixels;
        try{
            //1X1  pixels declaration
            r = 1; c =1;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //1X1 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //5X5  pixels declaration
            r = 5; c =5;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //5X5 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //15X1  pixels declaration
            r = 15; c =1;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //1X1 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //15X1  pixels declaration
            r = 15; c =1;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //14X3 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();
            imgRot.rotateClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in rotateClockwise method");
        }
    } //end of rotateClockwiseTest

    public static void rotateCounterClockwiseTest(){
        try{
            //1 pixel rotation
            RGBImage imgOrig = new RGBImage(1,1);
            RGBImage imgRot = new RGBImage(imgOrig);
            RGBImage imgComp = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //1 pixel rotation
            RGBColor pix = new RGBColor(1,1,1);
            imgOrig = new RGBImage(1,1);
            imgOrig.setPixel(0,0,pix);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //2X2 pixels declaration
            int r = 2, c =2,x =0;
            RGBColor[][] pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    x = i+j;
                    pixels[i][j] = new RGBColor(x,x,x);
                }

            //2X2
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();

            imgComp.setPixel(0,0, imgOrig.getPixel(0,1));
            imgComp.setPixel(0,1, imgOrig.getPixel(1,1));
            imgComp.setPixel(1,0, imgOrig.getPixel(0,0));
            imgComp.setPixel(1,1, imgOrig.getPixel(1,0));

            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //2X2 - 2nd
            imgOrig = new RGBImage(pixels);

            imgRot.rotateCounterClockwise();
            imgComp.rotateCounterClockwise();

            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 2 times should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //2X2 - 4th
            imgOrig = new RGBImage(pixels);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 time should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //3X3 pixels declaration
            r = 2; c =2;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    x = i+j;
                    pixels[i][j] = new RGBColor(x,x,x);
                }

            //3X3
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //3X2 pixels declaration
            r = 3; c =2;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //3X2 once
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(c,r);

            imgRot.rotateCounterClockwise();

            imgComp.setPixel(0,0,imgOrig.getPixel(0,1));
            imgComp.setPixel(0,1,imgOrig.getPixel(1,1));
            imgComp.setPixel(0,2,imgOrig.getPixel(2,1));
            imgComp.setPixel(1,0,imgOrig.getPixel(0,0));
            imgComp.setPixel(1,1,imgOrig.getPixel(1,0));
            imgComp.setPixel(1,2,imgOrig.getPixel(2,0));


            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //3X2 twice
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(r,c);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            imgComp.setPixel(0,0,imgOrig.getPixel(2,1));
            imgComp.setPixel(0,1,imgOrig.getPixel(2,0));
            imgComp.setPixel(1,0,imgOrig.getPixel(1,1));
            imgComp.setPixel(1,1,imgOrig.getPixel(1,0));
            imgComp.setPixel(2,0,imgOrig.getPixel(0,1));
            imgComp.setPixel(2,1,imgOrig.getPixel(0,0));


            if(imgRot.equals(imgComp))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 2 times should be:\n" + imgComp.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //3X2 twice
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);
            imgComp = new RGBImage(r,c);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //15X5 pixels declaration
            r = 15; c =5;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //15*5 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

            //15X5 pixels declaration
            r = 15; c =1;x =0;
            pixels = new RGBColor[r][c];
            for (int i = 0; i<r;i++)
                for (int j = 0; j<c;j++)
                {
                    pixels[i][j] = new RGBColor(x,x,x);
                    x++;
                }

            //15*1 4 times
            imgOrig = new RGBImage(pixels);
            imgRot = new RGBImage(imgOrig);

            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();
            imgRot.rotateCounterClockwise();

            if(imgRot.equals(imgOrig))
                System.out.println("\tOK!");
            else
            {
                System.out.println("\tError! in rotateCounterClockwise:\nOriginal:\n" +
                        imgOrig.toString() + "\nRotated 4 times should be:\n" + imgOrig.toString() +
                        "\n But got:\n" + imgRot.toString());
            }

        }
        catch (Exception e){
            System.out.println("\tError - *Exception* in rotateCounterClockwise method");
        }
    } //end of rotateCounterClockwiseTest

}//end maman03 tester
