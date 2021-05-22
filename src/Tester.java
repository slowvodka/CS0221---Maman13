import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tester {
    private static final int MAX_DIFFERENT_ANSWERS = 5, ALIASING_TEST_COUNT = 99, ALIASING_IMAGE_SIZE = 25;
    static final String DATA_FILE = "src/data.txt", ANSWERS_FILE = "src/answers.txt";

    // don't change this
    static final int RGB_COLOR_RANGE = 256; // 0 - 255
    private static int row, col, offset;

    public static void main(String[] args) {
        try {

            if (testAliasing()) {
                System.out.println("Aliasing Test Failed");
                return;
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream oldOutputStream = System.out;
            System.setOut(new PrintStream(outputStream));

            RGBImage[] imagesArr = getImagesArr();
            for (int i = 0; i < imagesArr.length; i++) {
                RGBImage img = imagesArr[i];
                setArgs(i, img);
                runTests(i, img);
                testEquals(img, i % 5 == 0 || i == imagesArr.length - 1 ? img : imagesArr[i + 1]);
            }

            System.setOut(oldOutputStream);
            outputStream.flush();
            outputStream.close();

            String[] outputArr = outputStream.toString().trim().split("--- Testing");
            String[] answersArr = new String(Files.readAllBytes(Paths.get(ANSWERS_FILE))).trim().split("--- Testing");
            compareAnswers(outputArr, answersArr);

        } catch (FileNotFoundException e) {
            System.out.println(" Error - File Not Found ");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static RGBImage[] getImagesArr() throws FileNotFoundException {
        List<List<List<RGBColor>>> data = new ArrayList<>();
        Scanner scan = new Scanner(new BufferedReader(new FileReader(DATA_FILE)));
        List<List<RGBColor>> pixelsList = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.length() <= 1) {
                data.add(pixelsList);
                pixelsList = new ArrayList<>();
                continue;
            }

            String[] pixelStrArr = line.split(" ");
            List<RGBColor> row = new ArrayList<>();
            for (String pixel : pixelStrArr) {
                String[] nums = pixel.split(",");
                row.add(new RGBColor(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), Integer.parseInt(nums[2])));
            }
            pixelsList.add(row);
        }

        RGBImage[] imagesArr = new RGBImage[data.size()];
        for (int k = 0; k < imagesArr.length; k++) {
            RGBColor[][] arr = new RGBColor[data.get(k).size()][data.get(k).get(0).size()];

            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[0].length; j++)
                    arr[i][j] = new RGBColor(data.get(k).get(i).get(j));
            imagesArr[k] = new RGBImage(arr);
        }

        return imagesArr;
    }

    private static boolean testAliasing() {
        // returns true if aliasing was found.

        Random rand = new Random();
        for (int i = 0; i < ALIASING_TEST_COUNT; i++) {
            int rows = rand.nextInt(ALIASING_IMAGE_SIZE) + 1;
            int cols = rand.nextInt(ALIASING_IMAGE_SIZE) + 1;

            RGBImage img = new RGBImage(rows, cols);
            RGBImage imgCopy = new RGBImage(img);
            RGBColor pixel = genPixel();

            int randRow = rand.nextInt(img.getHeight());
            int randCol = rand.nextInt(img.getWidth());
            imgCopy.setPixel(randRow, randCol, pixel);

            if (pixel.equals(img.getPixel(randRow, randCol)))
                return true;

            img.setPixel(randRow, randCol, pixel);
            if (img.getPixel(randRow, randCol) == pixel) // checking if both objs are pointing to the same address
                return true;

            int newVal = (pixel.getBlue() + 1) % RGB_COLOR_RANGE;
            img.getPixel(randRow, randCol).setBlue(newVal);
            if (pixel.getBlue() == newVal)
                return true;

        }
        return false;
    }

    private static RGBColor genPixel() {
        Random rand = new Random();
        return new RGBColor(rand.nextInt(RGB_COLOR_RANGE), rand.nextInt(RGB_COLOR_RANGE), rand.nextInt(RGB_COLOR_RANGE));
    }

    private static void setArgs(int i, RGBImage img) {
        if (i % 12 == 0) {
            row = i * -1;
            col = img.getWidth() - 1;
            offset = 1;
        } else if (i % 11 == 0) {
            row = img.getHeight() - 1;
            col = i % img.getWidth() * -1;
        } else if (i % 10 == 0) {
            row = img.getHeight();
            col = img.getWidth();
            offset = Math.max(row, col);
        } else if (i % 5 == 0) {
            row = img.getHeight() - 1;
            col = img.getWidth() - 1;
            offset = Math.min(row, col);
        } else {
            row = img.getHeight() / 2;
            col = img.getWidth() / 2;
            offset = Math.min(row, col);
        }

        if (i % 3 == 0)
            offset *= -1;
    }

    private static void runTests(int i, RGBImage img) {
        testGetWidthAndHeight(img);
        testGetPixel(img, row, col);
        testSetPixel(img, row, col, new RGBColor(i % RGB_COLOR_RANGE, i * img.getHeight() % RGB_COLOR_RANGE, i * img.getWidth() % RGB_COLOR_RANGE));
        testFlip(img);
        testInvert(img);
        testRotate(img);
        testShift(img, offset);
        testRGBColorArray(img);
    }

    private static void compareAnswers(String[] outputArr, String[] answersArr) {
        Map<String, Integer> badMethods = new HashMap<>();
        int bad = 0, good = 0;
        for (int i = 0; i < Math.min(outputArr.length, answersArr.length); i++) {
            if (bad >= MAX_DIFFERENT_ANSWERS)
                break;
            if (answersArr[i].equals(outputArr[i])) {
                good++;
                continue;
            }
            String key = outputArr[i].split(" ")[1];
            badMethods.put(key, badMethods.getOrDefault(key, 0) + 1);
            System.out.println("---------------#" + (++bad) + "---------------");
            System.out.println("A difference in output was found!");
            System.out.println("Your output: " + outputArr[i] + System.lineSeparator() + "My output: " + answersArr[i]);
        }
        System.out.println("===============");
        System.out.println("We have the same answers around " + 100.0 * good / (bad + good) + " %");
        if (badMethods.size() > 0) {
            System.out.println(System.lineSeparator() + "List of methods and the number of different answers found:");
            for (String k : badMethods.keySet()) {
                System.out.println(k + ":" + badMethods.get(k));
            }
        }
    }

    private static void printCurrentImage(RGBImage img) {
        System.out.println("current image:");
        System.out.println(img);
    }

    private static void testGetWidthAndHeight(RGBImage img) {
        System.out.println("--- Testing getWidth and getHeight ---");
        printCurrentImage(img);
        System.out.println("getWidth returns:" + img.getWidth() + " getHeight returns:" + img.getHeight());
    }

    private static void testGetPixel(RGBImage img, int row, int col) {
        System.out.println("--- Testing getPixel ---");
        printCurrentImage(img);
        System.out.println("getPixel(" + row + ", " + col + ")" + " returns:" + img.getPixel(row, col));
    }

    private static void testSetPixel(RGBImage img, int row, int col, RGBColor pixel) {
        System.out.println("--- Testing setPixel ---");
        printCurrentImage(img);
        System.out.println("setPixel(" + row + ", " + col + "," + pixel + ")" + " new image:");
        img.setPixel(row, col, pixel);
        System.out.println(img);
    }

    private static void testEquals(RGBImage img, RGBImage other) {
        System.out.println("--- Testing equals ---");
        printCurrentImage(img);
        System.out.println("other image:");
        System.out.println(other);
        System.out.println("equals returns:" + img.equals(other));
    }

    private static void testFlip(RGBImage img) {
        System.out.println("--- Testing flip methods ---");
        printCurrentImage(img);
        System.out.println("flipHorizontal:");
        img.flipHorizontal();
        System.out.println(img);
        System.out.println("flipVertical:");
        img.flipVertical();
        System.out.println(img);
    }

    private static void testInvert(RGBImage img) {
        System.out.println("--- Testing invertColors ---");
        printCurrentImage(img);
        img.invertColors();
        System.out.println("new image:");
        System.out.println(img);
    }

    private static void testRotate(RGBImage img) {
        System.out.println("--- Testing rotate methods ---");
        printCurrentImage(img);
        System.out.println("rotateClockwise:");
        img.rotateClockwise();
        System.out.println(img);
        System.out.println("rotateCounterClockwise:");
        img.rotateCounterClockwise();
        System.out.println(img);
    }

    private static void testShift(RGBImage img, int offset) {
        System.out.println("--- Testing shift methods ---");
        printCurrentImage(img);
        System.out.println("shiftCol(" + offset + "):");
        img.shiftCol(offset);
        System.out.println(img);
        System.out.println("shiftRow(" + offset + "):");
        img.shiftRow(offset);
        System.out.println(img);
    }

    private static void testRGBColorArray(RGBImage img) {
        System.out.println("--- Testing toRGBColorArray ---");
        printCurrentImage(img);
        System.out.println("toRGBColorArray returns:");
        System.out.println(Arrays.deepToString(img.toRGBColorArray()));
    }

}
