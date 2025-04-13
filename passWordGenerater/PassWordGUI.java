


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PassWordGUI extends JFrame {
    public PasswordGenerater passwordGenerater;
    public PassWordGUI(){
        super("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerater = new PasswordGenerater();
        addGuiComponents();
    }
    private void addGuiComponents() {
        // add text in GUI
       JLabel titLabel = new JLabel("Password Generator");
       titLabel.setFont(new Font("Dialog",Font.BOLD,32));
       titLabel.setHorizontalAlignment(SwingConstants.CENTER);
       titLabel.setBounds(0,10,540,39);
       add(titLabel);

       // blank space for text user input
       JTextArea passText = new JTextArea();
       passText.setEditable(false);
       passText.setFont(new Font("dialog" , Font.BOLD,32));

       // text area border line
       JScrollPane scrollp = new JScrollPane(passText);
       scrollp.setBounds(25,97,479,70);
       scrollp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       add(scrollp);

       // creating password length
       JLabel passwordLength = new JLabel("PassWord Length");
       passwordLength.setFont(new Font("Dialog", Font.BOLD,32));
       passwordLength.setBounds(25,215,272,39);
       add(passwordLength);

       // blank text box for required password creation;
       JTextArea textInputlength = new JTextArea();
       textInputlength.setFont(new Font("Dialog",Font.PLAIN,32));
       textInputlength.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       textInputlength.setBounds(310,215,192,39);
       add(textInputlength);

       // for buttons
       JToggleButton upperCasebutton = new JToggleButton("UpperCase");
       upperCasebutton.setFont(new Font("Dialog",Font.PLAIN,26));
       upperCasebutton.setBounds(25,302,225 ,56);
       add(upperCasebutton);

       JToggleButton lowerCasebutton = new JToggleButton("LowerCase");
       lowerCasebutton.setFont(new Font("Dialog",Font.PLAIN,26));
       lowerCasebutton.setBounds(282,302,225 ,56);
       add(lowerCasebutton);

       JToggleButton number = new JToggleButton("Number");
       number.setFont(new Font("Dialog",Font.PLAIN,26));
       number.setBounds(25,373,225 ,56);
       add(number);

       JToggleButton symbol = new JToggleButton("Symbols");
       symbol.setFont(new Font("Dialog",Font.PLAIN,26));
       symbol.setBounds(282,373,225 ,56);
       add(symbol);

       // creating for generate buttom
       JButton generate = new JButton("Generate");
       generate.setFont(new Font("Dialog",Font.PLAIN,32));
       generate.setBounds(155,477,222,41);
       generate.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(textInputlength.getText().length() <= 0) return;
               boolean selected =  lowerCasebutton.isSelected() ||
                       upperCasebutton.isSelected() ||
                       number.isSelected() ||
                       symbol.isSelected();
               int passlength = Integer.parseInt(textInputlength.getText());
               if(selected) {
                   String Password = passwordGenerater.generaterPassword(passlength,upperCasebutton.isSelected(),
                           lowerCasebutton.isSelected(),number.isSelected(),symbol.isSelected());
                   passText.setText(Password);
                }
           }
       });
       add(generate);
    }


        
            
    

}