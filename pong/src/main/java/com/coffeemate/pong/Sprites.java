import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Space_Game
 * Created: Jun 8, 2019
 * TODO: Implement scaling later
 */

/**
 * @author coffeemate
 */

/**
 * I'm only really making this class for txt b/c I'm not entirely
 * sure if the fonts that I use will transfer to other computers...
 * 
 * UPDATE: Feeekk that took way to long to calculate the postions of the letters
 * It took so long b/c the letters aren't evenly sized (I think)
 * 
*/
public class Sprites {
    //Will hold image of letters
    BufferedImage[] alphaList = new BufferedImage[26];

    public Sprites() {
        try {
            BufferedImage sheet =  ImageIO.read(getClass().getClassLoader().getResource("textSheet.png"));

            //Gets first row of letters to put into array
            for(int i  = 0; i < 13; i++) {
                if(i < 8) {
                    alphaList[i] = sheet.getSubimage(37 + (71*i), 9, 64, 72);
                } else {
                    alphaList[i] = sheet.getSubimage(86 + (64*i), 9, 64, 72);
                }
            }

            //Gets second row of letters to put into array
            for(int i = 13, j = 0; i < 26; i++, j++) {
                alphaList[i] = sheet.getSubimage(23 + (71*j), 99, 71, 72);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    /**
     * I recommend you only type things that are at max 9chars b/c then your text is off screen  
     * Optimatlly things should be ~5chars.
     * Additionally if an unknown char is used then it will default to printing out to 'z'
     * 
     * @param str the string to be printed out
     * @param x the x-coord of text based off of left corner
     * @param y the y-coord of text based off of left corner
     * @param g2d Graphics2D
     */
    public void printText(String str,int x, int y, Graphics2D g2d) {
        BufferedImage[] finalStr = new BufferedImage[str.length()];

        for(int i = 0; i < str.length(); i++) {
            //System.out.println(Character.toLowerCase(str.charAt(i)));
            switch(Character.toLowerCase(str.charAt(i))) {
                case 'a': 
                    finalStr[i] = alphaList[0];
                    break;
                case 'b':
                    finalStr[i] = alphaList[1];
                    break;
                case 'c':
                    finalStr[i] = alphaList[2];
                    break;
                case 'd':
                    finalStr[i] = alphaList[3];
                    break;
                case 'e':
                    finalStr[i] = alphaList[4];
                    break;
                case 'f':
                    finalStr[i] = alphaList[5];
                    break;
                case 'g':
                    finalStr[i] = alphaList[6];
                    break;
                case 'h':
                    finalStr[i] = alphaList[7];
                    break;
                case 'i':
                    finalStr[i] = alphaList[8];
                    break;
                case 'j':
                    finalStr[i] = alphaList[9];
                    break;
                case 'k':
                    finalStr[i] = alphaList[10];
                    break;
                case 'l':
                    finalStr[i] = alphaList[11];
                    break;
                case 'm':
                    finalStr[i] = alphaList[12];
                    break;
                case 'n':
                    finalStr[i] = alphaList[13];
                    break;
                case 'o':
                    finalStr[i] = alphaList[14];
                    break;
                case 'p':
                    finalStr[i] = alphaList[15];
                    break;
                case 'q':
                    finalStr[i] = alphaList[16];
                    break;
                case 'r':
                    finalStr[i] = alphaList[17];
                    break;
                case 's':
                    finalStr[i] = alphaList[18];
                    break;
                case 't':
                    finalStr[i] = alphaList[19];
                    break;
                case 'u':
                    finalStr[i] = alphaList[20];
                    break;
                case 'v':
                    finalStr[i] = alphaList[21];
                    break;
                case 'w':
                    finalStr[i] = alphaList[22];
                    break;
                case 'x':
                    finalStr[i] = alphaList[23];
                    break;
                case 'y':
                    finalStr[i] = alphaList[24];
                    break;
                case 'z': 
                    finalStr[i] = alphaList[25];
                    break;
                default:
                    finalStr[i] = alphaList[25];
            }
        }

        for(int i = 0; i < finalStr.length; i++) {
            g2d.drawImage(finalStr[i], null, x + 66*i, y);
        }

    }
}