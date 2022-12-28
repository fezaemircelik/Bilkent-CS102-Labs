import java.awt.*;

import javax.swing.*;;

public class CafalogGUI {
    
    public static void main(String[] args) {
        
        Catalog catalog = new Catalog();
        
        //frame 
        int WIDTH = 600;
        int HEIGHT = 600;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(WIDTH,HEIGHT);
        frame.setVisible(true);
        frame.setResizable(false);

        //**blue part */
        JPanel bluePanel = new JPanel();
        bluePanel.setBounds(0,0,400,400);
        bluePanel.setBackground(Color.blue);
        bluePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
            //"code" label
            JLabel code = new JLabel();
            code.setText("Code:");
            bluePanel.add(code);

            //Product code
            JTextField productCode = new JTextField();
            productCode.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getProductCode()));
            productCode.setEditable(false);
            productCode.setPreferredSize(new Dimension(350,40));
            bluePanel.add(productCode);

            //"price" label
            JLabel price = new JLabel();
            price.setText("Price: ");
            bluePanel.add(price);

            //Product Price
            JTextField productPrice = new JTextField();
            productPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getPrice()));
            productPrice.setSize(500,500);
            productPrice.setPreferredSize(new Dimension(350,40));
            bluePanel.add(productPrice);
            productPrice.setEditable(false);

            //******************************************************** */

            //"description" label
            JLabel description = new JLabel();
            description.setText("DESCRIPTION");
            description.setLocation(0, 300);
            description.setPreferredSize(new Dimension(400,40));
            bluePanel.add(description);

            //Product Description
            JTextArea productDescription = new JTextArea();
            productDescription.setText((String)catalog.getProductByPosition(catalog.index).getEngDescription());
            bluePanel.add(productDescription);
            productDescription.setEditable(false);

        //**red part */
        JPanel redPanel = new JPanel();
        redPanel.setBounds(400,0,200,400);
        redPanel.setBackground(Color.red);
        redPanel.setLayout(new BoxLayout(redPanel, BoxLayout.Y_AXIS));

            //Language Preference
            JRadioButton english = new JRadioButton("English");
            english.setBounds(0,0,100,100);
            redPanel.add(english);
            english.setSelected(true);

            JRadioButton turkish = new JRadioButton("Türkçe");
            turkish.setBounds(0,100,100,100);
            redPanel.add(turkish);

                //language 
                english.addActionListener(e ->{
                    catalog.lang = 0;
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getEngDescription());
                    turkish.setSelected(false);
                });
                turkish.addActionListener(e ->{
                    catalog.lang = 1;
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getTurkDescription());
                    english.setSelected(false);
                });

            //Hide Price Button
            JCheckBox hidePrice = new JCheckBox("HIDE PRICE");
            hidePrice.setBounds(0,200,100,100);
            redPanel.add(hidePrice);

                //hide or not
                hidePrice.addActionListener(e ->{
                    catalog.hide = !catalog.hide;
                    if (catalog.hide){
                        price.setVisible(false);
                        productPrice.setVisible(false);
                    }
                    else {
                        price.setVisible(true);
                        productPrice.setVisible(true);
                    }
                });

        //**green part */
        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(0,400,600,200);
        greenPanel.setBackground(Color.green);
        greenPanel.setLayout(new FlowLayout());

            // "left" button
            JButton left = new JButton();
            left.setText("<<<");
            left.setBounds(0,0,100,100);
            greenPanel.add(left);
            
            left.addActionListener(e ->{
                catalog.index--;
                if (catalog.index < 0){
                    catalog.index = catalog.getCatalogSize() - 1;
                }
                if (catalog.lang == 0){
                    productCode.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getProductCode()));
                    productPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getPrice()));
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getEngDescription());
                }
                if (catalog.lang == 1){
                    productCode.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getProductCode()));
                    productPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getPrice()));
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getTurkDescription());
                }
                
            });
            
            // "right" button
            JButton right = new JButton();
            right.setText(">>>");
            right.setBounds(0,0,100,100);
            greenPanel.add(right);

            right.addActionListener(e ->{
                catalog.index++;
                if(catalog.index == catalog.getCatalogSize()){
                    catalog.index = 0;
                }
                if (catalog.lang == 0){
                    productCode.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getProductCode()));
                    productPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getPrice()));
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getEngDescription());
                }
                if (catalog.lang == 1){
                    productCode.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getProductCode()));
                    productPrice.setText(String.valueOf(catalog.getProductByPosition(catalog.index).getPrice()));
                    productDescription.setText((String)catalog.getProductByPosition(catalog.index).getTurkDescription());
                }
            });

        //adding to the frame
        frame.add(bluePanel);
        frame.add(redPanel);
        frame.add(greenPanel);

    }
}
