package studentgradebook;

import com.alee.laf.WebLookAndFeel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Michael DeMarco, Jordan Van Den Bruel, and Rajan Maghera
 */

public class StudentGradebook implements java.io.Serializable {
    public static GradebookFrame gradebook;
    private static ClassFrame classFrame;
    private static PerformanceFrame performanceFrame;
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static int coursesNum;
    public static String[][] courseArray;
    private static AddCourse addCourse;
    private static AddTest addTest;
    private static ClassView classView;
    public Course courseChoice;
    
    public static void updateArray() {
        
        courseArray = new String[courses.size()][3];
        for (int i = 0; i < StudentGradebook.courses.size(); i ++) {
         System.out.println(courses.size());
         courseArray[i][0] = StudentGradebook.courses.get(i).getCourseName();
         System.out.print(courseArray[i][0] + " Array ");
         courseArray[i][1] = StudentGradebook.courses.get(i).getLocation();
         System.out.print(courseArray[i][1] + " ");         
         courseArray[i][2] = StudentGradebook.courses.get(i).getTeacher();
         System.out.println(courseArray[i][2] + " ");         
        }
    }
     
    public StudentGradebook() {
        gradebook = new GradebookFrame();
        classFrame = new ClassFrame();
        performanceFrame = new PerformanceFrame();
        addCourse = new AddCourse();
        addTest = new AddTest();
        classView = new ClassView();
        gradebook.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel ( new WebLookAndFeel () );
        StudentGradebook begin = new StudentGradebook();
        System.out.println(courses.size());
        
        //gradebookFrame --> classFrame
        gradebook.classButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //gradebookFrame --> performanceFrame
        gradebook.performanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performanceFrame.setVisible(true);
                performanceFrame.toFront();
            }
        });

        classFrame.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
            }
        });
        //back button on performanceFrame --> gradebookFrame
        performanceFrame.jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradebook.setVisible(true);
                gradebook.toFront();
            }
        });
        classFrame.addClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourse.setVisible(true);
                gradebook.toFront();
            }
        });
        //cancel button on addCourse --> classFrame
        addCourse.cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        addCourse.addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Course c = new Course(addCourse.nameField.getText(), addCourse.locationField.getText(), addCourse.teacherField.getText());
                System.out.println(c.getCourseName());
                saveCourse(c);
                classFrame.setVisible(true);
                classFrame.toFront();
                addCourse.nameField.setText("");
                addCourse.locationField.setText("");
                addCourse.teacherField.setText("");
                addCourse.setVisible(false);
                updateArray();
                classFrame.refreshTable.doClick();
            }
        });
        //backButton in ClassView --> ClassFrame
        classView.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classFrame.setVisible(true);
                classFrame.toFront();
            }
        });
        //viewClass button in classFrame --> ClassViewFrame
        classFrame.viewClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classView.setVisible(true);
                classView.toFront();
                findIndexbyName(courses, (String) classFrame.classTable.getValueAt(classFrame.classTable.getSelectedRow(), 0));
                classFrame.setVisible(false);
            }
        });
        //addTest button in viewClass --> addTest
        classView.addTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTest.setVisible(true);
                addTest.toFront();
                classView.setVisible(false);
            }
        });        
        //viewClass button in classFrame --> ClassViewFrame
        addTest.backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classView.setVisible(true);
                classView.toFront();
                addTest.nameField.setText("");
                addTest.dateField.setText("");
                addTest.scoreField.setText("");
                addTest.weightField.setText("");
                addTest.setVisible(false);
            }
        });        
        classFrame.importClassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                final JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Student Gradebook Files", "ser", "serial");
                fc.setFileFilter(filter);
                
                int returnVal = fc.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        importCourse(file);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StudentGradebook.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Opening: " + file.getName() + ".");
                } else {
                    System.out.println("Open command cancelled by user.");
                }
                classFrame.refreshTable.doClick();
            }
            });
    }
    
    public static void importCourse(File file) throws ClassNotFoundException {
        Course c = null;
        try {
         FileInputStream fileIn = new FileInputStream(file);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         c = (Course) in.readObject();
         System.out.println(c + "THIS WAS IMPORTED!");
         courses.add(c);
         in.close();
         fileIn.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
    public static void saveCourse(Course course) {
        
        System.out.print(courses.indexOf(course));
        
        String filename = course.getCourseName() + ".ser";
        String workingDir = System.getProperty("user.dir");
        String filepath = workingDir + File.separator + "\\src\\studentgradebook\\tmp\\" + filename;
        //String filepath = "C:\\Users\\mdema\\Documents\\Github\\studentgradebook\\studentGradebook\\src\\studentgradebook\\tmp\\" + course.getCourseName() + ".ser";
        System.out.println(filepath);
        
        File tmp = new File(filepath);
        boolean exists = tmp.exists();
        
        if (exists) {
            courses.remove(findIndexbyName(courses, course));
            tmp.delete();
            try {
                  FileOutputStream fileOut = new FileOutputStream(filepath);
                  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                  objectOut.writeObject(course);
                  objectOut.close();
                  System.out.println("The object  was succesfully written to a file.");
              } catch (IOException ex) {
                      ex.printStackTrace();
                    }
        }
        
        else {
            try {
                  FileOutputStream fileOut = new FileOutputStream(filepath);
                  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                  objectOut.writeObject(course);
                  objectOut.close();
                  System.out.println("The object  was succesfully written to a file.");
              } catch (IOException ex) {
                      ex.printStackTrace();
              }
        }
    }
    
    public static double studentAverage() {
        
        double sum = 0.0;
        for (int i = 0; i < courses.size(); i++) {
            sum += courses.get(i).classAverage();
        }
        return sum / courses.size();
    }
    
    public static int findIndexbyName(ArrayList<Course> courses, Course c) {
        for (int i = 0; i < courses.size(); i++) {
            if (c.getCourseName().equals(courses.get(i).getCourseName())) {
                return i;
            }
        }
        return -1;
    }
    
    public static int findIndexbyName(ArrayList<Course> courses, String courseName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courseName.equals(courses.get(i).getCourseName())) {
                return i;
            }
        }
        return -1;
    }
 }
