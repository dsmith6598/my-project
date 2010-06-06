(import '(javax.swing JFrame JPanel JButton))
(def button (JButton. "Click Me!"))
(def panel (doto (JPanel.)
             (.add button)))
(def frame (doto (JFrame. "Hello Frame")
             (.setSize 200 200)
             (.setContentPane panel)
             (.setVisible true)))

(import 'javax.swing.JOptionPane)
(defn say-hello []
  (JOptionPane/showMessageDialog
    nil "Hello, World!" "Greeting"
    JOptionPane/INFORMATION_MESSAGE))

(import 'java.awt.event.ActionListener)
(def act (proxy [ActionListener] []
           (actionPerformed [event] (say-hello))))

(.addActionListener button act)


;; next

(import '(javax.swing JFrame JLabel JTextField JButton)
        '(java.awt.event ActionListener)
        '(java.awt GridLayout))
(defn celsius []
  (let [frame (JFrame. "Celsius Converter")
        temp-text (JTextField.)
        celsius-label (JLabel. "Celsius")
        convert-button (JButton. "Convert")
        fahrenheit-label (JLabel. "Fahrenheit")]
    (.addActionListener convert-button
      (proxy [ActionListener] []
        (actionPerformed [evt]
          (let [c (Double/parseDouble (.getText temp-text))]
            (.setText fahrenheit-label
               (str (+ 32 (* 1.8 c)) " Fahrenheit"))))))

			 
    (doto frame
      (.setLayout (GridLayout. 2 2 3 3))
      (.add temp-text)
      (.add celsius-label)
      (.add convert-button)
      (.add fahrenheit-label)
      (.setSize 300 80)
      (.setVisible true))))

(celsius)


;;;  next

