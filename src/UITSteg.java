import java.awt.Color;
import java.io.*;
import java.util.Random;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class UITSteg {
    
    /**
     * 
     * @param image_path
     * @param secret
     */
	public boolean Encode(String image_path, String secret, String output_path) {
        try{
            int msg_length = secret.length(); //Number characters in Secret string
            int count = 0;
            //Get file name without file extension
            String fileName = "";
            if(output_path.equals("")) {
            	fileName = image_path.substring(0, image_path.lastIndexOf('.'));
                fileName = "encode_" + fileName.substring(fileName.lastIndexOf('\\')+1);
            }
            else {
            	fileName = output_path;
            }
            String fileType = image_path.substring(image_path.lastIndexOf('.')+1);
            
            String hiddenString = padding(msg_length) + MessageToBinary(secret);
            while(hiddenString.length() % 3 != 0) {
            	hiddenString += "0";
            }
            char[] binHidden = hiddenString.toCharArray(); //Convert secret string to binary char array
            int break_point = binHidden.length; //Length secret message in binary
            BufferedImage buff = ImageIO.read(new File(image_path)); //Read image to buffe
            
            for(int x = 0; x < buff.getWidth(); x++) {
                for(int y = 0; y < buff.getHeight(); y++) {
                    int rgb = buff.getRGB(x, y); //Get current RGB value
                    rgb = (binHidden[count++] == '0')?(rgb & 0xFFFEFFFF):(rgb | 0x00010000); //Replace LSB Red value
                    rgb = (binHidden[count++] == '0')?(rgb & 0xFFFFFEFF):(rgb | 0x00000100); //Replace LSB Green value
                    rgb = (binHidden[count++] == '0')?(rgb & 0xFFFFFFFE):(rgb | 0x00000001); //Replace LSB Blue value
                    buff.setRGB(x, y, rgb); //Set new RGB value
                    if(count == break_point) break;
                    
                }
                
                if(count == break_point) break; //Check for breaking the loop when encoding all secret charaters
            }          
            
            if(saveImage(buff, fileType, fileName)) //Saving new image
            {
            	System.out.println("Save file OK!");
            	return true;
            }
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return false;
    }
    
    /**
     * @return LSB Bits that hidden by Encode function
     * @param pixel_rgb RGB pixel color in INT value 
     * @return 
     */
    public String getLSBBits(int pixel_rgb) {
        Color c = new Color(pixel_rgb);
        String result = "";
        String redInB = Integer.toBinaryString(c.getRed());
        String greenInB = Integer.toBinaryString(c.getGreen());
        String blueInB = Integer.toBinaryString(c.getBlue());
        
        result += String.valueOf(redInB.charAt(redInB.length() - 1));
        result += String.valueOf(greenInB.charAt(greenInB.length() - 1));
        result += String.valueOf(blueInB.charAt(blueInB.length() - 1));
        return result;
    }
    
    /**
     * 
     * @param image_path
     * @return 
     */
    public String Decode(String image_path) {
        try {
        	int secret_length = 20;
            int count = 0; //Used to count the number of LSB bit be gotten
            String secret = ""; //The secret in binary string format
            BufferedImage buff = ImageIO.read(new File(image_path));
            
            for(int x = 0; x < buff.getWidth(); x++) {
                for(int y = 0; y < buff.getHeight(); y++) {
                    secret = secret + getLSBBits(buff.getRGB(x, y));
                    count += 3;
                    if(count == 9) {
                    	secret_length = Integer.parseInt(secret.substring(0, 8),2) + 1;
                    }
                    if(count > (secret_length * 8)) break; //Break when read all hidden message
                }
                if(count > secret_length) break;
            }
            secret = secret.substring(0, secret_length * 8); //Get exactly the length of 'Secret'
            System.out.println(secret);
            
            String result = ""; //The secret in plaintext
            
            for(int i = 8; i < secret.length(); i = i + 8) {
                result += BinToChar(secret.substring(i, i+ 8));
            }
            return result;
        }
        catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return "";
    }
    
    /**
     * 
     * @param buff
     * @param file_type
     * @param file_path
     * @return 
     */
    public boolean saveImage(BufferedImage buff, String file_type, String file_path) {
        try {
        	if(file_type.equalsIgnoreCase("PNG")) return ImageIO.write(buff, "PNG",new File(file_path + ".png"));
            return ImageIO.write(buff, "bmp",new File(file_path + ".bmp"));
        }
        catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return false;
    }
    
    /**
     * 
     * @param b
     * @return 
     */
    public String padding(int b) {
        String bin = Integer.toBinaryString(b); 
        while( bin.length() < 8 ) {
            bin = "0" + bin;
        }
        return bin;
    }
    
    /**
     * 
     * @param msg
     * @return 
     */
    public String MessageToBinary(String msg) {
        String result = "";
        
        for(char c : msg.toCharArray()) {
            result += padding(c);
        }
        //Padding secret to its length is common multiple by 3
        while(result.length() % 3 != 0)
        {
            result += "0";
        }
        return result;
    }
    //Construct character from its Binary String
    public char BinToChar(String bin_string) {
        byte r = 0;
        int n = bin_string.length();
        int i = 0;
        int pow = 1;
        for(char c : bin_string.toCharArray()) {
            if(c == '1') {
                i = 0;
                pow = 1;
                while(i < n - 1) {
                    pow *= 2;
                    i++;
                }
                r += pow;
            }
            n--;
        }
        return (char)r;
    }
}
