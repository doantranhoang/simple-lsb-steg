import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UITStegGui extends javax.swing.JFrame {

    private static String sourceFilePath = "";
    private static String fileName = "";
    private UITSteg s = new UITSteg();
    /**
     * Creates new form UITStegGui
     */
    public UITStegGui() {
        initComponents();
        jLabel4.setSize(100,100);
        Border jlbBorder = BorderFactory.createLineBorder(Color.CYAN, 2);
        jLabel4.setBorder(jlbBorder);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UIT Steganography");

        jLabel1.setText("Source Image");

        jLabel2.setText("No file selected");

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Click to change Source Image");
        jLabel4.setToolTipText("Your source image would be display here");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jButton1.setLabel("Encode");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setActionCommand("jBtDecode");
        jButton2.setLabel("Decode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Your secret");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("jBtEncode");

        pack();
    }// </editor-fold>                        
    
    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setDialogTitle("Select Image To Encode/Decode");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setAcceptAllFileFilterUsed(false);
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        
        fc.setFileFilter(imageFilter);
        //In response to a button click:
        
        fc.addChoosableFileFilter(imageFilter);
        int returnVal = fc.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            sourceFilePath = fc.getSelectedFile().getAbsolutePath();
            if(!fc.getSelectedFile().isFile()) {
                showMessage("No file selected", "Warning");
                return;
            }
            fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf('\\') + 1);
            jLabel2.setText(fileName);
            try {
                BufferedImage buffImage = ImageIO.read(new File(sourceFilePath));
                if(buffImage.getWidth() > 300)
                {
                    buffImage = resize(buffImage, 300, buffImage.getHeight()*200/buffImage.getWidth());
                }
                jLabel4.setIcon(new ImageIcon(buffImage));
                jLabel4.setText("");
                jLabel4.updateUI();
            }
            catch(Exception e) {
                showMessage(e.getMessage(), "ERROR!!!");
            }
            
        }
    }                                    
    //Callback for Encode button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	
    	if(sourceFilePath.equals("")) {
    		showMessage("No image file selected", "Warning!!!");
    		return;
    	}
    	//Get secret string that input by user and checking if it's empty
        String secret = jTextField1.getText().trim();
        if(secret.equals("")) {
        	showMessage("Please input something to hide", "Warning");
        	return;
        }
        //Determine the maximum characters for hiding base on image width & height
        try {
        	BufferedImage bi = ImageIO.read(new File(sourceFilePath));
        	int maxChars = getMaxHiddenChars(bi.getWidth(), bi.getHeight());
        	if(secret.length() > maxChars) {
        		showMessage("The maximum character to hide is " + maxChars, "Warning!!!");
        		return;
        	}
        	
        }
        catch(IOException ioe) {
        	showMessage(ioe.getMessage(), "Error");
        }
        //Select file to save
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
         
        int userSelection = fileChooser.showSaveDialog(this);
        String destFilePath = "";
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            destFilePath = fileToSave.getAbsolutePath();
        }
        //Using Encode method to hide secret into image
        if(s.Encode(sourceFilePath, secret, destFilePath)) {
        	jTextField1.setText("");
        	showMessage("The secret was encoding successfully", "Information");
        }
        
    }                                        
    //Callback for Decode Button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {      
    	jTextField1.setText("");
        // TODO add your handling code here:
        if(sourceFilePath.equals("")) {
            showMessage("No File Selected", "Warning!!!");
            return;
        }

        String secret = s.Decode(sourceFilePath);
        jTextField1.setText(secret); //Show secret
        
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UITStegGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UITStegGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UITStegGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UITStegGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UITStegGui().setVisible(true);
            }
        });
    }
    
    //______________________CUSTOM METHODS____________________
    /**
     * Show a message popup: warning, errors,...
     * @param	String	message
     * @param	String title
     * @return	void
     */
    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Resize an image specify by width, height
     * @param image
     * @param width
     * @param height
     * @return	BufferedImage
     */
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    /**
     * Determine the maximum characters could be hidden into image (width, height)
     * @param width
     * @param height
     * @return
     */
    public int getMaxHiddenChars(int width, int height) {
    	
    	return ((width * height * 3) / 8) - 1;
    }
    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
