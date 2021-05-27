package bsu.rfe.java.group8.lab5.Dubezhinskiy.var9A;

public class GraphicsDisplay extends JPanel {
    private ArrayList<Double[]> graphicsData;
    private ArrayList<Double[]> originalData;
    private int selectedMarker = -1;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    private double scaleX;
    private double scaleY;

    private double[][] viewport = new double[2][2];
    private ArrayList<double[][]> undoHistory = new ArrayList(5);
    private boolean showAxis = true;
    private boolean showMarkers = true;

    private Font axisFont;
    private Font labelsFont;

    private BasicStroke axisStroke;
    private BasicStroke graphicsStroke;
    private BasicStroke markerStroke;
    private BasicStroke selectionStroke;
    private static DecimalFormat formatter=(DecimalFormat)NumberFormat.getInstance();

    private boolean ShowAxis = true;
    private boolean ShowMarkers = true;
    private boolean scaleMode = false;
    private boolean changeMode = false;
    private double[] originalPoint = new double[2];
    private Rectangle2D.Double selectionRect = new Rectangle2D.Double();

    public GraphicsDisplay() {
        this.setBackground(Color.white);
        graphicsStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[] {30, 10, 20, 10, 10, 10, 20, 10}, 0.0f);
        this.axisStroke = new BasicStroke(2.0F, 0, 0, 10.0F, (float[])null, 0.0F);
        this.markerStroke = new BasicStroke(4.0F, 0, 0, 10.0F, (float[])null, 0.0F);
        this.selectionStroke = new BasicStroke(1.0F, 0, 0, 10.0F, new float[]{10.0F, 10.0F}, 0.0F);
        this.axisFont = new Font("Serif", 1, 36);
        this.labelsFont = new Font("Serif", 0, 20);
        formatter.setMaximumFractionDigits(5);
        this.addMouseListener(new GraphicsDisplay.MouseHandler());
        this.addMouseMotionListener(new GraphicsDisplay.MouseMotionHandler());
    }