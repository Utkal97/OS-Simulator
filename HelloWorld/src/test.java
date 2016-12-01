import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.ChartFactory; 
import org.jfree.data.general.DefaultPieDataset; 
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class test extends ApplicationFrame
{
   public test(String applicationTitle,String chartTitle,int[] page )
   {
      super(applicationTitle);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,
         "Algorithm",
         "Total time for process",
         createDataset(page),
         PlotOrientation.VERTICAL,
         true, true, false);
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      chartPanel.setLayout(null);
      
      
      JButton btnHome = new JButton("BACK");
      btnHome.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		chartPanel.setVisible(false);
      		barChart.setBorderVisible(false);
     
      	}
      });
      btnHome.setBounds(422, 324, 89, 23);
      chartPanel.add(btnHome);
   }
   private CategoryDataset createDataset(int[] pageo )
   {
	
      final String FCFS = "FCFS";        
      final String SJFPre = "SJFPre";        
      final String SJFNonPre = "SJFNonPre";        
      final String PriorPre = "PriorPre";        
      final String PriorNonPre = "PriorNonPre";        
      final String RR = "RR";        
       final String pages="pages";
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset();  

      dataset.addValue(pageo[0], pages, FCFS);       
      dataset.addValue( pageo[1], pages,SJFPre);        
      dataset.addValue( pageo[2], pages,SJFNonPre); 
      dataset.addValue( pageo[3] , pages,PriorPre);   
      dataset.addValue( pageo[4] , pages,PriorNonPre); 
      dataset.addValue( pageo[5], pages,RR); 
      
      return dataset; 
   }
   public static void main(String[] args,int[] page)
   {
      test chart = new test("Statistics", "See for yourself-",page);
      chart.pack();    
      RefineryUtilities.centerFrameOnScreen(chart );
      chart.setVisible(true);
   }
}