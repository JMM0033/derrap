package Vista;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.VerticalAlignment;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;

import javax.swing.JButton;

public class PdfCreator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfCreator frame = new PdfCreator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PdfCreator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Crear informe");
		btnNewButton.addActionListener(e -> {
			createReport();
		});
		contentPane.add(btnNewButton);
	}
	
	public void createReport() {
		try {
			// Fonts
			PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
			PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
			
			// Colors
			Color darkGrey = new DeviceRgb(80, 80, 80);
			Color clearWhite = new DeviceRgb(220, 220, 220);
			
			// Sizes			
			float fullWidth[] = {570f};
			float bigColumnWidth = 342f;
			float smallColumnWidth = 228f;
			float twoColumnWidth[] = {bigColumnWidth, smallColumnWidth};
			float threeColumnWidth[] = {190, 190, 190};
						
			String path = "report.pdf";
			PdfWriter pdfWriter = new PdfWriter(path);
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			pdfDocument.setDefaultPageSize(PageSize.A4);
			Document document = new Document(pdfDocument);
					
			// Create Header
			Table headerTable = new Table(twoColumnWidth);
			
			headerTable.addCell(createTextCell("Recibo", boldFont, 14));
			
			Table nestedTable = new Table(new float[]{smallColumnWidth / 2, smallColumnWidth / 2});
			nestedTable.addCell(createTextCell("Nº Pedido", boldFont, 14));
			nestedTable.addCell(createTextCell("199439593", font, 10));
			nestedTable.addCell(createTextCell("Fecha", boldFont, 14));
			nestedTable.addCell(createTextCell("12/3/2024", font, 10));
			
			headerTable.addCell(new Cell()
					.add(nestedTable).setBorder(Border.NO_BORDER));
			
			document.add(headerTable);
			
			// Create Big Divider
			Border greyBorder = new SolidBorder(darkGrey, 2f);
			Table bigDivider = new Table(fullWidth)
					.setMarginTop(20f)
					.setBorder(greyBorder);
			
			document.add(bigDivider);
			
			// Create Purchase Information
			Table purchaseTableHeader = new Table(twoColumnWidth)
					.setMarginTop(20f)
					.setMarginBottom(20f);
			purchaseTableHeader.addCell(createTextCell("Información de la compra", boldFont, 12));
			purchaseTableHeader.addCell(createTextCell("Información del envío", boldFont, 12));
			
			Table purchaseTableInfo = new Table(twoColumnWidth);
			purchaseTableHeader.addCell(createTextCell("Nombre", boldFont, 10));
			purchaseTableHeader.addCell(createTextCell("Código Postal", boldFont, 10));
			purchaseTableHeader.addCell(createTextCell("Fernando", font, 10));
			purchaseTableHeader.addCell(createTextCell("25820", font, 10));
			purchaseTableHeader.addCell(createTextCell("Apellidos", boldFont, 10));
			purchaseTableHeader.addCell(createTextCell("Dirección", boldFont, 10));
			purchaseTableHeader.addCell(createTextCell("Ramírez Herrera", font, 10));
			purchaseTableHeader.addCell(createTextCell("Calle falsa 2, Edificio La Paz. Piso 3, Puerta 2.", font, 10));
			
			document.add(purchaseTableHeader);
			document.add(purchaseTableInfo);
			
			// Create Small Divider
			Border greyThinBorder = new SolidBorder(darkGrey, 0.8f);
			Table smallDivider = new Table(fullWidth)
					.setMarginTop(10f)
					.setBorder(greyThinBorder);
			
			document.add(smallDivider);
			
			// Create Products Table
			document.add(new Paragraph(new Text("Productos").setFont(boldFont).setFontSize(14)));
			
			Table productTableTitles = new Table(threeColumnWidth);
			productTableTitles.setBackgroundColor(darkGrey, 0.8f);
			productTableTitles.addCell(createColoredTextCell("ID", boldFont, 12, clearWhite));
			productTableTitles.addCell(createColoredTextCell("Nombre", boldFont, 12, clearWhite));
			productTableTitles.addCell(createColoredTextCell("Precio", boldFont, 12, clearWhite));
			
			Table productTable = new Table(threeColumnWidth);
			productTable.addCell(createTextCell("143", font, 10));
			productTable.addCell(createTextCell("Nintendo Switch", font, 10));
			productTable.addCell(createTextCell("340", font, 10));
			productTable.addCell(createTextCell("20", font, 10));
			productTable.addCell(createTextCell("Auriculares Inalambricos Sony", font, 10));
			productTable.addCell(createTextCell("50", font, 10));
			productTable.addCell(createTextCell("5908", font, 10));
			productTable.addCell(createTextCell("Doritos Tex Mex", font, 10));
			productTable.addCell(createTextCell("2", font, 10));
			productTable.addCell(createTextCell("", font, 10));
			productTable.addCell(createTextCell("Total", boldFont, 10));
			productTable.addCell(createTextCell("392", boldFont, 10));
			
			
			document.add(productTableTitles);
			document.add(productTable);
						
			
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Cell createTextCell(String text, PdfFont font, float fontSize) {
		return new Cell()
				.setVerticalAlignment(VerticalAlignment.MIDDLE)
				.add(new Paragraph(new Text(text).setFont(font).setFontSize(fontSize)))
				.setBorder(Border.NO_BORDER);
	}
	
	public Cell createColoredTextCell(String text, PdfFont font, float fontSize, Color color) {
		return new Cell()
				.setVerticalAlignment(VerticalAlignment.MIDDLE)
				.add(new Paragraph(new Text(text).setFont(font).setFontSize(fontSize).setFontColor(color)))
				.setBorder(Border.NO_BORDER);
	}

}
