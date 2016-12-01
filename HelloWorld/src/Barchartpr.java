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

public class Barchartpr extends ApplicationFrame
{
   public Barchartpr(String applicationTitle,String chartTitle,int[] page )
   {
      super(applicationTitle);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,
         "Algorithm",
         "No of page replaces",
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
      		GUI.main(null);
      	}
      });
      btnHome.setBounds(422, 324, 89, 23);
      chartPanel.add(btnHome);
   }
   private CategoryDataset createDataset(int[] pageo )
   {
	
      final String FIFO = "FIFO";        
      final String SecondChance = "SecChance";        
      final String LRU = "LRU";        
      final String Opt = "Optimal";        
      final String prep="No. of page replacements";
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

      dataset.addValue(pageo[0], prep, FIFO);       
      dataset.addValue( pageo[1], prep,SecondChance);        
      dataset.addValue( pageo[2], prep,LRU); 
      dataset.addValue( pageo[3] , prep,Opt);      
      return dataset; 
   }
   public static void main(String[] args,int[] page)
   {
      Barchartpr chart = new Barchartpr("Statistics", "See for yourself-",page);
      chart.pack();    
      RefineryUtilities.centerFrameOnScreen(chart );
      chart.setVisible(true);
   }
}