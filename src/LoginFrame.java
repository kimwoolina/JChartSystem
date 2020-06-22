
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame extends javax.swing.JFrame {

    ImageIcon img = new ImageIcon("./src/img/icon.png");
    DB_CONN DBM = new DB_CONN();
    String SignupCheckedID = "";
    boolean SignupCheck = false;
    
    /** Creates new form LoginFrame */
    public LoginFrame() {
        initComponents();
        setTitle("Login");
        setSize(800,600);           //프레임 사이즈 800*600
        setResizable(false);        //프레임 크기변경 제한
        setLocationRelativeTo(null);   //프레임 가운데 위치
        setIconImage(img.getImage());
        txtID.setDocument(new Limit(20)); //글자수 제한
        txtPW.setDocument(new Limit(20));
        txtSignupID.setDocument(new Limit(20));
        txtSignupPW.setDocument(new Limit(20));
        
        try {
            DBM.strURL += "inhatc_db";
            DBM.dbOpen();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }
    
    public boolean loginCheck(String id, String pw) {
        boolean result = false;
        final String SQL = "select count(*) from member where id = ? and pw = password(?)";
        try {
            DBM.DB_pstm = DBM.DB_con.prepareStatement(SQL);
            DBM.DB_pstm.setString(1, id);
            DBM.DB_pstm.setString(2, pw);
            
            DBM.DB_rs = DBM.DB_pstm.executeQuery();
            
            while(DBM.DB_rs.next()){
                switch(DBM.DB_rs.getString("count(*)")){
                    case "0":
                        result = false;
                        break;
                    case "1":
                        result = true;
                        break;
                    default:
                        result = false;
                        break;
                }
            }
            DBM.DB_rs.close();
            DBM.DB_pstm.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
        return result;
    }

    public void login(){
        String id = txtID.getText();
        String pw = txtPW.getText();
        
        if (loginCheck(id, pw)){
            this.hide();
            try {
                DBM.dbClose();
            } catch (Exception e) {
                System.out.println("SQLException : " + e.getMessage());
            }
            
            MainFrame mainform = new MainFrame(this);
            mainform.show();
        } else {
            JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 유효하지 않습니다.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Signup = new javax.swing.JDialog();
        lblSignup = new javax.swing.JLabel();
        lblSignupID = new javax.swing.JLabel();
        txtSignupID = new javax.swing.JTextField();
        btnIDCheck = new javax.swing.JButton();
        lblSignupPW = new javax.swing.JLabel();
        lblSignupPC = new javax.swing.JLabel();
        btnTrySignup = new javax.swing.JButton();
        txtSignupPW = new javax.swing.JPasswordField();
        txtSignupPC = new javax.swing.JPasswordField();
        lblSignupevent = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblPW = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        btnSignin = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        Signup.setBackground(new java.awt.Color(255, 255, 255));
        Signup.setMinimumSize(new java.awt.Dimension(400, 500));
        Signup.setModal(true);
        Signup.setSize(new java.awt.Dimension(400, 500));

        lblSignup.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        lblSignup.setText("Sign Up");
        lblSignup.setMaximumSize(new java.awt.Dimension(90, 30));
        lblSignup.setMinimumSize(new java.awt.Dimension(90, 30));
        lblSignup.setPreferredSize(new java.awt.Dimension(90, 30));

        lblSignupID.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lblSignupID.setText("ID");

        txtSignupID.setColumns(20);
        txtSignupID.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        txtSignupID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSignupIDKeyTyped(evt);
            }
        });

        btnIDCheck.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnIDCheck.setText("ID Check");
        btnIDCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDCheckActionPerformed(evt);
            }
        });

        lblSignupPW.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lblSignupPW.setText("Password");

        lblSignupPC.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lblSignupPC.setText("Password Confirm");

        btnTrySignup.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        btnTrySignup.setText("Sign Up");
        btnTrySignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrySignupActionPerformed(evt);
            }
        });

        txtSignupPW.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        txtSignupPW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSignupPWKeyPressed(evt);
            }
        });

        txtSignupPC.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        txtSignupPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSignupPCKeyPressed(evt);
            }
        });

        lblSignupevent.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout SignupLayout = new javax.swing.GroupLayout(Signup.getContentPane());
        Signup.getContentPane().setLayout(SignupLayout);
        SignupLayout.setHorizontalGroup(
            SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(lblSignup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblSignupID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(btnIDCheck))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtSignupID, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblSignupPW, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtSignupPW, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblSignupPC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblSignupevent, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtSignupPC, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnTrySignup, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SignupLayout.setVerticalGroup(
            SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignupLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblSignup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignupLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblSignupID))
                    .addComponent(btnIDCheck))
                .addGap(6, 6, 6)
                .addComponent(txtSignupID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSignupPW)
                .addGap(6, 6, 6)
                .addComponent(txtSignupPW, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSignupPC)
                    .addComponent(lblSignupevent))
                .addGap(6, 6, 6)
                .addComponent(txtSignupPC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTrySignup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 180));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        lblID.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        lblPW.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblPW.setText("PassWord");

        txtPW.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        txtPW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPWKeyPressed(evt);
            }
        });

        btnSignin.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnSignin.setText("Sign In");
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });
        btnSignin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSigninKeyPressed(evt);
            }
        });

        btnSignup.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnSignup.setText("Sign Up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPW))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(200, 190, 400, 200);

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lblTitle.setText("Login");
        lblTitle.setOpaque(true);
        getContentPane().add(lblTitle);
        lblTitle.setBounds(220, 170, 50, 20);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login_bg.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Login button Click">
    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
        login();
    }//GEN-LAST:event_btnSigninActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtPWKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPWKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_txtPWKeyPressed

    private void btnSigninKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSigninKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            login();
        }
    }//GEN-LAST:event_btnSigninKeyPressed
