package Vue;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class Chart {
	
	TimeSeries seriesPredateurs;
	TimeSeries seriesProies;
	double derniereValeur;
	//String type;
	
	@SuppressWarnings("deprecation")
	public Chart(JPanel content )
	{

		derniereValeur=0.0;
		this.seriesPredateurs = new TimeSeries("Prédateurs", Millisecond.class);
		this.seriesProies = new TimeSeries("Proies", Millisecond.class);
		
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.seriesPredateurs);
        dataset.addSeries(seriesProies);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        //final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));


	}
	
	private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Graphe des générations", 
            "Temps", 
            "Nombre d'instances ",
            dataset, 
            true, 
            true, 
            false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 10000.0); 
        return result;
    }
	
	public void actualiser(double derniereValeurPredateurs,double derniereValeurProies)
	{
	
	        seriesPredateurs.addOrUpdate(new Millisecond(), derniereValeurPredateurs);
	        seriesProies.addOrUpdate(new Millisecond(),derniereValeurProies);
	    
	}
}
