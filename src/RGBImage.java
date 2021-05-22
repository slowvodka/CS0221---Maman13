public class RGBImage {

    //declarations
    private RGBColor[][] _image;

    //constructors

    /**
     * constructor - fills all pixels with black
     * @param rows - int - number of rows in image
     * @param cols - int - number of columns in image
     */
    public RGBImage(int rows, int cols){
        _image = new RGBColor[rows][cols];
        RGBColor blackPix = new RGBColor(); // created a black pix to save creation each time
        for (int i=0; i<rows ; i++) {
            for (int j = 0; j < cols; j++) {
                this.setPixel(i,j, blackPix);
            }
        }
    } //end of default constructor

    /**
     * constructor - get pixels array and makes an RGBimage object out of it
     * @param pixels - RGBimage - an image object
     */
    public RGBImage(RGBColor[][] pixels){
        int rows = pixels.length;
        int cols = pixels[0].length;
        _image = new RGBColor[rows][cols];
        for (int i=0; i<rows ; i++) {
            for (int j = 0; j < cols; j++) {
                this.setPixel(i,j, pixels[i][j]);
            }
        }
    } //end of constructor from RGBColor array

    /**
     * Copy constructor - copy RGBimage object to different object
     * @param other - RGBimage object - the one to be copied
     */
    public RGBImage(RGBImage other){
        int rows = other.getHeight();
        int cols = other.getWidth();
        _image = new RGBColor[rows][cols];
        for (int i=0; i<rows ; i++) {
            for (int j = 0; j < cols; j++) {
                _image[i][j] = new RGBColor(other.getPixel(i,j));
            }
        }
    } //end of copy constructor

    //methods

    /**
     * method to determine the Height of the image
     * @return - int - height of the image (number of rows in pixel field)
     */
    public int getHeight(){
        return _image.length;
    } //// end of getHeight

    /**
     * method to determine the Width of the image
     * @return - int - width of the image (number of columns in pixel field)
     */
    public int getWidth(){
        return _image[0].length;
    } //// end of getWidth

    /**
     * method to extract a pixel by location, if the location does not exists returns
     * a black pixel
     * @param row - int - row number in the image
     * @param col - int - column number in the image
     * @return - RGBcolor - the pixel in the row,col position
     */
    public RGBColor getPixel (int row, int col){
        RGBColor pixel = new RGBColor();
        int rows = this.getHeight();
        int cols = this.getWidth();
        if (row >=0 && col >= 0 && row < rows && col < cols)
            pixel =  new RGBColor (_image[row][col]);
        return pixel;

    } // end of getPixel

    /**
     * sets a new pixel in specific location
     * if location does not exist - does nothing
     * @param row - int - row number in the image
     * @param col - int - column number in the image
     * @param pixel - RGBcolor - the pixel to set
     */
    public void setPixel (int row, int col, RGBColor pixel){
        int rows = this.getHeight();
        int cols = this.getWidth();
        if (row >=0 && col >= 0 && row < rows && col < cols)
            _image[row][col] = new RGBColor(pixel);
    } // end of setPixel

    /**
     * a method to compare between to images
     * @param other - RBGimage - the other image to compare to
     * @return - boolean - true if equal, false if not
     */
    public boolean equals (RGBImage other){
        boolean eq = true;
        if (other != null) {
            int rows = this.getHeight();
            int cols = this.getWidth();
            if (rows == other.getHeight() && cols == other.getWidth()) {
                for (int i = 0; i < rows && eq; i++) {
                    for (int j = 0; j < cols && eq; j++) {
                        if (!this.getPixel(i,j).equals(other.getPixel(i,j)))
                            eq = false;
                    }//column loop
                }//row loop
            }
            else  eq = false;
        }
        else eq = false;
        return eq;
    } // end of equals

    /**
     * method flips the image horizontally - all columns are inverted
     * example
     * original image:
     * (0,0,0) (1,1,1)
     * (0,0,0) (0,0,0)
     * after flip horizontal
     * (1,1,1) (0,0,0)
     * (0,0,0) (0,0,0)
     */
    public void flipHorizontal(){
        int rows = this.getHeight();
        int cols = this.getWidth();
        RGBImage copy = new RGBImage(this);
        for (int i = 0 ; i < rows ; i++)
            for (int j = 0 ; j < cols ; j++)
                this.setPixel(i, cols-1-j,copy.getPixel(i,j));
    } // end of flipHorizontal

    /**
     * method flips the image vertically - all rows are inverted
     * example
     * original image:
     * (0,0,0) (1,1,1)
     * (0,0,0) (0,0,0)
     * after flip vertically
     * (0,0,0) (0,0,0)
     * (0,0,0) (1,1,1)
     */
    public void flipVertical(){
        int rows = this.getHeight();
        int cols = this.getWidth();
        RGBImage copy = new RGBImage(this);
        for (int i = 0 ; i < rows ; i++)
            for (int j = 0 ; j < cols ; j++)
                this.setPixel(i, j,copy.getPixel(rows-i-1,j));
    } // end of flipVertical

    /**
     * method inverts the color of each pixel
     * each color in the RGB is converted to the complementory to 255
     * example  (0,0,0) inverted to (255,255,255)
     * example2 (1,1,1) inverted to (254,254,254)
     * example3 (1,1,1) (0,0,0) inverted to (254,254,254) (255,255,255)
     */
    public void invertColors(){
        int rows = this.getHeight();
        int cols = this.getWidth();
        for (int i = 0 ; i < rows ; i++)
            for (int j = 0 ; j < cols ; j++) {
                RGBColor inverted = new RGBColor(this.getPixel(i,j));
                inverted.invert();
                this.setPixel(i, j, inverted);
            }
    } // end of invertColors

    /**
     * rotates the image clockwise (90 deg)
     * image dimensions can be changed in the process
     */
    public void rotateClockwise(){
        int Rows = this.getHeight();
        int Cols = this.getWidth();
        RGBImage rotatedCw = new RGBImage(Cols,Rows); //create clockwise image
        for (int i =0; i<Rows;i++)
            for (int j =0; j<Cols;j++)
                rotatedCw.setPixel(j,Rows-i-1,this.getPixel(i,j));

        this._image = rotatedCw.toRGBColorArray();
    }// end of rotateClockwise

    /**
     * rotates the image Counter clockwise (-90 deg)
     * image dimensions can be changed in the process
     */
    public void rotateCounterClockwise(){
        int Rows = this.getHeight();
        int Cols = this.getWidth();
        RGBImage rotatedCCw = new RGBImage(Cols,Rows); //create clockwise image
        for (int i =0; i<Rows;i++)
            for (int j =0; j<Cols;j++)
                rotatedCCw.setPixel(j,i,this.getPixel(i,j));
        rotatedCCw.flipVertical();
        this._image = rotatedCCw.toRGBColorArray();

    }// end of rotateCounterClockwise

    /**
     * this method offsets columns by offset parameter
     * if offset > number of columns - nothing happens
     * if offset = number of columns - image become black image
     * if offset > 0 and smaller than columns will offset picture by given parameters
     * @param offset - int - positive or negative
     */
    public void shiftCol (int offset){
        int rows = this.getHeight();
        int cols = this.getWidth();

        //only needs to do something if the offset is +- num of columns
        if (offset !=0 && Math.abs(offset) <= cols)
        {
            //need to offset so first create black array
            RGBImage off = new RGBImage(rows,cols);
            //if offsetting right
            if (offset > 0)
            {
                for (int i=0; i < rows; i++)
                    for (int j=0; j < cols-offset; j++)
                        off.setPixel(i,j+offset,this.getPixel(i,j));
            }
            else //if offset < 0
            {
                offset = Math.abs(offset);
                for (int i=0; i < rows; i++)
                    for (int j=0; j < cols-offset; j++)
                        off.setPixel(i,j,this.getPixel(i,j+offset));
            }
            this._image = off.toRGBColorArray();
        }
    } //end of shiftCol

    /**
     * this method offsets rows by offset parameter
     * if offset > number of rows - nothing happens
     * if offset = number of rows - image become black image
     * if offset > 0 and smaller than rows will offset picture by given parameters
     * @param offset - int - positive or negative
     **/
    public void shiftRow (int offset) {
        int rows = this.getHeight();
        int cols = this.getWidth();

        //only needs to do something if the offset is +- num of rows
        if (offset != 0 && Math.abs(offset) <= rows) {
            //need to offset so first create black array
            RGBImage off = new RGBImage(rows, cols);
            //if offsetting down
            if (offset > 0) {
                for (int i = 0; i < rows  - offset + 1 ; i++)
                    for (int j = 0; j < cols; j++)
                        off.setPixel(i + offset, j, this.getPixel(i, j));
            } else //if offset < 0
            {
                offset = Math.abs(offset);
                for (int i = 0; i < rows - offset; i++)
                    for (int j = 0; j < cols; j++)
                        off.setPixel(i, j, this.getPixel(i+offset, j));
            }
            this._image = off.toRGBColorArray();
        }
    }//end of shiftRow


    /**
     * method converts all pixeles to gray double reprasantation
     * @return double[][] array
     */
    public double[][] toGrayscaleArray(){
        int rows = this.getHeight();
        int cols = this.getWidth();
        double[][] myGrayImgArr = new double[rows][cols];
        for (int i =0 ; i < rows ; i++)
            for (int j =0 ; j < cols ; j++)
                myGrayImgArr[i][j] = this.getPixel(i,j).convertToGrayscale();
        return myGrayImgArr;
    }// end of toGrayscaleArray

    /**
     * method convert the image to String
     * every image represented as a table of RGBcolor pixels
     * @return String - a string that represents the image as a table.
     */
    public String toString(){
        String s = "";
        int rows = this.getHeight();
        int cols = this.getWidth();
        for (int i=0 ; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                s = s + this.getPixel(i, j).toString();
                if (j<cols-1)
                    s = s+ " ";
            }
            s = s + "\n";
        }
        return s;
    }// end of toString

    /**
     * method converts image to RGBcolor array
     * @return RBGColor array - image as a color array
     */
    public RGBColor[][] toRGBColorArray(){
        int rows = this.getHeight();
        int cols = this.getWidth();
        RGBColor[][] myImageArr = new RGBColor[rows][cols];
        for (int i=0 ; i < rows ; i++)
            for (int j=0 ; j < cols ; j++)
                myImageArr[i][j] = new RGBColor(this.getPixel(i,j));
        return myImageArr;
    }// end of toRGBColorArray


}//end of RGBImage class