// </editor-fold> 
    
    /* add member button click */
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        Signup.setTitle("Sign Up");
        Signup.setSize(400, 500);
        Signup.setResizable(false);
        Signup.setLocationRelativeTo(null);
        Signup.setIconImage(img.getImage());
        Signup.show();
        SignupCheck = false;
        txtSignupID.requestFocus();         //포커스 설정
        txtSignupID.setFocusable(true);
        txtSignupID.setText("");            //텍스트박스 리셋
        txtSignupPW.setText("");
        txtSignupPC.setText("");
        lblSignupevent.setText("");
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnIDCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDCheckActionPerformed
        String SignupID = txtSignupID.getText();
        final String SignupSQL = "Select count(*) as signup from member where id = ?";
        if (SignupID.length() == 0) {
            JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "아이디 입력", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            DBM.DB_pstm = DBM.DB_con.prepareStatement(SignupSQL);
            DBM.DB_pstm.setString(1, SignupID);
            DBM.DB_rs = DBM.DB_pstm.executeQuery();
            while(DBM.DB_rs.next()){
                switch(DBM.DB_rs.getString("signup")){
                    case "0":
                        SignupCheck = true;
                        SignupCheckedID = SignupID;
                        JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.", "아이디 사용가능", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "1":
                        SignupCheck = false;
                        JOptionPane.showMessageDialog(null, "중복된 아이디가 존재합니다.", "아이디 중복", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        SignupCheck = false;
                        break;
                }
            }
        DBM.DB_rs.close();
        DBM.DB_pstm.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_btnIDCheckActionPerformed

    private void txtSignupPWKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSignupPWKeyPressed
        lblSignupevent.setText("");
    }//GEN-LAST:event_txtSignupPWKeyPressed

    private void txtSignupPCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSignupPCKeyPressed
        if (txtSignupPW.getText().length() == 0){       //공백
            lblSignupevent.setText("비밀번호를 입력하세요.");
            return;
        }
        if (txtSignupPW.getText().equals(txtSignupPC.getText()+evt.getKeyChar())){
            lblSignupevent.setText("비밀번호 확인 일치");
            return;
        } else {
            lblSignupevent.setText("비밀번호 확인 불일치");
            return;
        }
    }//GEN-LAST:event_txtSignupPCKeyPressed

    private void btnTrySignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrySignupActionPerformed
        int success = 0;
        if (SignupCheck) {
            if (SignupCheckedID.equals(txtSignupID.getText())){
                if (txtSignupPW.getText().equals(txtSignupPC.getText())){
                    if (!txtSignupPW.getText().equals("")){
                        try {
                            final String insertSQL = "insert into member values(?, password(?))";
                            DBM.DB_pstm = DBM.DB_con.prepareStatement(insertSQL);
                            DBM.DB_pstm.setString(1, SignupCheckedID);
                            DBM.DB_pstm.setString(2, txtSignupPW.getText());
            
                            success = DBM.DB_pstm.executeUpdate();
                            DBM.DB_pstm.close();
                        } catch (Exception e) {
                            System.out.println("SQLException : " + e.getMessage());
                        } finally {
                            if (success > 0) {
                                JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
                                Signup.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "회원가입 실패.", "회원가입", JOptionPane.ERROR_MESSAGE);
                            }
                        }  
                    } else {
                        JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "회원가입", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "비밀번호를 확인하세요.", "회원가입", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "아이디 중복확인을 하세요.", "회원가입", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "아이디 중복확인을 하세요.", "회원가입", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTrySignupActionPerformed

    private void txtSignupIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSignupIDKeyTyped
        SignupCheck = false;
    }//GEN-LAST:event_txtSignupIDKeyTyped
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        System.setProperty("jxbrowser.license.key", "Token Key");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Signup;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnIDCheck;
    private javax.swing.JButton btnSignin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnTrySignup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPW;
    private javax.swing.JLabel lblSignup;
    private javax.swing.JLabel lblSignupID;
    private javax.swing.JLabel lblSignupPC;
    private javax.swing.JLabel lblSignupPW;
    private javax.swing.JLabel lblSignupevent;
    private javax.swing.JLabel lblTitle;
    public javax.swing.JTextField txtID;
    public javax.swing.JPasswordField txtPW;
    private javax.swing.JTextField txtSignupID;
    private javax.swing.JPasswordField txtSignupPC;
    private javax.swing.JPasswordField txtSignupPW;
    // End of variables declaration//GEN-END:variables

}
